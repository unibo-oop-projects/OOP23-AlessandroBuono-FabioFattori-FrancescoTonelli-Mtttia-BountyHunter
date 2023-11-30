package buontyhunter.physics;

import buontyhunter.common.Point2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;

public class PlayerPhysicsComponent extends PhysicsComponent {

    static Point2d FINAL_POINT = new Point2d(2, 0);

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

        // think about navigation line
        var navigationLine = w.getNavigatorLine();
        if (navigationLine != null) {
            navigationLine.setPath(obj.getPos(), FINAL_POINT);
        }
    }

}
