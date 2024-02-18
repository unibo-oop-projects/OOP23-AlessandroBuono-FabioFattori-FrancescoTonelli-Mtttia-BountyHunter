package buontyhunter.common;

import java.awt.Toolkit;
import java.util.List;
import java.awt.Dimension;

public class Resizator {
    private int WORLD_WIDTH = 18;
    private int WORLD_HEIGHT = 18;
    private double x_WINDOW_RATIO = 0.8;
    private double y_WINDOW_RATIO = 0.8;
    private int WINDOW_WIDTH;
    private int WINDOW_HEIGHT;
    private double RATIO_WIDTH;
    private double RATIO_HEIGHT;
    
    public Resizator() {
        this.WINDOW_WIDTH = calculateTheWindowWidthAndHeight();
        this.WINDOW_HEIGHT = WINDOW_WIDTH;
        this.RATIO_WIDTH = (double) WINDOW_WIDTH / WORLD_WIDTH;
        this.RATIO_HEIGHT = (double) WINDOW_HEIGHT / WORLD_HEIGHT;
    }

    /**
     * @return the width of the window
     */
    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    /**
     * @return the height of the window
     */
    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    /**
     * @return the width of the world drawn in the window , so the Tiles that compose a row of the world
     */
    public int getWORLD_WIDTH() {
        return WORLD_WIDTH;
    }

    /**
     * @return the height of the world drawn in the window , so the Tiles that compose a column of the world
     */
    public int getWORLD_HEIGHT() {
        return WORLD_HEIGHT;
    }

    /**
     * @return the ratio between the width of the window and the width of the worlds
     */
    public double getX_WINDOW_RATIO() {
        return x_WINDOW_RATIO;
    }

    /**
     * @return the ratio between the height of the window and the height of the world
     */
    public double getY_WINDOW_RATIO() {
        return y_WINDOW_RATIO;
    }

    /**
     * set the width of the world drawn
     * @param WORLD_WIDTH the new World width
     */
    public void setWORLD_WIDTH(int WORLD_WIDTH) {
        this.WORLD_WIDTH = WORLD_WIDTH;
    }

    /**
     * set the height of the world drawn
     * @param WORLD_HEIGHT the new World height
     */
    public void setWORLD_HEIGHT(int WORLD_HEIGHT) {
        this.WORLD_HEIGHT = WORLD_HEIGHT;
    }

    /**
     * get the ratio between the width of the window and the width of the world, this is used to scale the image
     * @return the ratio between the width of the window and the width of the world
     */
    public double getRATIO_WIDTH() {
        return RATIO_WIDTH;
    }

    /**
     * get the ratio between the height of the window and the height of the world, this is used to scale the image
     * @return the ratio between the height of the window and the height of the world
     */
    public double getRATIO_HEIGHT() {
        return RATIO_HEIGHT;
    }

    /**
     * this method is called when the window is resized, it updates the ratio between the window and the world
     * @param dim the new dimension of the window
     */
    public void needToResize(Dimension dim) {
        var newWidth = dim.getWidth();
        var newHeight = dim.getHeight();

        this.RATIO_WIDTH = newWidth / WORLD_WIDTH;
        this.RATIO_HEIGHT = newHeight / WORLD_HEIGHT;
        this.WINDOW_WIDTH = (int) newWidth;
        this.WINDOW_HEIGHT = (int) newHeight;

    }

    /**
     * this method is used to calculate the width and the height of the window based on the World width and height
     * @return the width and the height of the window
     */
    private int calculateTheWindowWidthAndHeight() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int halfScreenWidth = (int) Math.round(dim.getWidth() * x_WINDOW_RATIO);
        int halfScreenHeight = (int) Math.round(dim.getHeight() * y_WINDOW_RATIO);
        var minValue = List.of(Integer.valueOf(halfScreenHeight), Integer.valueOf(halfScreenWidth)).stream()
                .min((Integer a, Integer b) -> {
                    return a.compareTo(b);
                }).get();

        return minValue.intValue() - minValue.intValue() % WORLD_WIDTH;

    }
}
