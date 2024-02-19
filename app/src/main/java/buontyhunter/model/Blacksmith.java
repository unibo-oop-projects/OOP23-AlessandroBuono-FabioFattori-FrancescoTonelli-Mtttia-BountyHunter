package buontyhunter.model;

public interface Blacksmith {
    /**
     * this method is used to repair the weapon of the player
     * @param player the player
     */
    void repairWeapon(PlayerEntity player);

    /**
     * this method is used to buy ammo for the player
     * @param player the player
     */
    void buyAmmo(PlayerEntity player);
}
