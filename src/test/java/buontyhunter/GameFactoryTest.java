package buontyhunter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameFactory;
import buontyhunter.model.HealthBar;
import buontyhunter.model.HidableObject;
import buontyhunter.model.InterractableArea;
import buontyhunter.model.PlayerEntity;
import buontyhunter.model.QuestPannel;
import buontyhunter.model.Teleporter;
import buontyhunter.model.TileManager;

class GameFactoryTest {
    
    @Test 
    void testGameFactory() {
        GameFactory gameFactory = GameFactory.getInstance();
        Assertions.assertNotNull(gameFactory);
        Assertions.assertNotNull(gameFactory.createPlayer(new Point2d(0, 0), new Vector2d(0, 0), 0, 0));
        // Assertions.assertNotNull(gameFactory.createEnemy(new Point2d(0, 0),new
        // Vector2d(0,0), 0, 0,null));
        Assertions.assertNotNull(gameFactory.createQuests());
        Assertions.assertNotNull(gameFactory.createTileManager());
        Assertions.assertNotNull(gameFactory.createTeleporterToHub());
        Assertions.assertNotNull(gameFactory.createTeleporterToOpenWorld());
        Assertions.assertNotNull(gameFactory.createMinimap());
        Assertions.assertNotNull(gameFactory.createHealthBar());
        Assertions.assertNotNull(gameFactory.createQuestJournal());
        Assertions.assertNotNull(gameFactory.createQuestPannelForHub(new Point2d(0, 0)));
        if (!(gameFactory.createHealthBar() instanceof HealthBar)) {
            Assertions.fail();
        }
        if (!(gameFactory.createMinimap() instanceof HidableObject)) {
            Assertions.fail();
        }
        if (!(gameFactory.createQuestJournal() instanceof HidableObject)) {
            Assertions.fail();
        }
        if (!(gameFactory.createQuestPannelForHub(new Point2d(0, 0)) instanceof InterractableArea)) {
            Assertions.fail();
        } else if (!(gameFactory.createQuestPannelForHub(new Point2d(0, 0)).getPanel() instanceof QuestPannel)) {
            Assertions.fail();
        }
        if (!(gameFactory.createTeleporterToHub() instanceof Teleporter)) {
            Assertions.fail();
        } else if (gameFactory.createTeleporterToHub().getMapIdOfDestination() != 1) {
            Assertions.fail();
        }
        if (!(gameFactory.createTeleporterToOpenWorld() instanceof Teleporter)) {
            Assertions.fail();
        } else if (gameFactory.createTeleporterToOpenWorld().getMapIdOfDestination() != 0) {
            Assertions.fail();
        }
        if (!(gameFactory.createTileManager() instanceof TileManager)) {
            Assertions.fail();
        }
        // if (!(gameFactory.createEnemy(new Point2d(0, 0), new Vector2d(0, 0), 0, 0,
        // null) instanceof EnemyEntity)) {
        // Assertions.fail();
        // }
        if (!(gameFactory.createPlayer(new Point2d(0, 0), new Vector2d(0, 0), 0, 0) instanceof PlayerEntity)) {
            Assertions.fail();
        }
    }
}
