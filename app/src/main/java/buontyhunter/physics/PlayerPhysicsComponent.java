package buontyhunter.physics;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;

public class PlayerPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        // cannot go out of bounds
        var collisionWidthWorld = w.checkCollisionWithBoundaries(obj.getPos(), ((RectBoundingBox) obj.getBBox()));

        if (collisionWidthWorld.isPresent()) {
            var collision = collisionWidthWorld.get();
            // var pos = obj.getPos();

            obj.setPos(collision.getWhere());
        }
    }

}
