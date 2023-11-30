package buontyhunter.common;

import java.util.Objects;

public class Point2d implements java.io.Serializable, Comparable<Point2d> {

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

    public Point2d floorCoordinates() {
        x = Math.floor(x);
        y = Math.floor(y);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point2d point2d = (Point2d) o;
        return x == point2d.x &&
                y == point2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point2d o) {
        if (x == o.x && y == o.y)
            return 0;
        if (x < o.x)
            return -1;
        if (x > o.x)
            return 1;
        if (y < o.y)
            return -1;
        if (y > o.y)
            return 1;
        return 0;
    }
}