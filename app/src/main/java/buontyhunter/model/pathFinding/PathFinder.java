package buontyhunter.model.pathFinding;

import buontyhunter.common.Point2d;
import java.util.List;
import buontyhunter.model.Tile;

public interface PathFinder {
    public List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map);
}
