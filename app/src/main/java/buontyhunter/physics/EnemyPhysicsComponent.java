package buontyhunter.physics;

import buontyhunter.model.EnemyEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class EnemyPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        var enemy = (EnemyEntity) obj;
        if (enemy.getHealth() <= 0) {
            w.removeEnemy(enemy.getEnemyIdentifier(), true);
        } else {
            // if is still alive, try to attach
            enemy.tryAttach(dt, w.getPlayer().getPos());
        }
    }
}
