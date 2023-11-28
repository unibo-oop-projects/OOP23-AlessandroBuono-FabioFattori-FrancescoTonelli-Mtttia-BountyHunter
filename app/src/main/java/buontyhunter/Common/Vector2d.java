package buontyhunter.Common;

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

    public static Vector2d symmetrical(double val) {
        return new Vector2d(val, val);
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

    public void negativeY() {
        if (y < 0)
            return;
        y = -y;
    }

    public void negativeX() {
        if (x < 0)
            return;
        x = -x;
    }

    public void positiveY() {
        if (y > 0)
            return;
        y = -y;
    }

    public void positiveX() {
        if (x > 0)
            return;
        x = -x;
    }

    public void setX0() {
        x = 0;
    }

    public void setY0() {
        y = 0;
    }

    public Vector2d duplicate() {
        return new Vector2d(x, y);
    }

    public String toString() {
        return "Vector2d(" + x + "," + y + ")";
    }
}
