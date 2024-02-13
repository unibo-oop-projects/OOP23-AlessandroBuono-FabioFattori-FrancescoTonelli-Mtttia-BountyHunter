package buontyhunter.input;

import buontyhunter.common.Direction;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.PlayerEntity;
import buontyhunter.model.World;

/**
 * PlayerInputController
 */
public class PlayerInputController implements InputComponent {

	private final double speed = 0.3;

	@Override
	public void update(GameObject player, InputController c, World w) {
		Vector2d vel = new Vector2d(0, 0);

		if (c.isMoveUp()) {
			vel.y -= speed;
			setDirection(player, Direction.MOVE_UP);
		}
		else if (c.isMoveDown()) {
			vel.y += speed;
			setDirection(player, Direction.MOVE_DOWN);
		}
		else if (c.isMoveLeft()) {
			vel.x -= speed;
			setDirection(player, Direction.MOVE_LEFT);
		}
		else if (c.isMoveRight()) {
			vel.x += speed;
			setDirection(player, Direction.MOVE_RIGHT);
		}
		else if(c.isAttackUp()){
			setDirection(player, Direction.STAND_UP);
		}
		else if(c.isAttackLeft()){
			setDirection(player, Direction.STAND_LEFT);
		}
		else if(c.isAttackRight()){
			setDirection(player, Direction.STAND_RIGHT);
		}
		else{
			setDirection(player, Direction.STAND_DOWN);
		}
		
		player.setVel(vel);
		var pos = new Point2d(player.getPos().x, player.getPos().y+1); // +1 per simulare lo shift che c'è nel disegno

		if(w.getTileManager().getTileFromPosition(pos.sum(vel)).get().isSolid()|| w.getTileManager().getTileFromPosition(pos.sum(vel.sum(vel))).get().isObstacle()){
			return;
		}
		pos = new Point2d(player.getPos().x, player.getPos().y);
		player.setPos(pos.sum(vel));
	}

	private void setDirection(GameObject player, Direction direction){
		if(player instanceof PlayerEntity){
			((PlayerEntity)player).setDirection(direction);
		}
	}
}