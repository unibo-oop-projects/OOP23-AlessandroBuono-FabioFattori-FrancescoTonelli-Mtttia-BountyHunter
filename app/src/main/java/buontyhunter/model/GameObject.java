package buontyhunter.model;

import buontyhunter.Graphics.Graphics;
import buontyhunter.Common.*;
import buontyhunter.Graphics.GraphicsComponent;
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

    public GameObjectType getType() {
        return type;
    }

    public void setPos(Point2d pos) {
        this.pos = pos;
    }

    public void setVel(Vector2d vel) {
        this.vel = vel;
    }

    public void flipVelOnY() {
        this.vel = new Vector2d(vel.x, -vel.y);
    }

    public void flipVelOnX() {
        this.vel = new Vector2d(-vel.x, vel.y);
    }

    public BoundingBox getBBox() {
        return bbox;
    }

    public Point2d getPos() {
        return pos;
    }

    public Vector2d getVel() {
        return vel;
    }

    public void updateInput(InputController c) {
        input.update(this, c);
    }

    public void updatePhysics(long dt, World w) {
        phys.update(dt, this, w);
    }

    public void updateGraphics(Graphics g, World w) {
        graph.update(this, g, w);
    }

    protected void setBBox(BoundingBox box) {
        this.bbox = box;
    }
}
