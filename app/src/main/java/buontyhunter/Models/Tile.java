package buontyhunter.Models;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage image;
    private final boolean isSolid;
    private final int x;
    private final int y;

    public Tile(BufferedImage image, boolean isSolid, int x, int y) {
        this.image = image;
        this.isSolid = isSolid;
        this.x = x;
        this.y = y;
    }

    /* getter area */

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
