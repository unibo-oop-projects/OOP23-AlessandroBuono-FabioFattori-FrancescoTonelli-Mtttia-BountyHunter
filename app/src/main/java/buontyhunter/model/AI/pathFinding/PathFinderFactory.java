package buontyhunter.model.AI.pathFinding;

public class PathFinderFactory {
    public static PathFinder createAStarPathFinder(boolean useCache) {
        return new AStarPathFinder(useCache);
    }

    public static PathFinder createBFSPathFinder(boolean useCache) {
        return new BFSPathFinder(useCache);
    }
}
