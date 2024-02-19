package buontyhunter;

import buontyhunter.common.Point2d;
import buontyhunter.model.CircleBoundingBox;
import buontyhunter.model.CollisionDetector;
import buontyhunter.model.RectBoundingBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionDetectorTest {

    @Test
    void testRectangleCollision() {
        RectBoundingBox rect1 = new RectBoundingBox(new Point2d(0, 0), 5, 5);
        RectBoundingBox rect2 = new RectBoundingBox(new Point2d(3, 3), 5, 5);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertTrue(collisionDetector.isColliding(rect1, rect2));
    }

    @Test
    void testRectangleNonCollision() {
        RectBoundingBox rect1 = new RectBoundingBox(new Point2d(0, 0), 5, 5);
        RectBoundingBox rect2 = new RectBoundingBox(new Point2d(6, 6), 5, 5);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertFalse(collisionDetector.isColliding(rect1, rect2));
    }

    @Test
    void testCircleRectangleCollision() {
        CircleBoundingBox circle = new CircleBoundingBox(new Point2d(0, 0), 3);
        RectBoundingBox rect = new RectBoundingBox(new Point2d(2, 2), 4, 4);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertTrue(collisionDetector.isColliding(rect, circle));
    }

    @Test
    void testCircleRectangleNonCollision() {
        CircleBoundingBox circle = new CircleBoundingBox(new Point2d(0, 0), 3);
        RectBoundingBox rect = new RectBoundingBox(new Point2d(5, 5), 4, 4);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertFalse(collisionDetector.isColliding(rect, circle));
    }

    @Test
    void testCircleCollision() {
        CircleBoundingBox circle1 = new CircleBoundingBox(new Point2d(0, 0), 3);
        CircleBoundingBox circle2 = new CircleBoundingBox(new Point2d(4, 0), 3);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertTrue(collisionDetector.isColliding(circle1, circle2));
    }

    @Test
    void testCircleNonCollision() {
        CircleBoundingBox circle1 = new CircleBoundingBox(new Point2d(0, 0), 3);
        CircleBoundingBox circle2 = new CircleBoundingBox(new Point2d(8, 0), 3);
        CollisionDetector collisionDetector = new CollisionDetector();

        assertFalse(collisionDetector.isColliding(circle1, circle2));
    }
}