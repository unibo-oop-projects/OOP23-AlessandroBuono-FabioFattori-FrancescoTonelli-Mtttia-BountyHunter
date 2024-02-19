package buontyhunter.physics;

import buontyhunter.model.CollisionDetector;
import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;
import buontyhunter.model.event.ChangeWorldEvent;

public class TeleporterPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        // check if the player make a collision with this obj
        CollisionDetector detector = new CollisionDetector();

        try {
            if (detector.isColliding((RectBoundingBox) w.getTeleporter().getBBox(), w.getPlayer().getPos())) {
                w.notifyWorldEvent(new ChangeWorldEvent(w.getTeleporter().getMapIdOfDestination(), w));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}