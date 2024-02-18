package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class DamagingArea extends HidableObject {

    private FighterEntity owner;

    public DamagingArea(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, boolean show, FighterEntity owner) {
        super(type, pos, vel, box, input, graph, phys, show);

        this.owner = owner;
    }

    /**
     * get the owner of the damaging area
     * @return the owner of the damaging area
     */
    public FighterEntity getOwner() {
        return owner;
    }

}
