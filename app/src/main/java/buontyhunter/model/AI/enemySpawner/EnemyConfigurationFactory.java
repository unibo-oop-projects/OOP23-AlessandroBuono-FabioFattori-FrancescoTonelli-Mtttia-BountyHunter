package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Vector2d;
import java.util.*;

public class EnemyConfigurationFactory {
    public final double MAX_DISTANCE = 20;
    private final Vector2d DEFAULT_SPEED = new Vector2d(0.4, 0.4);
    private final float seepVariance = 0.2f;

    private EnemyConfiguration general(Vector2d speed, int health, double minSpawnDistanceFromPlayer) {
        return new EnemyConfiguration() {

            @Override
            public Vector2d getSpeed() {
                return speed;
            }

            @Override
            public double getMinSpawnDistanceFromPlayer() {
                return minSpawnDistanceFromPlayer;
            }

            @Override
            public double getMaxSpawnDistanceFromPlayer() {
                return MAX_DISTANCE;
            }

            @Override
            public int getHealth() {
                return health;
            }
        };
    }

    public Vector2d getSpeed() {
        var random = new Random();
        var x = DEFAULT_SPEED.x + (random.nextFloat()*(seepVariance * 2f) - seepVariance);
        var y = DEFAULT_SPEED.y + (random.nextFloat()*(seepVariance * 2f) - seepVariance);
        return new Vector2d(x, y);
    }

    public EnemyConfiguration swordEnemy() {
        return general(getSpeed(), 50, 5);
    }

    public EnemyConfiguration daggerEnemy() {
        return general(getSpeed(), 70, 2);
    }

    public EnemyConfiguration archEnemy() {
        return general(getSpeed(), 40, 14);
    }

    public EnemyConfiguration fromType(EnemyType enemies) {
        switch (enemies) {
            case SWORD:
                return swordEnemy();
            case DAGGER:
                return daggerEnemy();
            case ARCH:
                return archEnemy();
            default:
                return null;
        }
    }
}
