package buontyhunter.model.AI.enemySpawner;

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