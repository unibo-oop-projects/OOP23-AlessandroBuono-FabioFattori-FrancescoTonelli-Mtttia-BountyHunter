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
        return new MeleeWeapon(30, 2, 4, 2, owner, 250, WeaponType.SWORD);
    }

    public Weapon createBow(FighterEntity owner) {
        return new RangedWeapon(30, 3, 10, 1, null, owner, WeaponType.BOW);
    }

    public Weapon createBossBow(FighterEntity owner) {
        return new RangedWeapon(60, 1, 6, 1, null, owner, WeaponType.BOSSBOW);
    }

    public Weapon createBrassKnuckles(FighterEntity owner) {
        return new MeleeWeapon(20, 5, 2, 2, owner, 50000, WeaponType.BRASSKNUCKLES);
    }
}
