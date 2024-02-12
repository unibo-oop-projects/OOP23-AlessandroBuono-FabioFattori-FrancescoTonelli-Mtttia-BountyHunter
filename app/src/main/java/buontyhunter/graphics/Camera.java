package buontyhunter.graphics;

import java.util.Optional;

import buontyhunter.core.GameEngine;
import buontyhunter.common.Point2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;

public class Camera implements SceneCamera {

    private World world;

    private Point2d playerPoint;
    private int firstTileX;
    private int firstTileY;
    private int lastTileX;
    private int lastTileY;
    private double tileOffsetX;
    private double tileOffsetY;
    private boolean isHub;

    public Camera(World world, boolean isHub) {
        this.world = world;
        this.isHub = isHub;
    }

    private double getHalfWidth() {
        return isHub ? (double)GameEngine.HUB_WIDTH / 2 : GameEngine.WORLD_WIDTH / 2;
    }

    private double getHalfHeight() {
        return isHub ? (double)GameEngine.HUB_HEIGHT / 2 : GameEngine.WORLD_HEIGHT / 2;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public boolean inScene(Point2d p) {
        return p.x >= firstTileX && p.x <= lastTileX && p.y >= firstTileY && p.y <= lastTileY;
    }

    @Override
    public Optional<Point2d> getObjectPointInScene(Point2d obj) {
        if (inScene(obj)) {
            return Optional.of(new Point2d(obj.x - firstTileX - tileOffsetX, obj.y - firstTileY - tileOffsetY));
        }
        return Optional.empty();
    }

    @Override
    public void update(GameObject player, TileManager tm) {
        double halfWidth = getHalfWidth();
        double halfHeight = getHalfHeight();

        var pos = player.getPos();
        var bbox = (RectBoundingBox) tm.getBBox();

        boolean playerXInCenter = pos.x >= halfWidth && pos.x < (bbox.getWidth() + bbox.getULCorner().x) - halfWidth;
        boolean playerYInCenter = pos.y >= halfHeight && pos.y < (bbox.getHeight() + bbox.getULCorner().y) - halfHeight;

        // TODO: rename variable
        // delta larghezza del mondo senza l'ultima meta
        var tmpX = (bbox.getWidth() + bbox.getULCorner().x) - halfWidth;
        // delta altezza del mondo senza l'ultima meta
        var tmpY = (bbox.getHeight() + bbox.getULCorner().y) - halfHeight;

        double playerX = playerXInCenter ? halfWidth : (pos.x < halfHeight ? pos.x : (pos.x - tmpX) + halfWidth);
        double playerY = playerYInCenter ? halfHeight : (pos.y < halfHeight ? pos.y : (pos.y - tmpY) + halfHeight);
        playerPoint = new Point2d(playerX, playerY);

        if (isHub) {
            firstTileX = playerXInCenter ? (int) Math.floor(pos.x - halfWidth)
                    : (int) (pos.x < halfWidth ? 0 : Math.floor(bbox.getWidth() - 2 * halfWidth));
            firstTileY = playerYInCenter ? (int) Math.floor(pos.y - halfHeight)
                    : (pos.y < halfHeight ? 0 : (int) Math.floor(bbox.getHeight() - GameEngine.HUB_HEIGHT));
            tileOffsetX = playerXInCenter ? (pos.x - halfWidth) - Math.floor(pos.x - halfWidth) : 0;
            tileOffsetY = playerYInCenter ? (pos.y - halfHeight) - Math.floor(pos.y - halfHeight) : 0;
            lastTileX = world.getTileManager().getTiles().size();
            lastTileY = world.getTileManager().getTiles().size();
        } else {
            firstTileX = playerXInCenter ? (int) Math.floor(pos.x - halfWidth)
                    : (int) (pos.x < halfWidth ? 0 : Math.floor(bbox.getWidth() - 2 * halfWidth));
            firstTileY = playerYInCenter ? (int) Math.floor(pos.y - halfHeight)
                    : (pos.y < halfHeight ? 0 : (int) Math.floor(bbox.getHeight() - GameEngine.WORLD_HEIGHT));
            tileOffsetX = playerXInCenter ? (pos.x - halfWidth) - Math.floor(pos.x - halfWidth) : 0;
            tileOffsetY = playerYInCenter ? (pos.y - halfHeight) - Math.floor(pos.y - halfHeight) : 0;
            lastTileX = tileOffsetX > 0 ? firstTileX + (int) Math.round(GameEngine.WORLD_WIDTH) + 1
                    : firstTileX + (int) (Math.round(GameEngine.WORLD_WIDTH));
            lastTileY = tileOffsetY > 0 ? firstTileY + (int) Math.round(GameEngine.WORLD_HEIGHT) + 1
                    : firstTileY + (int) Math.round(GameEngine.WORLD_HEIGHT);
        }
    }

    @Override
    public int getTileFirstX() {
        return firstTileX;
    }

    @Override
    public int getTileFirstY() {
        return firstTileY;
    }

    @Override
    public int getTileLastX() {
        return lastTileX;
    }

    @Override
    public int getTileLastY() {
        return lastTileY;
    }

    @Override
    public Point2d getPlayerPoint() {
        return playerPoint;
    }

    @Override
    public double getTileOffsetX() {
        return tileOffsetX;
    }

    @Override
    public double getTileOffsetY() {
        return tileOffsetY;
    }

    @Override
    public boolean isHub() {
        return isHub;
    }

}