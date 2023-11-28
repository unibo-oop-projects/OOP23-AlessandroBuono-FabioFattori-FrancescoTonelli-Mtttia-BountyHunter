package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;

public class MiniMapGraphicsComponent implements GraphicsComponent {

    public MiniMapGraphicsComponent() {
    }

    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof HidableObject) {
            w.drawMiniMap((HidableObject) obj, world);
        }
    }
}