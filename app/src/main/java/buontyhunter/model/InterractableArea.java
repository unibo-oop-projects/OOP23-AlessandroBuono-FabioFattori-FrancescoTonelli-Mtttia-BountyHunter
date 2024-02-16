package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.AreaInMapGraphicsComponent;
import buontyhunter.graphics.Graphics;
import buontyhunter.input.InputController;
import buontyhunter.input.NullInputComponent;
import buontyhunter.physics.NullPhysicsComponent;

public class InterractableArea extends GameObject {
    private HidableObject panel;
    private GameObject areaInMap;
    private boolean playerInArea = false;
    private boolean readyToUpdate = true;

    public InterractableArea(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, HidableObject panel) {
        super(type, pos, vel, box, null, null, null);
        this.panel = panel;
        this.areaInMap = new GameObject(type, pos, vel, box, new NullInputComponent(),
                new AreaInMapGraphicsComponent("Press E to interact"), new NullPhysicsComponent());
    }

    /**
     * Get the input component of the game object
     * 
     * @return the input component of the game object
     */
    public void updateInput(InputController c) {
        if (playerInArea) {
            if (c.isEPressed()) {
                if (readyToUpdate) {
                    this.panel.toggleShow();
                    readyToUpdate = false;
                }
            } else {
                readyToUpdate = true;
            }
        } else {
            this.panel.setShow(false);
        }
    }

    /**
     * Get the physics component of the game object
     * 
     * @return the physics component of the game object
     */
    public void updatePhysics(long dt, World w) {
        CollisionDetector detector = new CollisionDetector();
        if (detector.isColliding((RectBoundingBox) areaInMap.getBBox(), w.getPlayer().getPos())) {
            playerInArea = true;
        } else {
            playerInArea = false;
        }
    }

    /**
     * Get the graphics component of the game object
     * 
     * @return the graphics component of the game object
     */
    public void updateGraphics(Graphics g, World w) {
        if (playerInArea) {
            if (!panel.isShow()) {
                this.areaInMap.updateGraphics(g, w);
            } else {
                this.panel.updateGraphics(g, w);
            }
        }
    }

    /**
     * @return the panel which is the object that will be shown when the player is
     *         in the area and press the action key
     */
    public HidableObject getPanel() {
        return panel;
    }

    /**
     * @return the areaInMap in which the player needs to be to be able to
     *         open/close the panel
     */
    public GameObject getAreaInMap() {
        return areaInMap;
    }

}
