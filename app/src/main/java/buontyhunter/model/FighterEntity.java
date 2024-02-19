package buontyhunter.model;

import buontyhunter.common.Direction;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameFactory;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponFactory;

public class FighterEntity extends GameObject {

    public enum MovementState {
        FIRST,
        SECOND
    }

    private int health;
    private final int maxHealth;
    protected Weapon weapon;
    private HidableObject damagingArea;
    private Direction direction = Direction.STAND_DOWN;
    private MovementState movementState = MovementState.SECOND;
    protected FighterEntityType type = FighterEntityType.PLAYER;

    /**
     * Create a new fighter entity which is a game object with health
     * 
     * @param type      this entity type serve to identify the entity (it can be
     *                  player, enemy, etc)
     * @param pos       initial position of the entity
     * @param vel       initial velocity of the entity
     * @param box       bounding box of the entity
     * @param input     InputComponent that will be used to control the entity while
     *                  playing
     * @param graph     GraphicsComponent that will be used to draw the entity
     * @param phys      PhysicsComponent that will be used to calculate the entity
     *                  physics when an event occurs (Example: collision)
     * @param health    initial health of the entity
     * @param maxHealth maximum health that the entity can have
     * @param w         default equipped weapon
     */
    public FighterEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, final int maxHealth, Weapon w) {
        super(type, pos, vel, box, input, graph, phys);
        setHealth(health);
        if (maxHealth >= health) {
            this.maxHealth = maxHealth;
        } else {
            throw new IllegalArgumentException("Max health must be greater than health");
        }
        weapon = w;
        if (weapon == null) {
            weapon = WeaponFactory.getInstance().createBrassKnuckles(this);
        }
        damagingArea = GameFactory.getInstance().WeaponDamagingArea((FighterEntity) this, new Vector2d(0, 0));
    }

    /**
     * Get the current health of the entity
     * 
     * @return the current health of the entity
     */
    public int getHealth() {
        return health;
    }

    /**
     * Get the maximum health of the entity
     * 
     * @return the maximum health of the entity
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Set the weapon of the entity
     * @param w the new weapon of the entity
     */
    public void setWeapon(Weapon w) {
        weapon = w;
    }

    /**
     * Get the weapon of the entity
     * @return the weapon of the entity
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Get the damaging area of the entity
     * @return the damaging area of the entity
     */
    public HidableObject getDamagingArea() {
        return damagingArea;
    }

    /**
     * This method is used to make the entity take damage
     * @param damage the amount of damage that the entity will take
     */
    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    /**
     * Set the health of the entity
     * 
     * @param healt the new health of the entity (must be positive and less than the maximum health of the entity)
     */
    public void setHealth(int healt) {
        this.health = healt;
    }

    /**
     * set the damaging area of the entity
     * @param da the new damaging area of the entity
     */
    public void setDamagingArea(HidableObject da) {
        this.damagingArea = da;
    }

    /**
     * Set the direction of the entity
     * @param direction the new direction of the entity
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * get the direction of the entity
     * @return the direction of the entity
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Get the movement state of the entity
     * @return the movement state of the entity
     */
    public MovementState getMovementState() {
        switchMovementState();
        return this.movementState;
    }

    private void switchMovementState() {
        if (this.movementState.equals(MovementState.FIRST)) {
            this.movementState = MovementState.SECOND;
        } else {
            this.movementState = MovementState.FIRST;
        }
    }

    /**
     * Get the type of the entity
     * @return the type of the entity
     */
    public FighterEntityType getFighterType() {
        return this.type;
    }
}
