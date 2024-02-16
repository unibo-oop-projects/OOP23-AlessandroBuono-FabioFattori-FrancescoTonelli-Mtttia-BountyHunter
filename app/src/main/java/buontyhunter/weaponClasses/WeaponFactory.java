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
        return new MeleeWeapon(10, 3, 4, 2, null, owner);
    }

    public Weapon createBow(FighterEntity owner) {
        return new RangedWeapon(15, 0.5, 10, 1, null, owner, null);
    }

    public Weapon createBossBow(FighterEntity owner) {
        return new RangedWeapon(30, 1, 20, 1, null, owner, null);
    }

    public Weapon createBrassKnuckles(FighterEntity owner) {
        return new MeleeWeapon(5, 1, 2, 2, null, owner);
    }
}
