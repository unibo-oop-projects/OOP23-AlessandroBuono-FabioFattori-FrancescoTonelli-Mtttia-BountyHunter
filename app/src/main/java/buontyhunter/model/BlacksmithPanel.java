package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class BlacksmithPanel extends HidableObject{

    private BlacksmithEntity blacksmith;

    public BlacksmithPanel(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, boolean show) {
        super(type, pos, vel, box, input, graph, phys, show);
        this.blacksmith = new BlacksmithEntity(GameObjectType.InterractableArea, pos, vel, box, this);
    }

    public BlacksmithEntity getBlacksmith(){
        return this.blacksmith;
    }
    
}
