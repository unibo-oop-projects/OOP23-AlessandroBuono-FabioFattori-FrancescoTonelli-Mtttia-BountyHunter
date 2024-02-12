package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class EnemyGraphicsComponent implements GraphicsComponent {

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawEnemy(obj, world);
    }
}
