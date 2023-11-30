package buontyhunter.common;

public class Point2d implements java.io.Serializable {

    public double x, y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * sum to this point the passed vector ; this method is used to simulate the movement of the game object
     * @param v the vector to sum to this point
     * @return the new point after the sum
     */
    public Point2d sum(Vector2d v) {
        return new Point2d(x + v.x, y + v.y);
    }

    /**
     * sub to this point the passed vector ; this method is used to simulate the movement of the game object
     * @param v the vector to sub to this point
     * @return the new point after the sub
     */
    public Vector2d sub(Point2d v) {
        return new Vector2d(x - v.x, y - v.y);
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
     * @param x the new x coordinate
     * @return this point after the change
     */
    public Point2d setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * set the y coordinate of this point to the passed value
     * @param y the new y coordinate
     * @return this point after the change
     */
    public Point2d setY(double y) {
        this.y = y;
        return this;
    }
}