package buontyhunter.model;

import buontyhunter.Common.Point2d;

public interface BoundingBox {

    boolean isCollidingWith(Point2d p, double radius);

    BoundingBox duplicateWith(Point2d p);
}
