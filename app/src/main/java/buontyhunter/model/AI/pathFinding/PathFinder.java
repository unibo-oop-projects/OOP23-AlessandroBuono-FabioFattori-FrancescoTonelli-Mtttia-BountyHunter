package buontyhunter.model.AI.pathFinding;

import buontyhunter.common.Point2d;
import java.util.List;

import java.util.Set;

import buontyhunter.model.Tile;

public interface PathFinder {
    List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map, Set<Point2d> invalidPoints);
}
