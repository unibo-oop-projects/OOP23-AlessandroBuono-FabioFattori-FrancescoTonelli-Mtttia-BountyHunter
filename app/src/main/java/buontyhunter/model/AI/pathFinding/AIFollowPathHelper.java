package buontyhunter.model.AI.pathFinding;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.Tile;

public class AIFollowPathHelper {
    PathFinder pathFinder;
    Point2d current;
    Point2d lastPointCurrent;
    Point2d destination;
    Iterator<Point2d> pathIterator;

    public AIFollowPathHelper(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
        pathIterator = emptyIterator();
    }

    private Iterator<Point2d> emptyIterator() {
        return new Iterator<Point2d>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Point2d next() {
                return null;
            }
        };
    }

    private void generateIterator(Point2d current, Point2d destination, List<List<Tile>> map) {
        var path = pathFinder.findPath(current, destination, map);
        if (path.size() > 1) {
            pathIterator = path.iterator();
            pathIterator.next();
        } else {
            pathIterator = emptyIterator();
        }
    }

    private boolean canUsePreviousIterator(Point2d current, Point2d destination) {
        return pathIterator.hasNext()
                && this.current == current
                && this.destination == destination;
    }

    public Point2d moveItem(Point2d current, Point2d destination, Vector2d speed, List<List<Tile>> map) {
        var movement = current.duplicate();
        this.current = current;
        this.destination = destination;
        if (!canUsePreviousIterator(current, destination)) {
            generateIterator(current, destination, map);
        }

        if (pathIterator.hasNext()) {
            // go forward with speed since you can
            Vector2d speedLeft = speed.duplicate();
            while ((speedLeft.x != 0 || speedLeft.y != 0) && pathIterator.hasNext()) {
                // speed must always be positive
                var nextPoint = pathIterator.next();
                var deltaX = nextPoint.x - current.x;
                var deltaY = nextPoint.y - current.y;

                if ((deltaX != 0 && speedLeft.x == 0 || deltaX == 0)
                        && (deltaY != 0 && speedLeft.y == 0 || deltaY == 0)) {
                    break;
                }

                var absDeltaX = Math.abs(deltaX);
                var absDeltaY = Math.abs(deltaY);
                var sumVector = new Vector2d(
                        speedLeft.x > absDeltaX ? deltaX : speedLeft.x * Math.signum(deltaX),
                        speedLeft.y > absDeltaY ? deltaY : speedLeft.y * Math.signum(deltaY));
                movement = current.duplicate().sum(sumVector);
                speedLeft = new Vector2d(
                        speedLeft.x > absDeltaX ? speedLeft.x - absDeltaX : 0,
                        speedLeft.y > absDeltaY ? speedLeft.y - absDeltaY : 0);
            }
        }

        return movement;
    }
}
