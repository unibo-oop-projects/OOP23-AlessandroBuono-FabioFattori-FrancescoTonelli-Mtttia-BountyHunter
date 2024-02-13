package buontyhunter.model;

import buontyhunter.common.DestinationOfTeleporterType;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class Teleporter extends GameObject {
    
    public static final Point2d HUB_TELEPORT_POS = new Point2d(10,10);
    public static final Point2d OPEN_WORLD_TELEPORT_POS = new Point2d(5,100);
    public final DestinationOfTeleporterType destination;

    public Teleporter(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys , final DestinationOfTeleporterType destination) {
        super(type, pos, vel, box, input, graph, phys);
        this.destination = destination;
    }

    public int getMapIdOfDestination(){
        if(destination == DestinationOfTeleporterType.HUB){
            return 1; 
        }else if(destination == DestinationOfTeleporterType.OpenWorld){
            return 0;
        }
        return -1;
    }
}
