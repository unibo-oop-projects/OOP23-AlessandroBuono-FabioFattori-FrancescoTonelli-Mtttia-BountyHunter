package buontyhunter.model;

import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.common.Point2d;
import buontyhunter.common.Resizator;
import buontyhunter.common.Vector2d;

public class GameState {

    
    private World world;
    private boolean gameOver;

    public GameState(WorldEventListener l) {

        GameFactory f = GameFactory.getInstance();

        world = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
        world.setPlayer(f.createPlayer(GameEngine.OPEN_WORLD_PLAYER_START, Vector2d.symmetrical(0), 10, 100));
        world.setTileManager(f.createTileManager(),0);
        world.setMiniMap(f.createMinimap());
        world.setNavigatorLine(f.createNavigatorLine(world));
        world.setEventListener(l);
        world.setTeleporter(f.createTeleporterToHub());
        world.setQuestJournal(f.createQuestJournal());
    }

    public World getWorld() {
        return world;
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
