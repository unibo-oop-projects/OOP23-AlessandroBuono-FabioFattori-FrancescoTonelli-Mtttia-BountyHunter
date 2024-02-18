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

    /**
     * get the loading time of the LoadingBar
     * @return the loading time of the LoadingBar
     */
    public int getLoadingTime() {
        return loadingTime;
    }

    /**
     * get the current loaded amount of the LoadingBar
     * @return the current loaded amount of the LoadingBar
     */
    public int getCurrentLoaded() {
        return currentLoaded;
    }

    /**
     * get the loaded status of the LoadingBar
     * @return true if the LoadingBar is loaded and false otherwise
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * get the loading start status of the LoadingBar
     * @return true if the LoadingBar is started loading and false otherwise
     */
    public boolean loadingIsStarted() {
        return startLoading;
    }

    /**
     * start the loading of the LoadingBar
     */
    public void startLoading() {
        this.startLoading = true;
    }

    /**
     * advance the loading time of the LoadingBar
     */
    public void advanceLoadingTime() {
        this.currentLoaded += (int) (Math.random() * loadingTime / 40);
        if(this.currentLoaded >= loadingTime) {
            this.isLoaded = true;
        }
    }

}
