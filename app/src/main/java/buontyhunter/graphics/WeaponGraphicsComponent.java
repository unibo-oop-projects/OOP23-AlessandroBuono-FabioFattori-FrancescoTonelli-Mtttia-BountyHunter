package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.PlayerEntity;
import buontyhunter.model.World;

public class WeaponGraphicsComponent implements GraphicsComponent{


    //w disegna , obj è l'idable object, world è world
    @Override
    public void update(GameObject obj, Graphics w, World world) {
       if(((HidableObject)obj).isShow()){
        w.drawWeapon(((PlayerEntity)world.getPlayer()));
       }
    }
    
}
