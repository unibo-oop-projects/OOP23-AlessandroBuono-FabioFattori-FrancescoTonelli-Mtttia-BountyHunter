package buontyhunter.Graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;

public class MapGraphicsComponent implements GraphicsComponent {

    public MapGraphicsComponent() {
    }

    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof TileManager) {
            w.drawMap((TileManager) obj, world);
        }
    }
}