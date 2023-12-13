package buontyhunter.input;

import buontyhunter.model.EnemyEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.GameState;
import buontyhunter.model.World;

public class EnemyInputController implements InputComponent {

    @Override
    public void update(GameObject obj, InputController c, World w) {
        if (obj instanceof EnemyEntity) {
            var enemy = (EnemyEntity) obj;
            enemy.moveItem(w);
        }
    }
}