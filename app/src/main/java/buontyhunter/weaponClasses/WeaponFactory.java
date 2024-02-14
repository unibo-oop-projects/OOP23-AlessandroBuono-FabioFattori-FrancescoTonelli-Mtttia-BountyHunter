package buontyhunter.weaponClasses;

import buontyhunter.model.FighterEntity;

public abstract class WeaponFactory {
    
    public static Weapon createSword(FighterEntity owner){
        return new MeleeWeapon(10, 3, 4, 2, null,owner);
    } 

    public static Weapon createBow(FighterEntity owner){
        return new RangedWeapon(15, 2, 10, 3, null,owner);
    }

    public static Weapon createBrassKnuckles(FighterEntity owner){
        return new MeleeWeapon(5, 1, 2, 2, null,owner);
    }
}
