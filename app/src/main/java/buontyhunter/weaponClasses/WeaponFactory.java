package buontyhunter.weaponClasses;

import buontyhunter.model.FighterEntity;

public class WeaponFactory {

    private WeaponFactory() {
    }

    static private WeaponFactory instance;

    static public WeaponFactory getInstance() {
        if (instance == null) {
            instance = new WeaponFactory();
        }
        return instance;
    }

    public Weapon createSword(FighterEntity owner) {
        return new MeleeWeapon(3000, 2, 4, 2, null, owner, 10);
    }

    public Weapon createBow(FighterEntity owner) {
        return new RangedWeapon(25, 3, 10, 1, null, owner, null);
    }

    public Weapon createBossBow(FighterEntity owner) {
        return new RangedWeapon(60, 1, 20, 1, null, owner, null);
    }

    public Weapon createBrassKnuckles(FighterEntity owner) {
        return new MeleeWeapon(20, 4, 2, 2, null, owner, 500);
    }
}
