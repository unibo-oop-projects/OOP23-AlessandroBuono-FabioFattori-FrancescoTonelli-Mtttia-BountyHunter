package buontyhunter.graphics;

import java.util.Optional;

import buontyhunter.core.GameEngine;
import buontyhunter.common.DestinationOfTeleporterType;
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

    public Camera(World world) {
        this.world = world;
    }

    /**
     * @return half of the width of the world
     */
    private double getHalfWidth() {
        return GameEngine.RESIZATOR.getWORLD_WIDTH() / 2;
    }

    /**
     * @return half of the height of the world
     */
    private double getHalfHeight() {
        return GameEngine.RESIZATOR.getWORLD_HEIGHT() / 2;
    }

    /**
     * @return the world
     */
    @Override
    public World getWorld() {
        return world;
    }

    /**
     * @param p the point to check if it is in the scene
     * @return true if the point is in the scene
     */
    @Override
    public boolean inScene(Point2d p) {
        return p.x >= firstTileX && p.x <= lastTileX && p.y >= firstTileY && p.y <= lastTileY;
    }

    /**
     * @param p the point to check if it is in the scene
     * @return an optional containing the point in the scene of the object if it is in the scene,
     */
    @Override
    public Optional<Point2d> getObjectPointInScene(Point2d obj) {
        if (inScene(obj)) {
            return Optional.of(new Point2d(obj.x - firstTileX - tileOffsetX, obj.y - firstTileY - tileOffsetY));
        }
        return Optional.empty();
    }

    /**
     * this method updates the camera ,  if the player is in the center of the world, the camera will follow the player, otherwise the camera will block in position
     * @param player the player to follow
     * @param tm the tile manager 
     */
    @Override
    public void update(GameObject player, TileManager tm) {
        double halfWidth = getHalfWidth();
        double halfHeight = getHalfHeight();

        var pos = player.getPos();
        var bbox = (RectBoundingBox) tm.getBBox();

        boolean playerXInCenter = pos.x >= halfWidth && pos.x < (bbox.getWidth() + bbox.getULCorner().x) - halfWidth;
        boolean playerYInCenter = pos.y >= halfHeight && pos.y < (bbox.getHeight() + bbox.getULCorner().y) - halfHeight;

        
        // delta larghezza del mondo senza l'ultima meta
        var tmpX = (bbox.getWidth() + bbox.getULCorner().x) - halfWidth;
        // delta altezza del mondo senza l'ultima meta
        var tmpY = (bbox.getHeight() + bbox.getULCorner().y) - halfHeight;

        double playerX = playerXInCenter ? halfWidth : (pos.x < halfHeight ? pos.x : (pos.x - tmpX) + halfWidth);
        double playerY = playerYInCenter ? halfHeight : (pos.y < halfHeight ? pos.y : (pos.y - tmpY) + halfHeight);
        playerPoint = new Point2d(playerX, playerY);

        firstTileX = playerXInCenter ? (int) Math.floor(pos.x - halfWidth)
                : (int) (pos.x < halfWidth ? 0 : Math.floor(bbox.getWidth() - 2 * halfWidth));
        firstTileY = playerYInCenter ? (int) Math.floor(pos.y - halfHeight)
                : (pos.y < halfHeight ? 0
                        : (int) Math.floor(bbox.getHeight() - GameEngine.RESIZATOR.getWORLD_HEIGHT()));
        tileOffsetX = playerXInCenter ? (pos.x - halfWidth) - Math.floor(pos.x - halfWidth) : 0;
        tileOffsetY = playerYInCenter ? (pos.y - halfHeight) - Math.floor(pos.y - halfHeight) : 0;
        if (world.getTeleporter().destination == DestinationOfTeleporterType.HUB) {
            lastTileX = tileOffsetX > 0 ? firstTileX + (int) Math.round(GameEngine.RESIZATOR.getWORLD_WIDTH()) + 1
                    : firstTileX + (int) (Math.round(GameEngine.RESIZATOR.getWORLD_WIDTH()));
            lastTileY = tileOffsetY > 0 ? firstTileY + (int) Math.round(GameEngine.RESIZATOR.getWORLD_HEIGHT()) + 1
                    : firstTileY + (int) Math.round(GameEngine.RESIZATOR.getWORLD_HEIGHT());
        } else {
            lastTileX = world.getTileManager().getTiles().size();
            lastTileY = world.getTileManager().getTiles().size();

        }
    }

    /**
     * @return the first tile x showned in the scene
     */
    @Override
    public int getTileFirstX() {
        return firstTileX;
    }

    /**
     * @return the first tile y showned in the scene
     */
    @Override
    public int getTileFirstY() {
        return firstTileY;
    }

    /**
     * @return the last tile x showned in the scene
     */
    @Override
    public int getTileLastX() {
        return lastTileX;
    }

    /**
     * @return the last tile y showned in the scene
     */
    @Override
    public int getTileLastY() {
        return lastTileY;
    }

    /**
     * @return the player point
     */
    @Override
    public Point2d getPlayerPoint() {
        return playerPoint;
    }

    /**
     * @return the tile offset x
     */
    @Override
    public double getTileOffsetX() {
        return tileOffsetX;
    }

    /**
     * @return the tile offset y
     */
    @Override
    public double getTileOffsetY() {
        return tileOffsetY;
    }

}