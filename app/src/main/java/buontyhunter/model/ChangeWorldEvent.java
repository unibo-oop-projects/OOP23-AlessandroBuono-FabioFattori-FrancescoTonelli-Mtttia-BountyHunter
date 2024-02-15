package buontyhunter.model;

import buontyhunter.common.DestinationOfTeleporterType;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;

public class ChangeWorldEvent implements WorldEvent {
    private final World newWorldToSet;

    public ChangeWorldEvent(int newMapId, World oldWorld) {
        GameFactory f = GameFactory.getInstance();

        if (newMapId == TileManager.HUB_MAP_ID) {
            this.newWorldToSet = f.createHubWorld(oldWorld);
        } else if (newMapId == TileManager.OPEN_WORLD_MAP_ID) {
            this.newWorldToSet = f.createOpenWorld(oldWorld);
        } else {
            this.newWorldToSet = f.createLoadingScreenWorld(oldWorld.getEventListener());
        }
    }

    public World getNewWorld() {
        return this.newWorldToSet;
    }
}
