package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Vector2d;

public interface EnemyConfiguration {
    /**
     * @return the speed of the enemy
     */
    Vector2d getSpeed();

    /**
     * @return the health of the enemy
     */
    int getHealth();

    /**
     * @return the damage of the enemy in spawn
     */
    double getMinSpawnDistanceFromPlayer();

    /**
     * @return the max distance from the player in spawn
     */
    double getMaxSpawnDistanceFromPlayer();

    /**
     * @return the type of the enemy
     */
    EnemyType getType();

    /**
     * @return the cool down of the spawn
     */
    long getAttackCoolDown();
}
