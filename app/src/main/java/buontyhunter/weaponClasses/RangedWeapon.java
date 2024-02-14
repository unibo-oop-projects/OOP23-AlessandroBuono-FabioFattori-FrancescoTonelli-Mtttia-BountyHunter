package buontyhunter.weaponClasses;
import buontyhunter.common.ImageType;
import buontyhunter.model.FighterEntity;

public class RangedWeapon extends Weapon{

    public RangedWeapon(int damage, int attackSpeed, int range, int speed, ImageType sprite, FighterEntity owner) {
        super(damage, attackSpeed, range, speed, sprite,owner);
    }
    
    //TODO
    public void attack(){

    }
}
