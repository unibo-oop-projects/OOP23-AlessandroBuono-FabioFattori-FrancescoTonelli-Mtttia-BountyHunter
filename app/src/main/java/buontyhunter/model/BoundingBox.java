package buontyhunter.model;

import buontyhunter.common.Point2d;

public interface BoundingBox {

    /**
     * this method is used to check if the bounding box is colliding with another bounding box
     * @param p the point
     * @param radius the radius
     * @return true if the bounding box is colliding with another bounding box
     */
    boolean isCollidingWith(Point2d p, double radius);

    /**
     * this method duplicate without reference the bounding box with a new position
     * @param p the new position
     * @return the new bounding box
     */
    BoundingBox duplicateWith(Point2d p);
}
