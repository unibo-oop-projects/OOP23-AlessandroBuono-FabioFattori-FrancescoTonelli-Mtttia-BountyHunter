package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;

public class CircleBoundingBox implements BoundingBox {

	private Point2d center;
	private double radius;

	public CircleBoundingBox(Point2d center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public Point2d getCenter() {
		return center;
	}

	public boolean isCollidingWith(Point2d p, double radius) {
		return new Vector2d(p, center).module() <= radius + this.radius;
	}

	@Override
	public CircleBoundingBox duplicateWith(Point2d p) {
		return new CircleBoundingBox(p, radius);
	}
}
