package buontyhunter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameFactory;
import buontyhunter.model.PlayerEntity;
import buontyhunter.model.QuestEntity;

class PlayerEntityTest {
    
    @Test
    void testPlayerEntity() {
         PlayerEntity player = GameFactory.getInstance().createPlayer(new Point2d(0, 0), new Vector2d(0, 0), 0, 0);
        Assertions.assertNotNull(player);
        Assertions.assertNotNull(player.getBBox());
        Assertions.assertNotNull(player.getQuests());
        Assertions.assertEquals(player.getQuests().size(), 0);
        player.addQuest(new QuestEntity("test", "test", 0, null, 0));
        Assertions.assertEquals(player.getQuests().size(), 1);
        player.removeQuest(new QuestEntity("test", "test", 0, null, 0));
        Assertions.assertEquals(player.getQuests().size(), 0);
        player.getQuests().add(new QuestEntity("test", "test", 0, null, 0));
        Assertions.assertEquals(player.getQuests().size(), 0);
        Assertions.assertDoesNotThrow(() -> player.removeQuest(new QuestEntity("test1", "test1", 0, null, 0)));
        player.depositDoblons(10);
        Assertions.assertEquals(player.getDoblons(), 10);
        player.withdrawDoblons(5);
        Assertions.assertEquals(player.getDoblons(), 5);
        Assertions.assertFalse(player.withdrawDoblons(10));
        Assertions.assertEquals(player.getDoblons(), 5);
    }
}
