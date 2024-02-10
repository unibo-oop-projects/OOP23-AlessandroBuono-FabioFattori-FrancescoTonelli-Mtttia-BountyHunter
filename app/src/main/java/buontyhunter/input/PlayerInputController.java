package buontyhunter.input;

import buontyhunter.common.Vector2d;
import buontyhunter.core.GameFactory;
import buontyhunter.model.GameObject;
import buontyhunter.model.*;

/**
 * PlayerInputController
 */
public class PlayerInputController implements InputComponent {

	private final double speed = 0.3;


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
		
			
			
		if(c.isAttackUp()){
			instanceAttack((PlayerEntity)player, 0, 1);
		}
		else if(c.isAttackDown()){
			instanceAttack((PlayerEntity)player, 0, -1);
		}
		else if(c.isAttackLeft()){
			instanceAttack((PlayerEntity)player, -1, 0);
		}
		else if(c.isAttackRight()){
			instanceAttack((PlayerEntity)player, 1, 0);
		}
		else{
			((PlayerEntity)player).getWeapon().getDamagingArea().setShow(false);
		}


		player.setVel(vel);
		var pos = player.getPos();

		player.setPos(pos.sum(vel));
	}

	private void instanceAttack(PlayerEntity player, int x, int y){

		((PlayerEntity)player).getWeapon().setDamagingArea(GameFactory.getInstance().WeaponDamagingArea((PlayerEntity)player, new Vector2d(x,y)));

		((PlayerEntity)player).getWeapon().getDamagingArea().setShow(true);
	}

}