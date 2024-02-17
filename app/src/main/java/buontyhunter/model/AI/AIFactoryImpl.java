package buontyhunter.model.AI;

import buontyhunter.model.AI.pathFinding.AIEnemyFollowPathHelper;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.model.AI.pathFinding.PathFinder;

public class AIFactoryImpl implements AIFactory {

    @Override
    public PathFinder CreatePathFinder(PathFinderType type, boolean useCache) {
        switch (type) {
            case AStar:
                return PathFinder.AStar(useCache);
            case BFS:
                return PathFinder.BFS(useCache);
            default:
                return null;
        }
    }

    @Override
    public AIFollowPathHelper CreateFollowPathHelper(PathFinderType type, boolean pathFinderUseCache) {
        return new AIFollowPathHelper(CreatePathFinder(type, pathFinderUseCache));
    }

    @Override
    public AIEnemyFollowPathHelper CreateEnemyFollowPathHelper(PathFinderType type, boolean pathFinderUseCache) {
        return new AIEnemyFollowPathHelper(CreatePathFinder(type, pathFinderUseCache));
    }
}
