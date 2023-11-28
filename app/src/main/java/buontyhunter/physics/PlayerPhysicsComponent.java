package buontyhunter.physics;

import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;

public class PlayerPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        // cannot go out of bounds
        boolean collisionPresent = true;
        do {
            var collisionWidthWorld = w.checkCollisionWithBoundaries(obj.getPos(), ((RectBoundingBox) obj.getBBox()));
            collisionPresent = false;

            if (collisionWidthWorld.isPresent()) {
                collisionPresent = true;
                var collision = collisionWidthWorld.get();
                // var pos = obj.getPos();

                obj.setPos(collision.getWhere());
            }
        } while (collisionPresent);
    }

}
