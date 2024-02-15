package buontyhunter.model;

import buontyhunter.core.GameFactory;

public class GameState {

    private int dobloni;
    private World world;
    private boolean gameOver;
    private boolean inTitleScreen;

    public GameState(WorldEventListener l) {

        GameFactory f = GameFactory.getInstance();

        inTitleScreen = true;
        dobloni = 0;
        world = f.createLoadingScreenWorld(l);
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

    /**
     * add doblons(in game money) to the player account
     * 
     * @param doblons the doblons to deposit
     */
    public void depositDoblons(int doblons) {
        this.dobloni += doblons;
    }

    /**
     * withdraw doblons(in game money) from the player account
     * 
     * @param doblons the doblons to withdraw
     * @return true if the player has enough doblons to withdraw
     */
    public boolean withdrawDoblons(int doblons) {
        if (this.dobloni >= doblons) {
            this.dobloni -= doblons;
            return true;
        }
        return false;
    }

    /**
     * get the amount of doblons(in game money) the player has
     * 
     * @return the amount of doblons the player has
     */
    public int getDoblons() {
        return dobloni;
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
