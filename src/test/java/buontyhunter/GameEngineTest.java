package buontyhunter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.model.GameState;
import buontyhunter.model.World;

class GameEngineTest {

    @Test
    void testGameEngine() {
        GameEngine gameEngine = new GameEngine();
        Assertions.assertNotNull(gameEngine);
        Assertions.assertEquals(GameEngine.HUB_PLAYER_START, new Point2d(8, 8));
        Assertions.assertEquals(GameEngine.OPEN_WORLD_PLAYER_START, new Point2d(5, 106));
    }

    @Test
    void testGameState() {
        GameState gameState = new GameState(new GameEngine());
        Assertions.assertNotNull(gameState);
        Assertions.assertFalse(gameState.isGameOver());
        gameState.gameOver();
        Assertions.assertTrue(gameState.isGameOver());
    }

    @Test
    void testAllWorlds() {
        GameEngine engine = new GameEngine();

        World world = GameFactory.getInstance().createLoadingScreenWorld(engine);
        world = GameFactory.getInstance().createHubWorld(world);
        testWorld(world);
        world = GameFactory.getInstance().createOpenWorld(world);
        testWorld(world);
    }

    void testWorld(World world) {
        Assertions.assertNotNull(world);
        world.disableEnemies();
        Assertions.assertEquals(world.getEnemies().size(), 0);
        world.enableEnemies();
        Assertions.assertNotNull(world.getPlayer());
        Assertions.assertNotNull(world.getBBox());
        Assertions.assertNotNull(world.getTileManager());
        Assertions.assertNotNull(world.getTeleporter());
    }
}
