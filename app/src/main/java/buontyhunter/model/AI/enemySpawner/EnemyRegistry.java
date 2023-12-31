package buontyhunter.model.AI.enemySpawner;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.EnemyEntity;
import buontyhunter.model.World;

import java.util.List;

public interface EnemyRegistry {
    void addEnemy(Point2d pos, Vector2d speed, int health);

    List<EnemyEntity> getEnemies();

    EnemyEntity getEnemy(int id);

    void removeEnemy(int id);

    void generateEnemy(World w);
}
