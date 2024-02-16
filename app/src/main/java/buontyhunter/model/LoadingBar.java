package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class LoadingBar extends GameObject {
    private final int loadingTime;
    private int currentLoaded;
    private boolean isLoaded;
    private boolean startLoading;

    public LoadingBar(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys) {
        super(type, pos, vel, box, input, graph, phys);
        this.loadingTime = GameEngine.RESIZATOR.getWINDOW_WIDTH() - 20;
        this.currentLoaded = 0;
        this.isLoaded = false;
        this.startLoading = false;
    }

    public int getLoadingTime() {
        return loadingTime;
    }

    public int getCurrentLoaded() {
        return currentLoaded;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public boolean loadingIsStarted() {
        return startLoading;
    }

    public void startLoading() {
        this.startLoading = true;
    }

    public void advanceLoadingTime() {
        this.currentLoaded += (int) (Math.random() * loadingTime / 40);
        if(this.currentLoaded >= loadingTime) {
            this.isLoaded = true;
        }
    }

}
