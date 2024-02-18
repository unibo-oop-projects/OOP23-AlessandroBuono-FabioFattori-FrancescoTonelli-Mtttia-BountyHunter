package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Vector2d;

import java.util.*;

public class EnemyConfigurationFactoryImpl implements EnemyConfigurationFactory {
    private final double MAX_DISTANCE = 20;
    private final Vector2d DEFAULT_SPEED = new Vector2d(0.2, 0.2);
    private final float seepVariance = 0.2f;

    private EnemyConfiguration general(Vector2d speed, int health, double minSpawnDistanceFromPlayer, EnemyType type,
            long attackCoolDown) {
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

            @Override
            public EnemyType getType() {
                return type;
            }

            @Override
            public long getAttackCoolDown() {
                return attackCoolDown;
            }
        };
    }

    private Vector2d getSpeed() {
        var random = new Random();
        var x = DEFAULT_SPEED.x + (random.nextFloat() * (seepVariance * 2f) - seepVariance);
        var y = DEFAULT_SPEED.y + (random.nextFloat() * (seepVariance * 2f) - seepVariance);
        return new Vector2d(x, y);
    }

    private EnemyConfiguration swordEnemy() {
        return general(getSpeed(), 50, 5, EnemyType.SWORD, 7500);
    }

    private EnemyConfiguration throwPunchesEnemy() {
        return general(getSpeed(), 70, 2, EnemyType.THROW_PUNCHES, 5000);
    }

    private EnemyConfiguration archEnemy() {
        return general(getSpeed(), 40, 14, EnemyType.BOW, 10000);
    }

    @Override
    public EnemyConfiguration fromType(EnemyType enemies) {
        switch (enemies) {
            case SWORD:
                return swordEnemy();
            case THROW_PUNCHES:
                return throwPunchesEnemy();
            case BOW:
                return archEnemy();
            default:
                return null;
        }
    }

    @Override
    public EnemyConfiguration random() {
        var rand = new Random();
        var availableEnemy = List.of(EnemyType.BOW, EnemyType.SWORD, EnemyType.THROW_PUNCHES);
        var enemyType = availableEnemy.get(rand.nextInt(availableEnemy.size()));
        return fromType(enemyType);
    }
}
