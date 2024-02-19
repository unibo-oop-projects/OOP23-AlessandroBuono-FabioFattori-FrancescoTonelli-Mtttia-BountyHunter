package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class HidableObject extends GameObject {

    private boolean show;

    public HidableObject(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, boolean show) {
        super(type, pos, vel, box, input, graph, phys);

        this.show = show;
    }

    /**
     * get the show status of the HidableObject
     * @return true if the object is shown and false otherwise
     */
    public boolean isShow() {
        return show;
    }

    /**
     * set the show status of the HidableObject
     * @param show the new show status
     */
    public void setShow(boolean show) {
        this.show = show;
    }

    /**
     * toggle the show status of the HidableObject
     */
    public void toggleShow() {
        show = !show;
    }
}
