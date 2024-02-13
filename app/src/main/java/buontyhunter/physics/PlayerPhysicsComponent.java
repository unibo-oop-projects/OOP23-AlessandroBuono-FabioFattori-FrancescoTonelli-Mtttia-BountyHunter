package buontyhunter.physics;

import buontyhunter.common.Point2d;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.PlayerEntity;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;

public class PlayerPhysicsComponent extends PhysicsComponent {

    private final int MAX_WAITING_TIME = 15;
    private final int WAITING_TIME_AFTER_HIT = MAX_WAITING_TIME * 13;
    private int waitingTime = MAX_WAITING_TIME;
    private int oldHealth = -1;

    static Point2d FINAL_POINT = new Point2d(3, 3);

    public void update(long dt, GameObject obj, World w) {

        // health regen algorithm
        int health = ((PlayerEntity) obj).getHealth();
        if (oldHealth == -1) {
            oldHealth = health;
        } else if (oldHealth > health) { // if health is decreasing, reset waiting time beacuse player is damaged
            waitingTime = WAITING_TIME_AFTER_HIT;
        }

        if (health < ((PlayerEntity) obj).getMaxHealth()) {
            if (waitingTime <= 0) {

                health += 3;
                waitingTime = MAX_WAITING_TIME;
                ((PlayerEntity) obj).setHealth(health);
            } else {
                waitingTime--;

            }

        }

        oldHealth = health;

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
