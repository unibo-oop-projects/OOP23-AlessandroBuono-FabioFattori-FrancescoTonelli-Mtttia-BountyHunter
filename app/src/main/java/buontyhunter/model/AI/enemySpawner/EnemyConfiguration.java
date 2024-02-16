package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Vector2d;
import buontyhunter.weaponClasses.Weapon;

public interface EnemyConfiguration {
    Vector2d getSpeed();

    int getHealth();

    double getMinSpawnDistanceFromPlayer();

    double getMaxSpawnDistanceFromPlayer();

    EnemyType getType();

    long getAttackCoolDown();
}
