package buontyhunter.common;

import java.awt.Toolkit;
import java.util.List;

public class Resizator {
    public static final int WORLD_WIDTH = 20;
    public static final int WORLD_HEIGHT = 20;
    private double X_WINDOW_RATIO = 0.8;
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

    public double getRATIO_WIDTH() {
        return RATIO_WIDTH;
    }

    public double getRATIO_HEIGHT() {
        return RATIO_HEIGHT;
    }

    private double setX_WINDOW_RATIO(double x_WINDOW_RATIO) {
        return this.X_WINDOW_RATIO = x_WINDOW_RATIO;
    }

    private double setY_WINDOW_RATIO(double y_WINDOW_RATIO) {
        return this.y_WINDOW_RATIO = y_WINDOW_RATIO;
    }

    public void needToResize(double x_WINDOW_RATIO, double y_WINDOW_RATIO) {
        setX_WINDOW_RATIO(x_WINDOW_RATIO);
        setY_WINDOW_RATIO(y_WINDOW_RATIO);
        this.WINDOW_WIDTH = calculateTheWindowWidthAndHeight();
        this.WINDOW_HEIGHT = WINDOW_WIDTH;
        this.RATIO_WIDTH = (double) WINDOW_WIDTH / WORLD_WIDTH;
        this.RATIO_HEIGHT = (double) WINDOW_HEIGHT / WORLD_HEIGHT;
    }

    private int calculateTheWindowWidthAndHeight() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int halfScreenWidth = (int) Math.round(dim.getWidth() * X_WINDOW_RATIO);
        int halfScreenHeight = (int) Math.round(dim.getHeight() * y_WINDOW_RATIO);
        var minValue = List.of(Integer.valueOf(halfScreenHeight), Integer.valueOf(halfScreenWidth)).stream()
                .min((Integer a, Integer b) -> {
                    return a.compareTo(b);
                }).get();

        return minValue.intValue() - minValue.intValue() % WORLD_WIDTH;

    }
}
