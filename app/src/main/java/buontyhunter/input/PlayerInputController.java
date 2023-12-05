package buontyhunter.input;

import buontyhunter.common.Vector2d;
import buontyhunter.model.GameObject;

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

		player.setVel(vel);
		var pos = player.getPos();

		player.setPos(pos.sum(vel));
	}
}