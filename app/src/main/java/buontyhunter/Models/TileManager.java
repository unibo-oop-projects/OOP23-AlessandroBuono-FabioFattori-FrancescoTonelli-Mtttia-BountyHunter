package buontyhunter.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import buontyhunter.Common.AssetProvider;
import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.DrawableMap;
import buontyhunter.InputHandlers.InputComponent;
import java.awt.Graphics2D;

public class TileManager extends GameObject {

    private List<List<Tile>> tiles;
    private final Map<Integer, String> maps;
    private final int tileSize;
    private AssetProvider assetManager;
    private DrawableMap graphicsComponent;

    public TileManager(GameObjectType type, DrawableMap graphicsHandler, InputComponent inputComponent, int x, int y,
            int speed, int tileSize) {
        super(type, null, inputComponent, x, y, speed);
        this.tiles = new ArrayList<>();
        this.tileSize = tileSize;
        assetManager = new AssetProvider();

        this.graphicsComponent = graphicsHandler;

        this.maps = new HashMap<>();
        setDefaultValueForMaps();
    }

    private void setDefaultValueForMaps() {

        this.maps.put(0, assetManager.getText("Assets/Maps/map.txt"));

        this.maps.put(1, assetManager.getText("Assets/Maps/hubMap.txt"));
    }

    public void loadMap(int mapId) {
        int x = 0;
        int y = 0;
        int tileId = 0;
        String map = maps.get(mapId);

        for (int i = 0; i < map.length(); i++) {
            char c = map.charAt(i);

            tiles.add(new ArrayList<>());
            if (c == '0') {
                tiles.get(tileId).add(new Tile(assetManager.getImage("Assets/ground.png"), false, x, y));
            } else if (c == '1') {
                tiles.get(tileId).add(new Tile(assetManager.getImage("Assets/border.png"), true, x, y));
            } else if (c == '2') {
                tiles.get(tileId).add(new Tile(assetManager.getImage("Assets/water.png"), true, x, y));
            }
            if (c == '\n') {
                x = 0;
                y += tileSize;
            } else {
                x += tileSize / 2;
            }
            tileId++;

        }
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

    @Override
    public void draw(Graphics2D g2d) {
        this.graphicsComponent.draw(this, g2d);
    }

}
