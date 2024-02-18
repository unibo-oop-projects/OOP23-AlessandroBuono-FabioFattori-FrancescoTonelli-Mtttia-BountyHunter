package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;

public class MapGraphicsComponent implements GraphicsComponent {

    /**
     * this method is used to draw the map
     * @param obj the object to draw
     * @param w the world
     */
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof TileManager) {
            w.drawMap((TileManager) obj, world);
        }
    }
}