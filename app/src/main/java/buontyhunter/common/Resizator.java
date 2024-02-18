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

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public int getWORLD_WIDTH() {
        return WORLD_WIDTH;
    }

    public int getWORLD_HEIGHT() {
        return WORLD_HEIGHT;
    }

    public double getX_WINDOW_RATIO() {
        return x_WINDOW_RATIO;
    }

    public double getY_WINDOW_RATIO() {
        return y_WINDOW_RATIO;
    }

    public void setWORLD_WIDTH(int WORLD_WIDTH) {
        this.WORLD_WIDTH = WORLD_WIDTH;
    }

    public void setWORLD_HEIGHT(int WORLD_HEIGHT) {
        this.WORLD_HEIGHT = WORLD_HEIGHT;
    }

    public double getRATIO_WIDTH() {
        return RATIO_WIDTH;
    }

    public double getRATIO_HEIGHT() {
        return RATIO_HEIGHT;
    }

    public void needToResize(Dimension dim) {
        var newWidth = dim.getWidth();
        var newHeight = dim.getHeight();

        this.RATIO_WIDTH = newWidth / WORLD_WIDTH;
        this.RATIO_HEIGHT = newHeight / WORLD_HEIGHT;
        this.WINDOW_WIDTH = (int) newWidth;
        this.WINDOW_HEIGHT = (int) newHeight;

    }

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
