package buontyhunter.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Optional;

import java.util.List;

import buontyhunter.common.AssetProvider;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

public class TileManager extends GameObject {

    private List<List<Tile>> tiles;
    private final Map<Integer, String> maps;
    private AssetProvider assetManager;

    public TileManager(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys) {
        super(type, pos, vel, box, input, graph, phys);

        this.tiles = new ArrayList<>();
        assetManager = new AssetProvider();

        this.maps = new HashMap<>();
        setDefaultValueForMaps();
    }

    private void setDefaultValueForMaps() {

        this.maps.put(0, assetManager.getText("Assets/Maps/map.txt"));

        this.maps.put(1, assetManager.getText("Assets/Maps/hubMap.txt"));

        loadMap(0);
    }

    public void loadMap(int mapId) {
        String map = maps.get(mapId);
        String[] lines = map.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] tiles = lines[i].split(" ");
            List<Tile> row = new ArrayList<>();
            for (int j = 0; j < tiles.length; j++) {
                int tileId = Integer.parseInt(tiles[j]);
                row.add(new Tile(getTileImage(tileId), tileId, true, new Point2d(j, i)));
            }
            this.tiles.add(row);
        }
    }

    private BufferedImage getTileImage(int num) {
        String tileName = resolveAssetName(num).orElse("ground.png");
        return assetManager.getImage("Assets/" + tileName);
    }

    private Optional<String> resolveAssetName(int num) {
        switch (num) {
            case 0:
                return Optional.of("ground.png");
            case 1:
                return Optional.of("border.png");
            case 2:
                return Optional.of("water.png");
        }

        return Optional.empty();
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }
}
