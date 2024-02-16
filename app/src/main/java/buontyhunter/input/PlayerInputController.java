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
	private boolean isAttacking = false;

	@Override
	public void update(GameObject player, InputController c, World w) {
		Vector2d vel = new Vector2d(0, 0);

		if (c.isMoveUp()) {
			isAttacking = false;
			vel.y -= speed;
			setDirection(player, Direction.MOVE_UP);
		} else if (c.isMoveDown()) {
			isAttacking = false;
			vel.y += speed;
			setDirection(player, Direction.MOVE_DOWN);
		} else if (c.isMoveLeft()) {
			isAttacking = false;
			vel.x -= speed;
			setDirection(player, Direction.MOVE_LEFT);
		} else if (c.isMoveRight()) {
			isAttacking = false;
			vel.x += speed;
			setDirection(player, Direction.MOVE_RIGHT);
		}
		else if (!isAttacking){
			setDirection(player, Direction.STAND_DOWN);
		}
	

		if (timer <= 0) {
			

			if (c.isAttackUp()) {
				isAttacking = true;
				setTimer(player);
				setDirection(player, Direction.STAND_UP);
				instanceAttack((PlayerEntity) player, 0, -1);
				
			} else if (c.isAttackDown()) {
				isAttacking = true;
				setTimer(player);
				setDirection(player, Direction.STAND_DOWN);
				instanceAttack((PlayerEntity) player, 0, 1);

			} else if (c.isAttackLeft()) {
				isAttacking = true;
				setTimer(player);
				
				setDirection(player, Direction.STAND_LEFT);
				instanceAttack((PlayerEntity) player, -1, 0);
			} else if (c.isAttackRight()) {
				isAttacking = true;
				setTimer(player);
				
				setDirection(player, Direction.STAND_RIGHT);
				instanceAttack((PlayerEntity) player, 1, 0);
			}

		} else {
			if (((FighterEntity) player).getDamagingArea() == null) {
				instanceAttack((PlayerEntity) player, 0, 0);
			}

			if (timer > 0) {
				timer--;
			}
		}

		player.setVel(vel);
		var pos = new Point2d(player.getPos().x, player.getPos().y + 1); // +1 per simulare lo shift che c'è nel disegno

		if (w.getTileManager().getTileFromPosition(pos.sum(vel)).isPresent()) {
			if (w.getTileManager().getTileFromPosition(pos.sum(vel)).get().isSolid()
					|| w.getTileManager().getTileFromPosition(pos.sum(vel)).get().isObstacle()) {
				return;
			}
		}
		pos = new Point2d(player.getPos().x, player.getPos().y);
		player.setPos(pos.sum(vel));
	}

	private void instanceAttack(PlayerEntity player, int x, int y) {

		((PlayerEntity) player).setDamagingArea(
				GameFactory.getInstance().WeaponDamagingArea((PlayerEntity) player, new Vector2d(x, y)));
		player.getWeapon().directAttack();

		((PlayerEntity) player).getDamagingArea().setShow(true);

		// TODO wait(1000);
	}

	private void setTimer(GameObject player) {
		timer = 30 / ((PlayerEntity) player).getWeapon().getAttackSpeed();
	}

	private void setDirection(GameObject player, Direction direction) {
		if (player instanceof PlayerEntity) {
			((PlayerEntity) player).setDirection(direction);
		}
	}
}