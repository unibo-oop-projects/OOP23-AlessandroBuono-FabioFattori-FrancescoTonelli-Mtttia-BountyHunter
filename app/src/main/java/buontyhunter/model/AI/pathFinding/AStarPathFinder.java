package buontyhunter.model.AI.pathFinding;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.model.Tile;

public class AStarPathFinder implements PathFinder {

    private final double DIAGONAL_COST = 1; // Cost of diagonal movement
    private final Map<Pair<Point2d, Point2d>, List<Point2d>> pathCache = new HashMap<>();
    private boolean useCache = true;
    private boolean passNearObstacle = false;

    public AStarPathFinder(boolean useCache) {
        this.useCache = useCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
        if (!useCache) {
            clearCache();
        }
    }

    public Point2d ensurePoint(Point2d point, List<List<Tile>> map) {
        Point2d outPoint = new Point2d(Math.ceil(point.x), Math.ceil(point.y));

        if (isObstacle(outPoint, map)) {
            outPoint = new Point2d(Math.ceil(point.x), Math.floor(point.y));
        }
        if (isObstacle(outPoint, map)) {
            outPoint = new Point2d(Math.floor(point.x), Math.ceil(point.y));
        }
        if (isObstacle(outPoint, map)) {
            outPoint = new Point2d(Math.floor(point.x), Math.floor(point.y));
        }

        return outPoint;
    }

    @Override
    public List<Point2d> findPath(Point2d initialPoint, Point2d finalPoint, List<List<Tile>> map) {
        if (useCache && pathCache.containsKey(new Pair<>(initialPoint, finalPoint))) {
            return pathCache.get(new Pair<>(initialPoint, finalPoint));
        }

        initialPoint = ensurePoint(initialPoint, map);
        finalPoint = ensurePoint(finalPoint, map);

        if (isObstacle(initialPoint, map) || isObstacle(finalPoint, map)) {
            return Collections.emptyList();
        }

        Set<Point2d> closedSet = new HashSet<>();
        PriorityQueue<Node> openQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Map<Point2d, Node> nodes = new HashMap<>();

        Node initialNode = new Node(initialPoint, null, 0, heuristic(initialPoint, finalPoint));
        openQueue.offer(initialNode);
        nodes.put(initialPoint, initialNode);

        while (!openQueue.isEmpty()) {
            Node current = openQueue.poll();
            closedSet.add(current.point);

            if (current.point.equals(finalPoint)) {
                List<Point2d> path = reconstructPath(current);
                if (useCache) {
                    pathCache.put(new Pair<>(initialPoint, finalPoint), path);
                }
                return path;
            }

            for (Point2d neighborPoint : getNeighbors(current.point, map)) {
                if (isObstacle(neighborPoint, map)
                        || closedSet.contains(neighborPoint)) {
                    continue;
                }

                double gScore = current.g
                        + (neighborPoint.x != current.point.x && neighborPoint.y != current.point.y ? DIAGONAL_COST
                                : 1.0);
                double hScore = heuristic(neighborPoint, finalPoint);
                double fScore = gScore + hScore;

                Node neighborNode = nodes.getOrDefault(neighborPoint,
                        new Node(neighborPoint, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
                if (gScore < neighborNode.g) {
                    neighborNode.parent = current;
                    neighborNode.g = gScore;
                    neighborNode.f = fScore;

                    if (!openQueue.contains(neighborNode)) {
                        openQueue.offer(neighborNode);
                    }
                    nodes.put(neighborPoint, neighborNode);
                }
            }
        }

        return Collections.emptyList();
    }

    private double heuristic(Point2d from, Point2d to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }

    private boolean isObstacle(Point2d point, List<List<Tile>> map) {
        return map.get((int) point.y).get((int) point.x).isSolid();
    }

    private boolean isNearObstacle(Point2d point, List<List<Tile>> map) {
        int rows = map.size();
        int cols = map.get(0).size();

        int[] dx = { -1, 1, 0 }; // Changes in x for left, right, up, down
        int[] dy = { -1, 1, 0 }; // Changes in y for left, right, up, down

        for (int i = 0; i < 3; i++) {
            int newX = (int) point.x + dx[i];
            int newY = (int) point.y + dy[i];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if (map.get(newY).get(newX).isSolid()) {
                    return true;
                }
            }
        }

        return false;
    }

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

    private List<Point2d> reconstructPath(Node finalNode) {
        List<Point2d> path = new ArrayList<>();
        Node current = finalNode;

        while (current != null) {
            path.add(0, current.point);
            current = current.parent;
        }

        return path;
    }

    private void clearCache() {
        pathCache.clear();
    }

    private static class Node {
        Point2d point;
        Node parent;
        double g;
        double f;

        Node(Point2d point, Node parent, double g, double f) {
            this.point = point;
            this.parent = parent;
            this.g = g;
            this.f = f;
        }

        double getF() {
            return f;
        }
    }

    private static class Pair<K, V> {
        private final K first;
        private final V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
