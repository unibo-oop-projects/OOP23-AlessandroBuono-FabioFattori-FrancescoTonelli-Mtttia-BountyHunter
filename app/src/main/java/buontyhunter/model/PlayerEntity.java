package buontyhunter.model;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.RangedWeapon;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponType;

public class PlayerEntity extends FighterEntity {

    private List<Quest> quests;
    protected FighterEntityType type = FighterEntityType.PLAYER;
    private int doblons;
    private List<Weapon> inventoryWeapons;

    public PlayerEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth, Weapon w) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth, w);
        quests = new ArrayList<Quest>();
        this.doblons = 0;
        inventoryWeapons = new ArrayList<Weapon>();
    }

    /**
     * equip a weapon from the player's inventory
     * @param w the weapon to equip
     */
    public void equipWeapon(Weapon w) {
        if (inventoryWeapons.contains(w)) {
            this.weapon = w;
        }
    }

    /**
     * add a weapon to the player's inventory
     * @param w the weapon to add
     */
    public void addWeapon(Weapon w) {
        inventoryWeapons.add(w);
    }

    /**
     * remove a weapon from the player's inventory
     * @param w the weapon to remove
     */
    public void removeWeapon(Weapon w) {
        inventoryWeapons.remove(w);
    }

    /**
     * get the player's inventory of weapons
     * @return the player's inventory of weapons
     */
    public List<Weapon> getWeapons() {
        return new ArrayList<Weapon>(inventoryWeapons);
    }

    /**
     * add a quest to the player's quest list
     * @param q the quest to add
     */
    public void addQuest(Quest q) {
        quests.add(q);
    }

    /**
     * remove a quest from the player's quest list
     * @param q the quest to remove
     */
    public void removeQuest(Quest q) {
        quests.remove(q);
    }

    /**
     * get the player's quest list
     * @return the player's quest list
     */
    public List<Quest> getQuests() {
        return new ArrayList<Quest>(quests);
    }

    /**
     * add doblons(in game money) to the player account
     * 
     * @param doblons the doblons to deposit
     */
    public void depositDoblons(int doblons) {
        this.doblons += doblons;
    }

    /**
     * withdraw doblons(in game money) from the player account
     * 
     * @param doblons the doblons to withdraw
     * @return true if the player has enough doblons to withdraw
     */
    public boolean withdrawDoblons(int doblons) {
        if (this.doblons >= doblons) {
            this.doblons -= doblons;
            return true;
        }
        return false;
    }

    /**
     * get the amount of doblons(in game money) the player has
     * 
     * @return the amount of doblons the player has
     */
    public int getDoblons() {
        return doblons;
    }

    /**
     * give ammo to the RangedWeapon the player is currently using
     * @param ammo the ammo to give
     */
    public void giveAmmo(int ammo){
        if(this.weapon instanceof RangedWeapon){
            ((RangedWeapon) this.weapon).addAmmo(ammo);
        }
    }

    /**
     * get the amount of ammo the RangedWeapon the player is currently using has
     * @return the amount of ammo the RangedWeapon the player is currently using has
     */
    public int getAmmo(){
        if(this.weapon instanceof RangedWeapon){
            return ((RangedWeapon) this.weapon).howManyAmmo();
        }
        return 0;
    }

    /**
     * use ammo from the RangedWeapon the player is currently using
     * @param ammo the ammo to use
     */
    public void useAmmo(int ammo){
        if(this.weapon instanceof RangedWeapon){
            ((RangedWeapon) this.weapon).subtractAmmo(ammo);
        }
    }

    /**
     * check if the player is dead
     * @param w the world the player is in
     * @return true if the player is dead and false otherwise
     */
    public boolean checkDie(World w) {
        if (this.getHealth() <= 0) {
            w.handlePlayerKilled();
            return true;
        }
        return false;
    }

    /**
     * When player dies, loses half doblons and ammunitions in each ranged weapon
     */
    public void deadBehaviour() {
        for (Weapon w : inventoryWeapons) {
            if(w.getWeaponType()==WeaponType.BOW){
                useAmmo(getAmmo()/2);
            }
        }
        withdrawDoblons(doblons/2);
        quests.clear();
    }

}
