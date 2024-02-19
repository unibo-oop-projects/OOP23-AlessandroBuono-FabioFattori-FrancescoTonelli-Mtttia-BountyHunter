package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class EnemyGraphicsComponent implements GraphicsComponent {

    /**
     * @param obj the object to draw
     * @param w the graphics to draw the object
     * @param world the world
     */
    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawEnemy(obj, world);
    }
}
