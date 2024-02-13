package buontyhunter.model.AI.pathFinding;

import buontyhunter.common.Point2d;
import java.util.List;
import buontyhunter.model.Tile;

public interface PathFinder {
    List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map);

    static PathFinder AStar(boolean useCache) {
        return new AStarPathFinder(useCache);
    }

    static PathFinder BFS(boolean useCache) {
        return new BFSPathFinder(useCache);
    }
}
