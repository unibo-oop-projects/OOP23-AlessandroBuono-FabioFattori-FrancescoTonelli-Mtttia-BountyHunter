package buontyhunter.model;

import buontyhunter.graphics.Graphics;
import buontyhunter.common.*;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.input.InputController;
import buontyhunter.physics.PhysicsComponent;

public class GameObject {

    private GameObjectType type;
    private Point2d pos;
    private Vector2d vel;
    private BoundingBox bbox;

    private InputComponent input;
    private GraphicsComponent graph;
    private PhysicsComponent phys;

    /**
     * Create a new game object
     * @param type this entity type serve to identify the entity (it can be player, enemy, etc)
     * @param pos initial position of the entity
     * @param vel initial velocity of the entity
     * @param box TODO: what is this?
     * @param input InputComponent that will be used to control the entity while playing
     * @param graph GraphicsComponent that will be used to draw the entity
     * @param phys PhysicsComponent that will be used to calculate the entity physics when an event occurs (Example: collision)
     */
    public GameObject(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph,
            PhysicsComponent phys) {
        this.type = type;
        this.pos = pos;
        this.vel = vel;
        this.bbox = box;
        this.input = input;
        this.graph = graph;
        this.phys = phys;
    }

    /**
     * Get the type of the game object which is used to identify the object
     * @return the type of the game object
     */
    public GameObjectType getType() {
        return type;
    }

    /**
     * Set the type of the game object which is used to identify the object
     * @param pos the new type of the game object
     */
    public void setPos(Point2d pos) {
        this.pos = pos;
    }

    /**
     * Set the velocity of the game object
     * @param vel the new velocity of the game object
     */
    public void setVel(Vector2d vel) {
        this.vel = vel;
    }

    /**
     * Flip the velocity of the game object on the Y axis
     */
    public void flipVelOnY() {
        this.vel = new Vector2d(vel.x, -vel.y);
    }

    /**
     * Flip the velocity of the game object on the X axis
     */
    public void flipVelOnX() {
        this.vel = new Vector2d(-vel.x, vel.y);
    }

    /**
     * TODO: what is this?
     */
    public BoundingBox getBBox() {
        return bbox;
    }

    /**
     * Get the current position of the game object
     * @return the current position of the game object
     */
    public Point2d getPos() {
        return pos;
    }

    /**
     * Get the current velocity of the game object
     * @return the current velocity of the game object
     */
    public Vector2d getVel() {
        return vel;
    }

    /**
     * Get the input component of the game object
     * @return the input component of the game object
     */
    public void updateInput(InputController c) {
        input.update(this, c);
    }

    /**
     * Get the physics component of the game object
     * @return the physics component of the game object
     */
    public void updatePhysics(long dt, World w) {
        phys.update(dt, this, w);
    }

    /**
     * Get the graphics component of the game object
     * @return the graphics component of the game object
     */
    public void updateGraphics(Graphics g, World w) {
        graph.update(this, g, w);
    }

    /**
     * Set the bounding box of the game object
     * @param box the new bounding box of the game object
     */
    protected void setBBox(BoundingBox box) {
        this.bbox = box;
    }
}
