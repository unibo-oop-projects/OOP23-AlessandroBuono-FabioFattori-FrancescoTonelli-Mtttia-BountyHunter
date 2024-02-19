package buontyhunter.model;

import buontyhunter.common.ImageType;
import buontyhunter.common.Point2d;

public class Tile {
    private final ImageType image;
    private final boolean isSolid;
    private Point2d point;
    private final boolean isObstacle;
    private final TileType type;

    public Tile(final ImageType image, final boolean isObstacle, final boolean isSolid, final Point2d point,
            TileType type) {
        this.isObstacle = isObstacle;
        this.image = image;
        this.isSolid = isSolid;
        this.point = point;
        this.type = type;
    }

    /**
     * get the image of the tile
     * @return the image of the tile
     */
    public ImageType getImage() {
        return image;
    }

    /**
     * get the solid status of the tile
     * @return true if the tile is solid and false otherwise
     */
    public boolean isSolid() {
        return isSolid;
    }

    /**
     * get the point of the tile
     * @return the point of the tile
     */
    public Point2d getPoint() {
        return point;
    }

    /**
     * get the type of the tile
     * @return the type of the tile
     */
    public TileType getType() {
        return type;
    }

    /**
     * get the obstacle status of the tile
     * @return true if the tile is an obstacle and false otherwise
     */
    public boolean isObstacle() {
        return isObstacle;
    }

    /**
     * get the traversable status of the tile , so the player can walk on it 
     * @return true if the tile is traversable and false otherwise
     */
    public boolean isTraversable() {
        return !isObstacle && !isSolid;
    }
}
