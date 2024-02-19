package buontyhunter.model.AI;

import buontyhunter.model.AI.pathFinding.AIEnemyFollowPathHelper;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.model.AI.pathFinding.PathFinder;
import buontyhunter.model.AI.pathFinding.PathFinderFactory;

/**
 * The AI factory
 */
public class AIFactoryImpl implements AIFactory {

    @Override
    public PathFinder CreatePathFinder(PathFinderType type, boolean useCache) {
        switch (type) {
            case AStar:
                return PathFinderFactory.createAStarPathFinder(useCache);
            case BFS:
                return PathFinderFactory.createBFSPathFinder(useCache);
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
