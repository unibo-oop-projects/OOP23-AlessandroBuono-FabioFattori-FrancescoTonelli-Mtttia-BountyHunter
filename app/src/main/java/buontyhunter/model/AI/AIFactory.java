package buontyhunter.model.AI;

import buontyhunter.model.AI.pathFinding.AIEnemyFollowPathHelper;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.model.AI.pathFinding.PathFinder;

/**
 * The AI factory
 */
public interface AIFactory {

    public static enum PathFinderType {
        AStar, BFS
    }

    /**
     * Create a path finder
     * 
     * @param type     the type of the path finder
     * @param useCache if the path finder should use cache
     * @return the path finder
     */
    PathFinder CreatePathFinder(PathFinderType type, boolean useCache);

    /**
     * Create a follow path helper
     * 
     * @param type               the type of the path finder
     * @param pathFinderUseCache if the path finder should use cache
     * @return the follow path helper
     */
    AIFollowPathHelper CreateFollowPathHelper(PathFinderType type, boolean pathFinderUseCache);

    /**
     * Create a enemy follow path helper
     * 
     * @param type               the type of the path finder
     * @param pathFinderUseCache if the path finder should use cache
     * @return the enemy follow path helper
     */
    AIEnemyFollowPathHelper CreateEnemyFollowPathHelper(PathFinderType type, boolean pathFinderUseCache);

}