package buontyhunter.weaponClasses;
import buontyhunter.common.ImageType;
import buontyhunter.model.FighterEntity;

public class MeleeWeapon  extends Weapon{

    private int durability;

    public MeleeWeapon(int damage, int attackSpeed, int range, double speed, ImageType sprite,FighterEntity owner, int durability) {
        super(damage, attackSpeed, range, speed, sprite,owner);
        this.durability=durability;
    }

    public int getDurability(){
        return durability;
    }

    public void setDurability(int a){
        durability=a;
    }

    //TODO
    public void attack(){

    }

}
