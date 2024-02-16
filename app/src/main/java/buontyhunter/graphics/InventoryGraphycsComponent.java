package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.InventoryObject;
import buontyhunter.model.World;

public class InventoryGraphycsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof HidableObject && ((HidableObject)obj).isShow()) {
            w.drawInventory((InventoryObject) obj, world);
        }
    }
    
}
