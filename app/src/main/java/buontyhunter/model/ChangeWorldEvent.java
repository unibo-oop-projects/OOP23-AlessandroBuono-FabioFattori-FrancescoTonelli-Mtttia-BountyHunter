package buontyhunter.model;

import buontyhunter.common.DestinationOfTeleporterType;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;

public class ChangeWorldEvent implements WorldEvent {
    private final World newWorldToSet;

    public ChangeWorldEvent(int newMapId, World oldWorld) throws Exception {
        GameFactory f = GameFactory.getInstance();

        if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.HUB) {
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 16, 16));
            this.newWorldToSet.setNavigatorLine(f.createNavigatorLine(this.newWorldToSet));
            // creo il word dell'hub
            this.newWorldToSet.setTileManager(f.createTileManager(), newMapId);
            oldWorld.getPlayer().setPos(GameEngine.HUB_PLAYER_START);
            this.newWorldToSet.setPlayer(oldWorld.getPlayer()); 
            this.newWorldToSet
                    .setTeleporter(f.createTeleporterToOpenWorld());
            this.newWorldToSet.addInterractableArea(f.createQuestPannelForHub(new Point2d(7, 5)));
            this.newWorldToSet.addInterractableArea(f.createBlacksmithForHub(new Point2d(2, 5)));
            this.newWorldToSet.setQuestJournal(f.createQuestJournal());
            this.newWorldToSet.disableEnemies();
            return;
        } else if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.OpenWorld) {
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
            this.newWorldToSet.setMiniMap(f.createMinimap());
            this.newWorldToSet.setNavigatorLine(f.createNavigatorLine(this.newWorldToSet));
            // creo il world dell'open world
            this.newWorldToSet.setTileManager(f.createTileManager(), newMapId);
            oldWorld.getPlayer().setPos(GameEngine.OPEN_WORLD_PLAYER_START);
            this.newWorldToSet.setPlayer(oldWorld.getPlayer());
            this.newWorldToSet.setTeleporter(f.createTeleporterToHub());
            this.newWorldToSet.setQuestJournal(f.createQuestJournal());
            return;
        }
        throw new Exception("Invalid Destination passed");

    }

    public World getNewWorld() {
        return this.newWorldToSet;
    }
}
