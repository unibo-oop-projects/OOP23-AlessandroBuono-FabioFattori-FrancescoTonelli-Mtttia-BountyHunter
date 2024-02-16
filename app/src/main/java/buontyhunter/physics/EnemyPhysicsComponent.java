package buontyhunter.physics;

import java.util.List;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.model.EnemyEntity;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.Tile;
import buontyhunter.model.World;

public class EnemyPhysicsComponent extends PhysicsComponent {

    private long dtSinceLastMove = 0;

    public void update(long dt, GameObject obj, World w) {
        var enemy = (EnemyEntity) obj;
        if (enemy.getHealth() <= 0) {
            w.removeEnemy(enemy.getEnemyIdentifier(), true);
        } else {
            // if is still alive, try to attach

        }
    }
}
