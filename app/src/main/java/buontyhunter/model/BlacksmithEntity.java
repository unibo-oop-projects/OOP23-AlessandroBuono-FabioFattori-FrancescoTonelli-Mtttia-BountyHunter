package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.weaponClasses.MeleeWeapon;

public class BlacksmithEntity extends InterractableArea implements Blacksmith{


    private final int ammoCost = 1;
    private final int repairCost = 10;

    public BlacksmithEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, HidableObject panel) {
        super(type, pos, vel, box, panel);
    }

    @Override
    public void repairWeapon(PlayerEntity player) {
        if(player.getWeapon() instanceof MeleeWeapon && 
            ((MeleeWeapon)player.getWeapon()).getDurability() < ((MeleeWeapon)player.getWeapon()).getMaxDurability() && 
            player.withdrawDoblons(repairCost)){
                ((MeleeWeapon)player.getWeapon()).setDurability(((MeleeWeapon)player.getWeapon()).getMaxDurability());
            }
    }

    @Override
    public void buyAmmo(PlayerEntity player) {
        if(player.withdrawDoblons(ammoCost)){
            player.giveAmmo(1);
        }
    }
    
}
