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

    /**
     * Get the current world
     * @return the current world
     */
    public World getWorld() {
        return world;
    }

    /**
     * 
     * @return
     */
    public boolean isInTitleScreen() {
        return inTitleScreen;
    }

    /**
     * set inTitleScreen to false to start the game
     */
    public void startGame() {
        inTitleScreen = false;
    }

    /**
     * get the game started status
     * @return true if the game has started and false otherwise
     */
    public boolean isGameStarted() {
        return !inTitleScreen;
    }

    /**
     * set the current world
     * @param newWorld the new world
     */
    public void setWorld(World newWorld) {
        this.world = newWorld;
    }

    /**
     * get the game over status
     * @return true if the game is over and false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * set the game over status to true
     */
    public void gameOver() {
        gameOver = true;
    }

    /**
     * update the game state 
     * @param dt the time since the last update
     */
    public void update(int dt) {
        world.updateState(dt);
    }
}
