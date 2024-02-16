package buontyhunter.model;

import buontyhunter.core.GameFactory;

public class GameState {

    
    private World world;
    private boolean gameOver;
    private boolean inTitleScreen;

    public GameState(WorldEventListener l) {

        GameFactory f = GameFactory.getInstance();

        world = f.createLoadingScreenWorld(l);
        inTitleScreen = true;
    }

    public World getWorld() {
        return world;
    }

    public boolean isInTitleScreen() {
        return inTitleScreen;
    }

    public void startGame() {
        inTitleScreen = false;
    }

    public boolean isGameStarted() {
        return !inTitleScreen;
    }

    public void setWorld(World newWorld) {
        this.world = newWorld;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void gameOver() {
        gameOver = true;
    }

    public void update(int dt) {
        world.updateState(dt);
    }
}
