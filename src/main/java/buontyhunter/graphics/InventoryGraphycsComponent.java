package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.InventoryObject;
import buontyhunter.model.World;

public class InventoryGraphycsComponent implements GraphicsComponent{

    /**
     * this method is used to draw the 
     * @param obj the object to draw
     * @param w the graphics to draw the object
     * @param world the world
     */
    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof HidableObject && ((HidableObject)obj).isShow()) {
            w.drawInventory((InventoryObject) obj, world);
        }
    }
    
}
