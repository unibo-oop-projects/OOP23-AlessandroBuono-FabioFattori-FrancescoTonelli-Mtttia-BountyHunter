package buontyhunter.model;

import buontyhunter.common.DestinationOfTeleporterType;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameFactory;

public class ChangeWorldEvent implements WorldEvent {
    private final World newWorldToSet;

    public ChangeWorldEvent(int newMapId, World oldWorld) throws Exception {
        if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.HUB) {
            // creo il word dell'hub
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
            this.newWorldToSet.setPlayer(GameFactory.getInstance().createPlayer(new Point2d(0, 0),
                    oldWorld.getPlayer().getVel(), ((FighterEntity) oldWorld.getPlayer()).getHealth(),
                    ((FighterEntity) oldWorld.getPlayer()).getMaxHealth()));
            this.newWorldToSet.setTileManager(GameFactory.getInstance().createTileManager(), newMapId);
            this.newWorldToSet.setMiniMap(GameFactory.getInstance().createMinimap());
            this.newWorldToSet
                    .setTeleporter(GameFactory.getInstance().createTeleporterToOpenWorld(new Point2d(100, 100)));
            this.newWorldToSet.setNavigatorLine(GameFactory.getInstance().createNavigatorLine(this.newWorldToSet));

            return;
        } else if (oldWorld.getTeleporter().destination == DestinationOfTeleporterType.OpenWorld) {
            // creo il world dell'open world
            this.newWorldToSet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
            this.newWorldToSet.setPlayer(GameFactory.getInstance().createPlayer(new Point2d(0, 0),
                    oldWorld.getPlayer().getVel(), ((FighterEntity) oldWorld.getPlayer()).getHealth(),
                    ((FighterEntity) oldWorld.getPlayer()).getMaxHealth()));
            this.newWorldToSet.setTileManager(GameFactory.getInstance().createTileManager(), newMapId);
            this.newWorldToSet.setMiniMap(GameFactory.getInstance().createMinimap());
            this.newWorldToSet.setNavigatorLine(GameFactory.getInstance().createNavigatorLine(this.newWorldToSet));
            this.newWorldToSet.setTeleporter(GameFactory.getInstance().createTeleporterToHub(new Point2d(50, 50)));
            return;
        }
        this.newWorldToSet = null;
        throw new Exception("Invalid Destination passed");

    }

    public World getNewWorld() {
        return this.newWorldToSet;
    }
}
