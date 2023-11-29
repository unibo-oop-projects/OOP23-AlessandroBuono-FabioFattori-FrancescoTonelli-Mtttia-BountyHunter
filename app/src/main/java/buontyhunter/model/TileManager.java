package buontyhunter.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Optional;

import java.util.List;

import buontyhunter.common.AssetProvider;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
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
                var tileId = getTileType(Integer.parseInt(tiles[j]));

                if (tileId == TileType.tree || tileId == TileType.wall) {
                    row.add(new Tile(getTileImage(tileId), true, true, new Point2d(j, i), tileId));
                } else if (tileId == TileType.water) {
                    row.add(new Tile(getTileImage(tileId), false, true, new Point2d(j, i), tileId));
                } else {
                    row.add(new Tile(getTileImage(tileId), false, false, new Point2d(j, i), tileId));
                }
            }
            this.tiles.add(row);
        }

        var bbox = new RectBoundingBox(new Point2d(0, 0), height, width);
        setBBox(bbox);
        return bbox;
    }

    private Image getTileImage(TileType tileType) {
        String tileName = resolveAssetName(tileType).orElse("ground.png");
        return assetManager.getImage("Assets/" + tileName).getScaledInstance(
                (int) Math.floor(GameEngine.WINDOW_WIDTH / GameEngine.WORLD_WIDTH),
                (int) Math.floor(GameEngine.WINDOW_HEIGHT / GameEngine.WORLD_HEIGHT),
                Image.SCALE_DEFAULT);
    }

    private Optional<String> resolveAssetName(TileType tileType) {
        switch (tileType) {
            case earth:
                return Optional.of("earth.png");
            case grass:
                return Optional.of("grass.png");
            case sand:
                return Optional.of("sand.png");
            case tree:
                return Optional.of("tree.png");
            case wall:
                return Optional.of("wall.png");
            case water:
                return Optional.of("water.png");
            case empty:
            default:
                return Optional.empty();
        }
    }

    private TileType getTileType(int num) {
        switch (num) {
            case 0:
                return TileType.earth;
            case 1:
                return TileType.grass;
            case 2:
                return TileType.sand;
            case 3:
                return TileType.tree;
            case 4:
                return TileType.wall;
            case 5:
                return TileType.water;
        }

        return TileType.empty;
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

}