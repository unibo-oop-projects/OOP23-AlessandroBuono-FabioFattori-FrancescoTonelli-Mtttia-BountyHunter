package buontyhunter.model.AI.pathFinding;

import buontyhunter.common.Point2d;
import java.util.List;

import java.util.Set;

import buontyhunter.model.Tile;

public interface PathFinder {

    /**
     * Find a path from the initial point to the final point
     * 
     * @param initialPoint  the initial point
     * @param finalPoint    the final point
     * @param map           the map
     * @param invalidPoints the invalid points
     * @return the path
     */
    List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map, Set<Point2d> invalidPoints);
}
