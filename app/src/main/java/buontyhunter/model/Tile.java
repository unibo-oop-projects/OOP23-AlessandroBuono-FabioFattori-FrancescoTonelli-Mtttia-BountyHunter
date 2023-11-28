package buontyhunter.model;

import java.awt.image.BufferedImage;

import buontyhunter.common.Point2d;

public class Tile {
    private final BufferedImage image;
    private final boolean isSolid;
    private Point2d point;
    private int number;

    public Tile(BufferedImage image, int number, boolean isSolid, Point2d point) {
        this.image = image;
        this.number = number;
        this.isSolid = isSolid;
        this.point = point;
    }

    /* getter area */

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public Point2d getPoint() {
        return point;
    }

    public int getNumber() {
        return number;
    }
}
