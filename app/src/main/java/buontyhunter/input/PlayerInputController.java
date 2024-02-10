package buontyhunter.input;

import buontyhunter.common.Vector2d;
import buontyhunter.model.GameObject;

/**
 * PlayerInputController
 */
public class PlayerInputController implements InputComponent {

	private final double speed = 0.3;
	private boolean isAttacking=false;

	@Override
	public void update(GameObject player, InputController c) {
		Vector2d vel = new Vector2d(0, 0);

		if (c.isMoveUp()) {
			vel.y -= speed;
		}
		if (c.isMoveDown()) {
			vel.y += speed;
		}
		if (c.isMoveLeft()) {
			vel.x -= speed;
		}
		if (c.isMoveRight()) {
			vel.x += speed;
		}

		//Controls if the player is already executing an attack
		if(!isAttacking){
			
			if(c.isAttackUp()){

			}
			if(c.isAttackDown()){
				
			}
			if(c.isAttackLeft()){
				
			}
			if(c.isAttackRight()){
				
			}
			isAttacking=true;

		}

		


		player.setVel(vel);
		var pos = player.getPos();

		player.setPos(pos.sum(vel));
	}
}