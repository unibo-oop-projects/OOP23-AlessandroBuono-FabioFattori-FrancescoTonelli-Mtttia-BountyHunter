package buontyhunter.input;

import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class PlayerAttackingController implements InputComponent {

	private boolean isAttacking = false;

	@Override
	public void update(GameObject ball, InputController c, World w) {
		// Controls if the player is already executing an attack
		if (!isAttacking) {

			if (c.isAttackUp()) {

			}
			if (c.isAttackDown()) {

			}
			if (c.isAttackLeft()) {

			}
			if (c.isAttackRight()) {

			}
			isAttacking = true;

		}
	}

}
