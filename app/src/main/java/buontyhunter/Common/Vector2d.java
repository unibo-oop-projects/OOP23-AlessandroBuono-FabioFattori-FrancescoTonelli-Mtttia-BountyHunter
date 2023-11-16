package buontyhunter.common;

public class Vector2d implements java.io.Serializable {

    public double x, y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Point2d to, Point2d from) {
        this.x = to.x - from.x;
        this.y = to.y - from.y;
    }

    public Vector2d sum(Vector2d v) {
        return new Vector2d(x + v.x, y + v.y);
    }

    public double module() {
        return (double) Math.sqrt(x * x + y * y);
    }

    public Vector2d getNormalized() {
        double module = (double) Math.sqrt(x * x + y * y);
        return new Vector2d(x / module, y / module);
    }

    public Vector2d mul(double fact) {
        return new Vector2d(x * fact, y * fact);
    }

    public String toString() {
        return "Vector2d(" + x + "," + y + ")";
    }
}
