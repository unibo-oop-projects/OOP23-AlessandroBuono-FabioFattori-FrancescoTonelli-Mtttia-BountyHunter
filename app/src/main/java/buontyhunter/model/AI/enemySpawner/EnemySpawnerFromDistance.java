package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.PercentageHelper;
import buontyhunter.common.Point2d;
import buontyhunter.model.World;

import java.util.*;

public class EnemySpawnerFromDistance implements EnemySpawner {

    private int maxEnemyNumber = 6;
    private List<EnemyType> enemyTypes = List.of(EnemyType.SWORD, EnemyType.BRASS_KNUCLES, EnemyType.BOW);
    private double spawnPercentage = 1;
    private double doubleEnemyPercentage = 40;
    private double tripleEnemyPercentage = 20;

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
        var conf = getEnemyTypeFromIndex(getNextSpawnEnemyType());
        var pos = generatePoint(w.getPlayer().getPos(), conf.getMinSpawnDistanceFromPlayer(),
                conf.getMaxSpawnDistanceFromPlayer());
        w.addEnemy(pos, conf.getSpeed(), maxEnemyNumber);
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

    private int getNextSpawnEnemyType() {
        var rand = new Random();
        return rand.nextInt(enemyTypes.size());
    }

    private EnemyConfiguration getEnemyTypeFromIndex(int index) {
        var enemyConfFactory = new EnemyConfigurationFactory();
        return enemyConfFactory.fromType(enemyTypes.get(index));
    }

    private Point2d generatePoint(Point2d playerPos, double minDistanceFromPlayer, double maxDistanceFromPlayer) {
        var rand = new Random();
        var distance = rand.nextDouble() * (maxDistanceFromPlayer - minDistanceFromPlayer) + minDistanceFromPlayer;
        var angle = rand.nextDouble() * 2 * Math.PI;
        var x = playerPos.x + distance * Math.cos(angle);
        var y = playerPos.y + distance * Math.sin(angle);
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        return new Point2d(x, y);
    }
}
