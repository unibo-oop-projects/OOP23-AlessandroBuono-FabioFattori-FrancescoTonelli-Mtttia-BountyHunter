package buontyhunter.physics;

import buontyhunter.common.*;
import buontyhunter.model.*;

public abstract class PhysicsComponent {
	/**
	 * update the position of the object
	 * @param dt the time since the last update
	 * @param obj the object to update
	 * @param w the world the object is in
	 */
	public void update(long dt, GameObject obj, World w) {
		Point2d pos = obj.getPos();
		Vector2d vel = obj.getVel();
		obj.setPos(pos.sum(vel.mul(0.001 * dt)));
	}
}
