package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Point2d;
import buontyhunter.model.EnemyEntity;
import buontyhunter.model.World;

import java.util.List;

/**
 * this interface is used to manage the enemies
 */
public interface EnemyRegistry {
    /**
     * this method is used to add an enemy to the registry
     * 
     * @param pos  the position of the enemy
     * @param conf the configuration of the enemy
     */
    void addEnemy(Point2d pos, EnemyConfiguration conf);

    /**
     * this method is used to get the list of the enemies
     * 
     * @return the list of the enemies
     */
    List<EnemyEntity> getEnemies();

    /**
     * this method is used to get the enemy with the passed id
     * 
     * @param id the id of the enemy
     * @return the enemy with the passed id
     */
    EnemyEntity getEnemy(int id);

    /**
     * this method is used to remove the enemy with the passed id
     * 
     * @param id the id of the enemy
     */
    void removeEnemy(int id);

    /**
     * this method is used to generate an enemy
     * 
     * @param w the world where the enemy will be generated
     */
    void generateEnemy(World w);

    /**
     * this method is used to disable the enemies
     */
    void disableEnemies();

    /**
     * this method is used to pause the spawn of the enemies
     */
    void pauseSpawn();

    /**
     * this method is used to resume the spawn of the enemies
     */
    void resumeSpawn();

    /**
     * this method is used to enable the enemies
     */
    void enableEnemies();
}
