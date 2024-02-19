package buontyhunter.model.AI.pathFinding;

/**
 * The path finder factory
 */
public class PathFinderFactory {
    /**
     * Create a new A* path finder
     * 
     * @param useCache if the path finder should use cache
     * @return the path finder
     */
    public static PathFinder createAStarPathFinder(boolean useCache) {
        return new AStarPathFinder(useCache);
    }

    /**
     * Create a new BFS path finder
     * 
     * @param useCache if the path finder should use cache
     * @return the path finder
     */
    public static PathFinder createBFSPathFinder(boolean useCache) {
        return new BFSPathFinder(useCache);
    }
}
