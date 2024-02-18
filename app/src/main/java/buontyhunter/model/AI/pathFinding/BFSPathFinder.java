package buontyhunter.model.AI.pathFinding;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.model.Tile;

/**
 * Breadth-first search path finder
 */
public class BFSPathFinder implements PathFinder {

    private boolean useCache = false;
    Map<Point2d, Point2d> parentMap;

    /**
     * Create a new BFS path finder
     * 
     * @param useCache if the path finder should use cache
     */
    public BFSPathFinder(boolean useCache) {
        this.useCache = useCache;
        parentMap = new HashMap<>();
    }

    /**
     * Clear the cache
     */
    public void clearCache() {
        parentMap.clear();
    }

    /**
     * Set if the path finder should use cache
     * 
     * @param useCache if the path finder should use cache
     */
    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    @Override
    public List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map,
            Set<Point2d> invalidPoints) {
        // Initialize visited set and queue for BFS
        initialPoint = initialPoint.duplicate().floorCoordinates();
        finalPoint = finalPoint.duplicate().floorCoordinates();
        Set<Point2d> visited = new HashSet<>();
        Queue<Point2d> queue = new LinkedList<>();
        if (!useCache)
            parentMap.clear();

        if (isSolid(initialPoint, map) || isSolid(finalPoint, map)) {
            // No path found
            return Collections.emptyList();
        }

        queue.offer(finalPoint);
        visited.add(finalPoint);
        parentMap.put(finalPoint, null);

        while (!queue.isEmpty()) {
            Point2d current = queue.poll();

            if (current.equals(initialPoint) || isPointAlreadySolved(current)) {
                // Path found, reconstruct the path and return it
                return reconstructPath(parentMap, initialPoint);
            }

            for (Point2d neighbor : getNeighbors(current, map)) {
                if (!visited.contains(neighbor) && !isSolid(neighbor, map)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private boolean isPointAlreadySolved(Point2d point) {
        if (!useCache)
            return false;

        return parentMap.containsKey(point);
    }

    private boolean isSolid(Point2d point, List<List<Tile>> map) {
        return map.get((int) point.y).get((int) point.x).isSolid();
    }

    // Helper method to get neighboring points
    private List<Point2d> getNeighbors(Point2d point, List<List<Tile>> map) {
        List<Point2d> neighbors = new ArrayList<>();
        int rows = map.size();
        int cols = map.get(0).size();

        int[] dx = { -1, 1, 0 }; // Changes in x for left, right, up, down
        int[] dy = { -1, 1, 0 }; // Changes in y for left, right, up, down

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newX = (int) point.x + dx[i];
                int newY = (int) point.y + dy[j];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    neighbors.add(new Point2d(newX, newY));
                }
            }
        }

        return neighbors;
    }

    // Helper method to reconstruct the path from final point to initial point
    private List<Point2d> reconstructPath(Map<Point2d, Point2d> parentMap, Point2d finalPoint) {
        List<Point2d> path = new ArrayList<>();
        Point2d current = finalPoint;

        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }
}
