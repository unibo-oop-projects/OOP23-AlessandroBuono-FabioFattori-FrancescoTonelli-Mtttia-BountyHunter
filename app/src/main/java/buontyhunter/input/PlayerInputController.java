package buontyhunter.input;

import buontyhunter.common.Direction;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.model.GameObject;
import buontyhunter.model.*;

/**
 * PlayerInputController
 */
public class PlayerInputController implements InputComponent {

	private final double speed = 0.3;
	private double timer;

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

		//Controls if the player is already executing an attack
		
			
		if(timer <= 0){

			if(c.isAttackUp()){
				instanceAttack((PlayerEntity)player, 0, -1);
				setTimer(player);
				setDirection(player, Direction.STAND_UP);
			}
			else if(c.isAttackDown()){
				instanceAttack((PlayerEntity)player, 0, 1);
				setTimer(player);
				setDirection(player, Direction.STAND_DOWN);
				
			}
			else if(c.isAttackLeft()){
				instanceAttack((PlayerEntity)player, -1, 0);
				setTimer(player);
				
				setDirection(player, Direction.STAND_LEFT);
			}
			else if(c.isAttackRight()){
				instanceAttack((PlayerEntity)player, 1, 0);
				setTimer(player);
				
				setDirection(player, Direction.STAND_RIGHT);
			}
			
		}
		else{
			if(((FighterEntity)player).getDamagingArea() == null){
				instanceAttack((PlayerEntity)player, 0, 0);
			}
			
			((PlayerEntity)player).getDamagingArea().setShow(false);

			if(timer>0){
				timer--;
			}
		}
		
		player.setVel(vel);
		var pos = new Point2d(player.getPos().x, player.getPos().y+1); // +1 per simulare lo shift che c'è nel disegno

		if(w.getTileManager().getTileFromPosition(pos.sum(vel)).get().isSolid()|| w.getTileManager().getTileFromPosition(pos.sum(vel.sum(vel))).get().isObstacle()){
			return;
		}
		player.setPos(pos.sum(vel));
	}

	private void instanceAttack(PlayerEntity player, int x, int y){

		((PlayerEntity)player).setDamagingArea(GameFactory.getInstance().WeaponDamagingArea((PlayerEntity)player, new Vector2d(x,y)));
		player.getWeapon().directAttack();

		((PlayerEntity)player).getDamagingArea().setShow(true);
		
		//TODO wait(1000);
	}

	private void setTimer(GameObject player){
		timer=30/((PlayerEntity)player).getWeapon().getAttackSpeed();
	}

	private void setDirection(GameObject player, Direction direction){
		if(player instanceof PlayerEntity){
			((PlayerEntity)player).setDirection(direction);
		}
	}
}