package buontyhunter.model;

import buontyhunter.common.DestinationOfTeleporterType;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameFactory;

public class ChangeWorldEvent implements WorldEvent {
    private final World newWorldToSet;

    public ChangeWorldEvent(int newMapId, World oldWorld) throws Exception {

        if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.HUB) {
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 16, 16));
            this.newWorldToSet.setNavigatorLine(GameFactory.getInstance().createNavigatorLine(this.newWorldToSet));
            // creo il word dell'hub
            this.newWorldToSet.setTileManager(GameFactory.getInstance().creaTileManagerForHub(), newMapId);

            this.newWorldToSet.setPlayer(GameFactory.getInstance().createPlayer(new Point2d(8, 8),
                    oldWorld.getPlayer().getVel(), ((FighterEntity) oldWorld.getPlayer()).getHealth(),
                    ((FighterEntity) oldWorld.getPlayer()).getMaxHealth()));
            this.newWorldToSet
                    .setTeleporter(GameFactory.getInstance().createTeleporterToOpenWorld());
            return;
        } else if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.OpenWorld) {
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
            this.newWorldToSet.setMiniMap(GameFactory.getInstance().createMinimap());
            this.newWorldToSet.setNavigatorLine(GameFactory.getInstance().createNavigatorLine(this.newWorldToSet));
            // creo il world dell'open world
            this.newWorldToSet.setTileManager(GameFactory.getInstance().createTileManager(), newMapId);

            this.newWorldToSet.setPlayer(GameFactory.getInstance().createPlayer(new Point2d(0, 0),
                    oldWorld.getPlayer().getVel(), ((FighterEntity) oldWorld.getPlayer()).getHealth(),
                    ((FighterEntity) oldWorld.getPlayer()).getMaxHealth()));
            this.newWorldToSet.setTeleporter(GameFactory.getInstance().createTeleporterToHub());
            return;
        }
        throw new Exception("Invalid Destination passed");

    }

    public World getNewWorld() {
        return this.newWorldToSet;
    }
}
