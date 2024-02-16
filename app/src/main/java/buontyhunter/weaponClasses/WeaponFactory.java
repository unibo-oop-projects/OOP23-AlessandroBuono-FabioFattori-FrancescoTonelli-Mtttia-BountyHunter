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
        return new MeleeWeapon(30, 2, 4, 2, null, owner,300);
    }

    public Weapon createBow(FighterEntity owner) {
        return new RangedWeapon(15, 3, 10, 1, null, owner, null);
    }

    public Weapon createBossBow(FighterEntity owner) {
        return new RangedWeapon(30, 1, 9, 1, null, owner, null);
    }

    public Weapon createBrassKnuckles(FighterEntity owner) {
        return new MeleeWeapon(5, 1, 2, 2, null, owner, 500);
    }
}
