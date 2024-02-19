package buontyhunter.graphics;

import buontyhunter.model.DamagingArea;
import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class WeaponGraphicsComponent implements GraphicsComponent {

    /**
     * this method is used to draw the weapon on the screen
     * @param obj the object to draw
     * @param w the world
     */
    @Override
    public void update(GameObject obj, Graphics w, World world) {
         if (((DamagingArea) obj).isShow()) {
            w.drawWeapon(((DamagingArea) obj).getOwner());
         }
    }
}
