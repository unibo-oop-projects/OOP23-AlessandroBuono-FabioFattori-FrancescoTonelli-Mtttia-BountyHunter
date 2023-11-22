package buontyhunter.model;

import buontyhunter.Common.Point2d;

public class CollisionDetector {

    public boolean isColliding(RectBoundingBox rect1, RectBoundingBox rect2) {
        // Calculate the corners of the rectangles
        double rect1Left = rect1.getULCorner().x;
        double rect1Right = rect1.getULCorner().x + rect1.getWidth();
        double rect1Top = rect1.getULCorner().y;
        double rect1Bottom = rect1.getULCorner().y - rect1.getHeight();

        double rect2Left = rect2.getULCorner().x;
        double rect2Right = rect2.getULCorner().x + rect2.getWidth();
        double rect2Top = rect2.getULCorner().y;
        double rect2Bottom = rect2.getULCorner().y - rect2.getHeight();

        // Check for overlap in both x and y axes
        if (rect1Left < rect2Right && rect1Right > rect2Left &&
                rect1Top > rect2Bottom && rect1Bottom < rect2Top) {
            return true; // Colliding
        } else {
            return false; // Not colliding
        }
    }

    public boolean isColliding(RectBoundingBox rect, Point2d point) {
        double rectLeft = rect.getULCorner().x;
        double rectRight = rect.getULCorner().x + rect.getWidth();
        double rectTop = rect.getULCorner().y;
        double rectBottom = rect.getULCorner().y - rect.getHeight();

        if (point.x > rectLeft && point.x < rectRight &&
                point.y < rectTop && point.y > rectBottom) {
            return true; // Colliding
        } else {
            return false; // Not colliding
        }
    }

    final double CIRCLE_APPROXIMATION_FACTOR = 1;

    public boolean isColliding(RectBoundingBox rect, CircleBoundingBox circle) {
        // // Find the closest point on the rectangle to the circle's center
        // double closestX = clamp(circle.getCenter().x, rect.getULCorner().x,
        // rect.getULCorner().x + rect.getWidth());
        // double closestY = clamp(circle.getCenter().y, rect.getULCorner().y,
        // rect.getULCorner().y + rect.getHeight());

        // // Calculate the distance between the closest point and the circle's center
        // double distanceX = circle.getCenter().x - closestX;
        // double distanceY = circle.getCenter().y - closestY;
        // double distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);

        // // Check if the distance is less than or equal to the circle's radius squared
        // return distanceSquared <= (circle.getRadius() * circle.getRadius());
        // approximate the circle with a square
        double newRadius = circle.getRadius() * CIRCLE_APPROXIMATION_FACTOR;
        Point2d approximatedULCorner = new Point2d(circle.getCenter().x - newRadius, circle.getCenter().y + newRadius);
        Point2d approximatedBRCorner = new Point2d(circle.getCenter().x + newRadius, circle.getCenter().y - newRadius);
        RectBoundingBox approximatedCircle = new RectBoundingBox(approximatedULCorner, approximatedBRCorner);
        return isColliding(rect, approximatedCircle);
    }

    public boolean isCollidingOnAxis(RectBoundingBox rect, CircleBoundingBox circle) {
        boolean collisionOnLeft = isColliding(rect,
                new Point2d(circle.getCenter().x - circle.getRadius(), circle.getCenter().y));
        boolean collisionOnRight = isColliding(rect,
                new Point2d(circle.getCenter().x + circle.getRadius(), circle.getCenter().y));
        boolean collisionOnTop = isColliding(rect,
                new Point2d(circle.getCenter().x, circle.getCenter().y + circle.getRadius()));
        boolean collisionOnBottom = isColliding(rect,
                new Point2d(circle.getCenter().x, circle.getCenter().y - circle.getRadius()));

        return collisionOnLeft || collisionOnRight || collisionOnTop || collisionOnBottom;
    }

    // Helper method to clamp a value between a minimum and maximum range
    // private double clamp(double val, double min, double max) {
    // return Math.max(min, Math.min(max, val));
    // }

    public boolean isColliding(CircleBoundingBox circle, RectBoundingBox rect) {
        return isColliding(rect, circle);
    }

    public boolean isColliding(CircleBoundingBox circle1, CircleBoundingBox circle2) {
        Point2d center1 = circle1.getCenter();
        Point2d center2 = circle2.getCenter();
        double radius1 = circle1.getRadius();
        double radius2 = circle2.getRadius();
        double distanceX = center1.x - center2.x;
        double distanceY = center1.y - center2.y;
        double distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
        return distanceSquared < ((radius1 + radius2) * (radius1 + radius2));
    }
}