package buontyhunter.model.AI;

import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.model.AI.pathFinding.PathFinder;

public interface AIFactory {

    public static enum PathFinderType {
        AStar, BFS
    }

    PathFinder CreatePathFinder(PathFinderType type, boolean useCache);

    AIFollowPathHelper CreateFollowPathHelper(PathFinderType type, boolean pathFinderUseCache);

}