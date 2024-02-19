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

    /**
     * create a new sword
     * @param owner the owner of the sword
     * @return the new sword
     */
    public Weapon createSword(FighterEntity owner) {
        return new MeleeWeapon(30, 2, 4, 2, owner, 250, WeaponType.SWORD);
    }

    /**
     * create a new boss sword
     * @param owner the owner of the sword
     * @return the new boss sword
     */
    public Weapon createBow(FighterEntity owner) {
        return new RangedWeapon(30, 3, 10, 1, null, owner, WeaponType.BOW);
    }

    /**
     * create a new boss sword
     * @param owner the owner of the sword
     * @param level the level of the sword
     * @return the new boss sword
     */
    public Weapon createBossBow(FighterEntity owner, int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level must be greater than 0");
        }
        return new RangedWeapon(60 * level, 1, 6, 1, null, owner, WeaponType.BOSSBOW);

    }

    /**
     * create a new brass knuckles
     * @param owner the owner of the brass knuckles
     * @return the new brass knuckles
     */
    public Weapon createBrassKnuckles(FighterEntity owner) {
        return new MeleeWeapon(20, 5, 2, 2, owner, 50000, WeaponType.BRASSKNUCKLES);
    }
}
