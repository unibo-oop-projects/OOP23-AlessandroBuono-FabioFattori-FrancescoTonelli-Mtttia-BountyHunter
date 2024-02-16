package buontyhunter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import buontyhunter.common.FileProvider;
import buontyhunter.common.ImageType;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import java.util.*;

public class TileManager extends GameObject {

    private List<List<Tile>> tiles;
    private final Map<Integer, String> maps;
    private FileProvider fileProvider;
    public static final int HUB_MAP_ID = 1;
    public static final int OPEN_WORLD_MAP_ID = 0;

    public TileManager(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys) {
        super(type, pos, vel, box, input, graph, phys);

        this.tiles = new ArrayList<>();
        fileProvider = new FileProvider();

        this.maps = new HashMap<>();
        setDefaultValueForMaps();
    }

    private void setDefaultValueForMaps() {

        this.maps.put(OPEN_WORLD_MAP_ID, fileProvider.getText("/maps/map.txt").orElse(""));

        this.maps.put(HUB_MAP_ID, fileProvider.getText("/maps/hubMap.txt").orElse(""));
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

                if (tileId == TileType.tree || tileId == TileType.wall || tileId == TileType.HubMiddleTopRoof
                        || tileId == TileType.HubLeftSideTopRoof || tileId == TileType.HubRightSideTopRoof
                        || tileId == TileType.LeftSideRoof || tileId == TileType.MidleRoof
                        || tileId == TileType.RightSideRoof
                        || tileId == TileType.houseFace1
                        || tileId == TileType.houseFace2 || tileId == TileType.houseFace3
                        || tileId == TileType.houseFace4
                        || tileId == TileType.houseFace5 || tileId == TileType.middleQuestTable
                        || tileId == TileType.middleQuestTable2 || tileId == TileType.middleQuestTable3
                        || tileId == TileType.middleQuestTable4
                        || tileId == TileType.staccionata || tileId == TileType.topQuestTable1
                        || tileId == TileType.topQuestTable2
                        || tileId == TileType.topQuestTable3 || tileId == TileType.topQuestTable4
                        || tileId == TileType.houseFace6
                        || tileId == TileType.houseFace7 || tileId == TileType.houseFace8
                        || tileId == TileType.houseFace9
                        || tileId == TileType.houseFace10 || tileId == TileType.houseFace11) {
                    row.add(new Tile(resolveTyleToImageType(tileId), true, true, new Point2d(j, i), tileId));
                } else if (tileId == TileType.water) {
                    row.add(new Tile(resolveTyleToImageType(tileId), false, true, new Point2d(j, i), tileId));
                } else {
                    row.add(new Tile(resolveTyleToImageType(tileId), false, false, new Point2d(j, i), tileId));
                }
            }
            this.tiles.add(row);
        }

        var bbox = new RectBoundingBox(new Point2d(0, 0), height, width);
        if (GameEngine.RESIZATOR.getWORLD_WIDTH() > tiles.get(0).size()) {
            GameEngine.RESIZATOR.setWORLD_WIDTH(tiles.get(0).size());
        }
        if (GameEngine.RESIZATOR.getWORLD_HEIGHT() > tiles.size()) {
            GameEngine.RESIZATOR.setWORLD_HEIGHT(tiles.size());
        }
        setBBox(bbox);

        return bbox;
    }

    private ImageType resolveTyleToImageType(TileType tileType) {
        switch (tileType) {
            case earth:
                return ImageType.EARTH;
            case grass:
                return ImageType.GRASS;
            case sand:
                return ImageType.SAND;
            case tree:
                return ImageType.TREE;
            case wall:
                return ImageType.WALL;
            case water:
                return ImageType.WATER;
            case HubAllPath:
                return ImageType.HUBAllPath;
            case HubEarth:
                return ImageType.HUBEarth;
            case HubMiddleTopRoof:
                return ImageType.HubMiddleTopRoof;
            case HubLeftSideTopRoof:
                return ImageType.HubLeftSideTopRoof;
            case HubRightSideTopRoof:
                return ImageType.HubRightSideTopRoof;
            case LeftSideRoof:
                return ImageType.LeftSideRoof;
            case MidleRoof:
                return ImageType.MidleRoof;
            case RightSideRoof:
                return ImageType.RightSideRoof;
            case pathParticles:
                return ImageType.pathParticles;
            case pathPattern1:
                return ImageType.pathPattern1;
            case houseFace1:
                return ImageType.houseFace1;
            case houseFace2:
                return ImageType.houseFace2;
            case houseFace3:
                return ImageType.houseFace3;
            case houseFace4:
                return ImageType.houseFace4;
            case houseFace5:
                return ImageType.houseFace5;
            case Cespuglio:
                return ImageType.Cespuglio;
            case middleQuestTable:
                return ImageType.middleQuestTable;
            case middleQuestTable2:
                return ImageType.middleQuestTable2;
            case middleQuestTable3:
                return ImageType.middleQuestTable3;
            case middleQuestTable4:
                return ImageType.middleQuestTable4;
            case staccionata:
                return ImageType.staccionata;
            case topQuestTable1:
                return ImageType.topQuestTable1;
            case topQuestTable2:
                return ImageType.topQuestTable2;
            case topQuestTable3:
                return ImageType.topQuestTable3;
            case topQuestTable4:
                return ImageType.topQuestTable4;
            case houseFace6:
                return ImageType.houseFace6;
            case houseFace7:
                return ImageType.houseFace7;
            case houseFace8:
                return ImageType.houseFace8;
            case houseFace9:
                return ImageType.houseFace9;
            case houseFace10:
                return ImageType.houseFace10;
            case houseFace11:
                return ImageType.houseFace11;
            case cespuglio2:
                return ImageType.cespuglio2;
            case pathPattern2:
                return ImageType.pathPattern2;
            case pathPattern3:
                return ImageType.pathPattern3;
            case pathPattern4:
                return ImageType.pathPattern4;
            case pathPattern5:
                return ImageType.pathPattern5;
            case pathPattern6:
                return ImageType.pathPattern6;
            case BottomQuestTable1:
                return ImageType.BottomQuestTable1;
            case BottomQuestTable2:
                return ImageType.BottomQuestTable2;
            case BottomQuestTable3:
                return ImageType.BottomQuestTable3;
            case BottomQuestTable4:
                return ImageType.BottomQuestTable4;
            case BottomStaccionata:
                return ImageType.BottomStaccionata;
            case cespuglio3:
                return ImageType.cespuglio3;
            case topCespuglio1:
                return ImageType.topCespuglio1;
            case pathPattern7:
                return ImageType.pathPattern7;
            case pathPattern8:
                return ImageType.pathPattern8;
            case pathPattern9:
                return ImageType.pathPattern9;
            case pathPattern10:
                return ImageType.pathPattern10;
            case empty:
            default:
                return ImageType.FALLBACK;
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
            case 6:
                return TileType.HubEarth;
            case 7:
                return TileType.HubAllPath;
            case 8:
                return TileType.HubMiddleTopRoof;
            case 9:
                return TileType.HubLeftSideTopRoof;
            case 10:
                return TileType.HubRightSideTopRoof;
            case 11:
                return TileType.LeftSideRoof;
            case 12:
                return TileType.MidleRoof;
            case 13:
                return TileType.RightSideRoof;
            case 14:
                return TileType.pathParticles;
            case 15:
                return TileType.pathPattern1;
            case 16:
                return TileType.houseFace1;
            case 17:
                return TileType.houseFace2;
            case 18:
                return TileType.houseFace3;
            case 19:
                return TileType.houseFace4;
            case 20:
                return TileType.houseFace5;
            case 21:
                return TileType.Cespuglio;
            case 22:
                return TileType.middleQuestTable;
            case 23:
                return TileType.middleQuestTable2;
            case 24:
                return TileType.middleQuestTable3;
            case 25:
                return TileType.middleQuestTable4;
            case 26:
                return TileType.staccionata;
            case 27:
                return TileType.topQuestTable1;
            case 28:
                return TileType.topQuestTable2;
            case 29:
                return TileType.topQuestTable3;
            case 30:
                return TileType.topQuestTable4;
            case 31:
                return TileType.houseFace6;
            case 32:
                return TileType.houseFace7;
            case 33:
                return TileType.houseFace8;
            case 34:
                return TileType.houseFace9;
            case 35:
                return TileType.houseFace10;
            case 36:
                return TileType.houseFace11;
            case 37:
                return TileType.cespuglio2;
            case 38:
                return TileType.pathPattern2;
            case 39:
                return TileType.pathPattern3;
            case 40:
                return TileType.pathPattern4;
            case 41:
                return TileType.pathPattern5;
            case 42:
                return TileType.pathPattern6;
            case 43:
                return TileType.BottomQuestTable1;
            case 44:
                return TileType.BottomQuestTable2;
            case 45:
                return TileType.BottomQuestTable3;
            case 46:
                return TileType.BottomQuestTable4;
            case 47:
                return TileType.BottomStaccionata;
            case 48:
                return TileType.topCespuglio1;
            case 49:
                return TileType.cespuglio3;
            case 50:
                return TileType.pathPattern7;
            case 51:
                return TileType.pathPattern8;
            case 52:
                return TileType.pathPattern9;
            case 53:
                return TileType.pathPattern10;
        }

        return TileType.empty;
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

    public Optional<Tile> getTileFromPosition(Point2d point) {
        int xTopLeft = (int) point.x;
        int yTopLeft = (int) point.y;
        var tiles = getTiles();
        if (tiles.size() > yTopLeft
                && tiles.get(0).size() > xTopLeft
                && yTopLeft >= 0
                && xTopLeft >= 0) {
            return Optional.of(tiles.get(yTopLeft).get(xTopLeft));
        }
        return Optional.empty();
    }

}