package buontyhunter.model;

import java.util.*;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.Weapon;

public class PlayerEntity extends FighterEntity {

    private List<Quest> quests;
    protected FighterEntityType type = FighterEntityType.PLAYER;
    private int doblons;
    private int ammo;


    public PlayerEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth, Weapon w) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth, w);
        quests = new ArrayList<Quest>();
        this.doblons = 0;
        this.ammo = 0;
    }

    public void addQuest(Quest q) {
        quests.add(q);
    }

    public void removeQuest(Quest q) {
        quests.remove(q);
    }

    public List<Quest> getQuests() {
        return new ArrayList<Quest>(quests);
    }

    /** add doblons(in game money) to the player account
     * @param doblons the doblons to deposit
     */
    public void depositDoblons(int doblons) {
        this.doblons += doblons;
    }

    /** withdraw doblons(in game money) from the player account
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

    /** get the amount of doblons(in game money) the player has
     * @return the amount of doblons the player has
     */
    public int getDoblons() {
        return doblons;
    }

    public void giveAmmo(int ammo){
        this.ammo += ammo;
    }
    
}
