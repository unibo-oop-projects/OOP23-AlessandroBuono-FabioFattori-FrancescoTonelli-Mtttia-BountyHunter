package buontyhunter.model.AI;

import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.model.AI.pathFinding.PathFinder;

public abstract class AIFactory {

    public static enum PathFinderType {
        AStar, BFS
    }

    public static PathFinder CreatePathFinder(PathFinderType type, boolean useCache) {
        switch (type) {
            case AStar:
                return PathFinder.AStar(useCache);
            case BFS:
                return PathFinder.BFS(useCache);
            default:
                return null;
        }
    }

    public static AIFollowPathHelper CreateFollowPathHelper(PathFinderType type, boolean pathFinderUseCache) {
        return new AIFollowPathHelper(CreatePathFinder(type, pathFinderUseCache));
    }
}
