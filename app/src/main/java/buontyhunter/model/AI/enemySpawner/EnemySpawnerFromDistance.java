package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.PercentageHelper;
import buontyhunter.common.Point2d;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.World;

import java.util.*;

public class EnemySpawnerFromDistance implements EnemySpawner {

    /**
     * max number of enemies in the world
     */
    private int maxEnemyNumber = 6;
    /**
     * all different types of enemies
     */
    private List<EnemyType> enemyTypes = List.of(EnemyType.SWORD, EnemyType.THROW_PUNCHES, EnemyType.BOW);
    /**
     * spawn in percentage /100
     */
    private double spawnPercentage = 0.2;
    /**
     * percentage of spawning 2 enemies
     */
    private double doubleEnemyPercentage = 30;
    /**
     * percentage of spawning 3 enemies
     */
    private double tripleEnemyPercentage = 10;
    private EnemyConfigurationFactory enemyFactory;

    public EnemySpawnerFromDistance() {
        this.enemyFactory = new EnemyConfigurationFactoryImpl();
    }

    @Override
    public void spawn(World w) {
        var enemyNum = getEnemyNumber(w.getEnemies().size());
        if (enemyNum > 0 && canSpawn(w)) {
            for (int i = 0; i < enemyNum; i++) {
                createEnemy(w);
            }
        }
    }

    private void createEnemy(World w) {
        var conf = enemyFactory.random();
        var pos = generatePoint(conf, w);
        if (pos.isPresent()) {
            w.addEnemy(pos.get(), conf);
        }
    }

    private int getEnemyNumber(int actualEnemyNumber) {
        int enemyNum = 1;
        if (PercentageHelper.match(tripleEnemyPercentage)) {
            enemyNum = 3;
        } else if (PercentageHelper.match(doubleEnemyPercentage)) {
            enemyNum = 2;
        }
        return Math.min(enemyNum, maxEnemyNumber - actualEnemyNumber);
    }

    private boolean canSpawn(World w) {
        return PercentageHelper.match(spawnPercentage) && enemyTypes.size() > 0;
    }

    private Optional<Point2d> generatePoint(EnemyConfiguration conf, World w) {
        if (conf == null || w == null)
            return Optional.empty();
        else {
            var maxDistanceFromPlayer = conf.getMaxSpawnDistanceFromPlayer();
            var minDistanceFromPlayer = conf.getMinSpawnDistanceFromPlayer();
            var playerPos = w.getPlayer().getPos();
            var worldRectBBox = (RectBoundingBox) w.getTileManager().getBBox();
            var rand = new Random();
            var distance = rand.nextDouble() * (maxDistanceFromPlayer - minDistanceFromPlayer) + minDistanceFromPlayer;
            var angle = rand.nextDouble() * 2 * Math.PI;
            var x = playerPos.x + distance * Math.cos(angle);
            var y = playerPos.y + distance * Math.sin(angle);
            if (x < 0) {
                x = 0;
            } else if (x > worldRectBBox.getWidth()) {
                x = worldRectBBox.getWidth() - 1;
            }
            if (y < 0) {
                y = 0;
            } else if (y > worldRectBBox.getHeight()) {
                y = worldRectBBox.getHeight() - 1;
            }
            var spawnPoint = new Point2d(x, y);

            // check if tile is valid
            var tile = w.getTileManager().getTileFromPosition(spawnPoint);
            if (tile.isPresent() && tile.get().isTraversable()) {
                return Optional.of(spawnPoint);
            } else {
                return Optional.empty();
            }
        }
    }
}
