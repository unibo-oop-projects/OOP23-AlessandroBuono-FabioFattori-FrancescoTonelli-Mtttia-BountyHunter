package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;

public class BlacksmithEntity extends InterractableArea implements Blacksmith{

    public BlacksmithEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, HidableObject panel) {
        super(type, pos, vel, box, panel);
    }

    @Override
    public void repairWeapon(PlayerEntity player) {
        //todo
        System.out.println("Armi riparate");
    }

    @Override
    public void buyAmmo(PlayerEntity player) {
        if(player.withdrawDoblons(1)){
            player.giveAmmo(1);
        }
    }
    
}
