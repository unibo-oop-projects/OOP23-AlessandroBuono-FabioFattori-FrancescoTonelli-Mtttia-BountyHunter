package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class FighterEntity extends GameObject {

    private int health;
    private final int maxHealth;

    public FighterEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health,final int maxHealth) {
        super(type, pos, vel, box, input, graph, phys);
        setHealth(health);
        if(maxHealth >= health) {
            this.maxHealth = maxHealth;
        }else {
            throw new IllegalArgumentException("Max health must be greater than health");
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int healt) {
        if (healt <= 0) {
            throw new IllegalArgumentException("Healt must be positive");
        }
        this.health = healt;
    }
}
