package buontyhunter.model.event;

import buontyhunter.core.GameFactory;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;
import buontyhunter.model.WorldEvent;

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
