package buontyhunter.model;

import java.util.List;

import java.util.ArrayList;

public class World {
    private GameObject player;
    private TileManager tileManager;
    private RectBoundingBox mainBBox;
    private WorldEventListener evListener;

    public World(RectBoundingBox bbox) {
        mainBBox = bbox;
    }

    public void setEventListener(WorldEventListener l) {
        evListener = l;
    }

    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public void setPlayer(GameObject player) {
        this.player = player;
    }

    public void updateState(long dt) {
        if (player != null) {
            player.updatePhysics(dt, null);
        }
    }

    public void notifyWorldEvent(WorldEvent ev) {
        evListener.notifyEvent(ev);
    }

    public RectBoundingBox getBBox() {
        return mainBBox;
    }

    public GameObject getPlayer() {
        return player;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public List<GameObject> getSceneEntities() {
        List<GameObject> entities = new ArrayList<GameObject>();
        if (tileManager != null)
            entities.add(tileManager);
        if (player != null)
            entities.add(player);
        return entities;
    }
}
