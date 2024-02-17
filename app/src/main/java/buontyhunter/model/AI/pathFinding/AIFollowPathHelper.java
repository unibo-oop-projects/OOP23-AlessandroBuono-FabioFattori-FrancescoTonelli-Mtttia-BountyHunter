package buontyhunter.model.AI.pathFinding;

import java.util.*;

import com.google.common.collect.Iterables;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.Tile;
import buontyhunter.model.TileType;

public class AIFollowPathHelper {
    PathFinder pathFinder;
    Point2d current;
    Point2d lastPointCurrent;
    Point2d destination;
    Iterator<Point2d> pathIterator;
    Point2d nextPoint = null;
    List<Point2d> actualPath = new ArrayList<>();

    public AIFollowPathHelper(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
        pathIterator = emptyIterator();
    }

    public Point2d moveItem(Point2d current, Point2d destination, Vector2d speed, List<List<Tile>> map) {
        var movement = current.duplicate();
        if (!canUsePreviousIterator(current, destination)) {
            generateIterator(current, destination, map, new HashSet<>());
        }
        this.current = current;
        this.destination = destination;

        Vector2d speedLeft = speed.duplicate();

        // go forward with speed since you can
        while ((speedLeft.x > 0 || speedLeft.y > 0) && nextPoint != null) {
            // speed must always be positive

            var deltaX = nextPoint.x - movement.x;
            var deltaY = nextPoint.y - movement.y;

            /// if different X or Y to next point is 0 but speedLeft X or Y is not 0, then
            /// exit from while cause it would loop
            /// if is first run force the play
            if ((deltaX != 0 && speedLeft.x <= 0 || deltaX == 0)
                    && (deltaY != 0 && speedLeft.y <= 0 || deltaY == 0)) {
                break;
            }

            var absDeltaX = Math.abs(deltaX);
            var absDeltaY = Math.abs(deltaY);
            /// for calculating the vector witch represent the current movement just
            /// if can go to next point, then go, else go forward for speedLeft
            var sumVector = new Vector2d(
                    speedLeft.x > absDeltaX ? deltaX : speedLeft.x * Math.signum(deltaX),
                    speedLeft.y > absDeltaY ? deltaY : speedLeft.y * Math.signum(deltaY));
            movement = movement.duplicate().sum(sumVector);
            speedLeft = new Vector2d(
                    Math.max(speedLeft.x - absDeltaX, 0),
                    Math.max(speedLeft.y - absDeltaY, 0));

            // if pass over water then directly go to next point
            if (isTileWater(map, movement)) {
                movement = nextPoint.duplicate();
            }

            if (pathIterator.hasNext() && movement.equals(nextPoint)) {
                nextPoint = pathIterator.next();
            } else {
                nextPoint = null;
            }
        }

        return movement;
    }

    public int getLastPathDistance() {
        return actualPath.size();
    }

    private boolean isTileWater(List<List<Tile>> map, Point2d pos) {
        return map.get((int) pos.y).get((int) pos.x).getType() == TileType.water;
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

    private void generateIterator(Point2d current, Point2d destination, List<List<Tile>> map,
            Set<Point2d> invalidPoints) {
        actualPath = pathFinder.findPath(current, destination, map, invalidPoints);
        if (actualPath.size() > 1) {
            pathIterator = actualPath.iterator();
            pathIterator.next();
            nextPoint = pathIterator.next();
        } else {
            pathIterator = emptyIterator();
        }
    }

    private boolean canUsePreviousIterator(Point2d current, Point2d destination) {
        return pathIterator.hasNext()
                && this.current.equals(current)
                && this.destination.equals(destination);
    }
}
