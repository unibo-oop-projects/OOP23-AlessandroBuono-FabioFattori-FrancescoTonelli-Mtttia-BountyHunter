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

        this.maps.put(0, assetManager.getText("Assets/maps/map.txt").orElse(""));

        this.maps.put(1, assetManager.getText("Assets/maps/hubMap.txt").orElse(""));
    }

    public RectBoundingBox loadMap(int mapId) {
        double height = 0, width = 0;
        String map = maps.get(mapId);
        String[] lines = map.split("\n");
        height = lines.length;
        for (int i = 0; i < lines.length; i++) {
            String[] tiles = lines[i].split(" ");
            List<Tile> row = new ArrayList<>();
            width = tiles.length;
            for (int j = 0; j < tiles.length; j++) {
                int tileId = Integer.parseInt(tiles[j]);
                
                if(tileId == 5) {
                    row.add(new Tile(getTileImage(tileId), true, true, new Point2d(j, i),tileId));
                }else{
                    row.add(new Tile(getTileImage(tileId), false, true, new Point2d(j, i),tileId));
                }
            }
            this.tiles.add(row);
        }

        var bbox = new RectBoundingBox(new Point2d(0, 0), height, width);
        setBBox(bbox);
        return bbox;
    }

    private BufferedImage getTileImage(int num) {
        String tileName = resolveAssetName(num).orElse("ground.png");
        return assetManager.getImage("Assets/" + tileName);
    }

    private Optional<String> resolveAssetName(int num) {
        switch (num) {
            case 0:
                return Optional.of("earth.png");
            case 1:
                return Optional.of("grass.png");
            case 2:
                return Optional.of("sand.png");
            case 3:
                return Optional.of("tree.png");
            case 4:
                return Optional.of("wall.png");
            case 5:
                return Optional.of("water.png");
        }

        return Optional.empty();
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

}