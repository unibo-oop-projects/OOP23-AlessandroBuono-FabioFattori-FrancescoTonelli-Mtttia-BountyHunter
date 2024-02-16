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

    public PlayerEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth, Weapon w) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth, w);
        quests = new ArrayList<Quest>();
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

}
