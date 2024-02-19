package buontyhunter.model.AI.enemySpawner;

import java.util.Arrays;

import buontyhunter.common.Point2d;
import buontyhunter.model.World;

/**
 * this class is used to spawn a fixed number of enemies
 */
public class EnemySpawnerFixed implements EnemySpawner {

    private final int enemySpawnNumber;

    public EnemySpawnerFixed(int enemySpawnNumber) {
        if (enemySpawnNumber < 0) {
            throw new IllegalArgumentException("cannot spawn a negative enemy number");
        }
        this.enemySpawnNumber = enemySpawnNumber;
    }

    @Override
    public void spawn(World w) {
        var enemyConfFactory = new EnemyConfigurationFactoryImpl();
        var enemies = Arrays.asList(new EnemyConfiguration[enemySpawnNumber]);
        enemies.stream()
                .map(
                        e -> enemyConfFactory.random())
                .forEach(
                        enemyConfiguration -> w.addEnemy(
                                EnemySpawner.generatePoint(enemyConfiguration, w).isPresent()
                                        ? EnemySpawner.generatePoint(enemyConfiguration, w).get()
                                        : new Point2d(0, 0),
                                enemyConfiguration));
    }

}
