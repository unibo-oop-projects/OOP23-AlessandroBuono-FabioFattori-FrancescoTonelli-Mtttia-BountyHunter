package buontyhunter.model.AI.enemySpawner;

public interface EnemyConfigurationFactory {

    EnemyConfiguration fromType(EnemyType enemies);

    EnemyConfiguration random();

}