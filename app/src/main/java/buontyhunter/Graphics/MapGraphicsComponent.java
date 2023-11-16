package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.TileManager;

public class MapGraphicsComponent implements GraphicsComponent {

    public MapGraphicsComponent() {
    }

    public void update(GameObject obj, Graphics w) {
        if (obj instanceof TileManager) {
            w.drawMap((TileManager) obj);
        }
    }
}