package buontyhunter.common;

import java.util.Objects;

public class Point2d implements java.io.Serializable, Comparable<Point2d> {

    public double x, y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * sum to this point the passed vector ; this method is used to simulate the
     * movement of the game object
     * 
     * @param v the vector to sum to this point
     * @return the new point after the sum
     */
    public Point2d sum(Vector2d v) {
        return new Point2d(x + v.x, y + v.y);
    }

    /**
     * sub to this point the passed vector ; this method is used to simulate the
     * movement of the game object
     * 
     * @param v the vector to sub to this point
     * @return the new point after the sub
     */
    public Point2d sub(Vector2d v) {
        return new Point2d(x - v.x, y - v.y);
    }

    /**
     * @return the string representation of this point
     */
    public String toString() {
        return "Point2d(" + x + "," + y + ")";
    }

    /**
     * @return a a copy of this point
     */
    public Point2d duplicate() {
        return new Point2d(x, y);
    }

    /**
     * set the x coordinate of this point to the passed value
     * 
     * @param x the new x coordinate
     * @return this point after the change
     */
    public Point2d setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * set the y coordinate of this point to the passed value
     * 
     * @param y the new y coordinate
     * @return this point after the change
     */
    public Point2d setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * generate the delta distance in x axis between this point and the passed point
     * 
     * @param p the point for calculate the delta
     * @return
     */
    public double deltaX(Point2d p) {
        return Math.abs(x - p.x);
    }

    /**
     * generate the delta distance in y axis between this point and the passed point
     * 
     * @param p the point for calculate the delta
     * @return
     */
    public double deltaY(Point2d p) {
        return Math.abs(y - p.y);
    }

    /**
     * generate the distance between this point and the passed point
     * 
     * @param p the point for calculate the distance
     * @return
     */
    public Point2d floorCoordinates() {
        x = Math.floor(x);
        y = Math.floor(y);
        return this;
    }

    /**
     * generate the distance between this point and the passed point
     * 
     * @param p the point for calculate the distance
     * @return
     */
    public Point2d ceilCoordinates() {
        x = Math.ceil(x);
        y = Math.ceil(y);
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