package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class MiniMapGraphicsComponent implements GraphicsComponent {

    /**
     * this method is used to draw the minimap on the screen 
     * @param obj the object to draw
     * @param w the graphics to draw the object
     * @param world the world
     */
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof HidableObject) {
            w.drawMiniMap((HidableObject) obj, world);
        }
    }
}