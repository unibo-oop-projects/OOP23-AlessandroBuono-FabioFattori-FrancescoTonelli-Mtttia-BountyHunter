package buontyhunter.input;

import buontyhunter.model.EnemyEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class EnemyInputController implements InputComponent {

    @Override
    public void update(GameObject obj, InputController c, World w) {
        if (obj instanceof EnemyEntity) {
            var enemy = (EnemyEntity) obj;
            var isDeath = enemy.moveItemAssertIsDeath(w);
            if (isDeath) {
                w.removeEnemy(enemy.getEnemyIdentifier());
            }
        }
    }
}