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

	/**
	 * this method is used to get the radius of the bounding box
	 * @return the radius of the bounding box
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * this method is used to get the center of the bounding box
	 * @return the center of the bounding box
	 */
	public Point2d getCenter() {
		return center;
	}

	@Override
	public boolean isCollidingWith(Point2d p, double radius) {
		return new Vector2d(p, center).module() <= radius + this.radius;
	}

	@Override
	public CircleBoundingBox duplicateWith(Point2d p) {
		return new CircleBoundingBox(p, radius);
	}
}
