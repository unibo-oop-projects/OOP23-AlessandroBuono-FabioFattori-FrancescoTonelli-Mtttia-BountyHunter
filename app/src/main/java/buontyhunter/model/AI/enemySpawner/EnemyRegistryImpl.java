package buontyhunter.model.AI.enemySpawner;

import java.util.List;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.common.Logger.AppLogger;
import buontyhunter.common.Logger.LogType;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.model.EnemyEntity;
import buontyhunter.model.World;
import buontyhunter.model.EnemyManager.EnemyIdentifierManager;
import buontyhunter.model.EnemyManager.EnemyIdentifierManagerImpl;
import java.util.stream.Collectors;

public class EnemyRegistryImpl implements EnemyRegistry {
    private Map<Integer, EnemyEntity> enemies = new HashMap<>();
    private EnemyIdentifierManager enemyIdManger = new EnemyIdentifierManagerImpl();
    private EnemySpawner enemySpawner = new EnemySpawnerFromDistance();

    @Override
    public void addEnemy(Point2d pos, Vector2d speed, int health) {
        var gameFactory = new GameFactory(GameEngine.resizator);
        var enemy = gameFactory.createEnemy(pos, speed, health, enemyIdManger.getIdentifier(), null);
        enemies.put(enemy.getEnemyIdentifier(), enemy);
        AppLogger.getLogger().log("adding enemy" + enemy.getEnemyIdentifier(), LogType.MODEL);
    }

    @Override
    public List<EnemyEntity> getEnemies() {
        return enemies.values().stream().collect(Collectors.toList());
    }

    @Override
    public EnemyEntity getEnemy(int id) {
        return enemies.get(id);
    }

    @Override
    public void removeEnemy(int id) {
        enemies.remove(id);
        AppLogger.getLogger().log("removing enemy" + id, LogType.MODEL);
    }

    @Override
    public void generateEnemy(World w) {
        enemySpawner.spawn(w);
    }

}
