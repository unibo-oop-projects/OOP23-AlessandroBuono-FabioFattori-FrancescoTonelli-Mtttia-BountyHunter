package buontyhunter.Common;

public class Point2d implements java.io.Serializable {

    public double x, y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2d sum(Vector2d v) {
        return new Point2d(x + v.x, y + v.y);
    }

    public Vector2d sub(Point2d v) {
        return new Vector2d(x - v.x, y - v.y);
    }

    public String toString() {
        return "Point2d(" + x + "," + y + ")";
    }

    public Point2d duplicate() {
        return new Point2d(x, y);
    }

    public Point2d setX(double x) {
        this.x = x;
        return this;
    }

    public Point2d setY(double y) {
        this.y = y;
        return this;
    }
}