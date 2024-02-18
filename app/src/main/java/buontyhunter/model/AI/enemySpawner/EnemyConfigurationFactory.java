package buontyhunter.model.AI.enemySpawner;

/**
 * this interface is used to create the configuration of the enemy
 */
public interface EnemyConfigurationFactory {

    /**
     * @param enemies the type of the enemy
     * @return the configuration of the enemy
     */
    EnemyConfiguration fromType(EnemyType enemies);

    /**
     * @return a random configuration of the enemy
     */
    EnemyConfiguration random();

}