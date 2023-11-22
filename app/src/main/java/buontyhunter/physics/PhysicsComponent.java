package buontyhunter.physics;

import buontyhunter.Common.*;
import buontyhunter.model.*;

public abstract class PhysicsComponent {

	public void update(long dt, GameObject obj, World w) {
		Point2d pos = obj.getPos();
		Vector2d vel = obj.getVel();
		obj.setPos(pos.sum(vel.mul(0.001 * dt)));
	}
}
