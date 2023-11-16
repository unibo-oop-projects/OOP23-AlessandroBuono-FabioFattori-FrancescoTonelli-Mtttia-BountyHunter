package buontyhunter.model;

import buontyhunter.common.Point2d;

public interface BoundingBox {

    boolean isCollidingWith(Point2d p, double radius);

    BoundingBox duplicateWith(Point2d p);
}
