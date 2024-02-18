package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.EnemyEntity;
import buontyhunter.model.World;

import java.util.List;

public interface EnemyRegistry {
    void addEnemy(Point2d pos, EnemyConfiguration conf);

    List<EnemyEntity> getEnemies();

    EnemyEntity getEnemy(int id);

    void removeEnemy(int id);

    void generateEnemy(World w);

    void disableEnemies();

    void pauseSpawn();

    void resumeSpawn();

    void enableEnemies();
}
