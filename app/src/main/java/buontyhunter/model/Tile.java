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

    /* getter area */

    public ImageType getImage() {
        return image;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public Point2d getPoint() {
        return point;
    }

    public TileType getType() {
        return type;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public boolean isTraversable() {
        return !isObstacle && !isSolid;
    }
}
