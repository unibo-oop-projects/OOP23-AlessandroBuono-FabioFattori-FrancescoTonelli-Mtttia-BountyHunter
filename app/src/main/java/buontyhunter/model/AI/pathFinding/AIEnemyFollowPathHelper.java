package buontyhunter.model.AI.pathFinding;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.World;

/**
 * this class is used to help the enemy to follow the path
 */
public class AIEnemyFollowPathHelper extends AIFollowPathHelper {

    /**
     * constructor
     * 
     * @param pathFinder the path finder
     */
    public AIEnemyFollowPathHelper(PathFinder pathFinder) {
        super(pathFinder);
    }

    /**
     * get next point for follow the player from the best position (based on his arm
     * type and range)
     * 
     * @param enemy the enemy
     * @param speed the speed of the enemy
     * @param world the world
     * @return the next point
     */
    public Point2d followPlayer(FighterEntity enemy, Vector2d speed, World world) {
        var currentPos = enemy.getPos();
        var tiles = world.getTileManager().getTiles();

        Point2d targetPoint = getTargetPosition(enemy, world);

        return moveItem(currentPos, targetPoint, speed, tiles);
    }

    /**
     * found the best position from where attack the player
     * 
     * @param enemy
     * @param w
     * @return
     */
    private Point2d getTargetPosition(FighterEntity enemy, World w) {
        Point2d currentPos = enemy.getPos();
        var range = enemy.getWeapon().getRange();
        var playerPos = w.getPlayer().getPos().duplicate();
        playerPos.x = (int) playerPos.x;
        playerPos.y = (int) playerPos.y;

        boolean foundTopX = false, foundTopY = false, foundBottomX = false, foundBottomY = false;
        int topX = -1, topY = -1, bottomX = -1, bottomY = -1;
        while (range >= 0 || !(foundTopX && foundTopY && foundBottomX && foundBottomY)) {
            if (!foundTopX) {
                topX = (int) (playerPos.x + range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(topX, playerPos.y));
                if (tile.isPresent() && tile.get().isTraversable()) {
                    foundTopX = true;
                }
            }
            if (!foundTopY) {
                topY = (int) (playerPos.y + range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(playerPos.x, topY));
                if (tile.isPresent() && tile.get().isTraversable()) {
                    foundTopY = true;
                }
            }
            if (!foundBottomX) {
                bottomX = (int) (playerPos.x - range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(bottomX, playerPos.y));
                if (tile.isPresent() && tile.get().isTraversable()) {
                    foundBottomX = true;
                }
            }
            if (!foundBottomY) {
                bottomY = (int) (playerPos.y - range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(playerPos.x, bottomY));
                if (tile.isPresent() && tile.get().isTraversable()) {
                    foundBottomY = true;
                }
            }

            range--;
        }

        // found the neares x and y to currentPos
        var nearestX = Math.abs(currentPos.x - topX) < Math.abs(currentPos.x - bottomX) ? topX : bottomX;
        var nearestY = Math.abs(currentPos.y - topY) < Math.abs(currentPos.y - bottomY) ? topY : bottomY;

        var deltaX = Math.abs(nearestX - currentPos.x);
        var deltaY = Math.abs(nearestY - currentPos.y);

        var x = deltaX < deltaY
                ? nearestX
                : playerPos.x;

        var y = deltaX < deltaY
                ? playerPos.y
                : nearestY;

        return new Point2d(x, y);
    }

}
