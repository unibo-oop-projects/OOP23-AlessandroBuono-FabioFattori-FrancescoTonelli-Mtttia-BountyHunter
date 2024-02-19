package buontyhunter.model;

import buontyhunter.common.Point2d;

public class RectBoundingBox implements BoundingBox {

	private Point2d point;
	private double height;
	private double width;

	public RectBoundingBox(Point2d point, double height, double width) {
		this.point = point;
		if (height < 0 || width < 0) {
			throw new IllegalArgumentException("Height and width must be positive");
		}
		this.height = height;
		this.width = width;
	}

	public RectBoundingBox(Point2d point, Point2d point2) {
		this.point = point;
		this.height = Math.abs(point2.y - point.y);
		this.width = Math.abs(point.x - point2.x);
	}

	public Point2d getULCorner() {
		return point;
	}

	public Point2d getBRCorner() {
		return new Point2d(point.x + width, point.y + height);
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public Point2d getPoint2d() {
		return new Point2d(point.x,point.y);
	}

	public RectBoundingBox withPoint(Point2d point) {
		return new RectBoundingBox(point, height, width);
	}

	@Override
	public boolean isCollidingWith(Point2d p, double radius) {
		
		throw new UnsupportedOperationException("Unimplemented method 'isCollidingWith'");
	}

	@Override
	public RectBoundingBox duplicateWith(Point2d p) {
		return new RectBoundingBox(p, height, width);
	}

	private CollisionDetector getCollisionDetector() {
		return new CollisionDetector();
	}

	public boolean intersect(RectBoundingBox rect) {
		return getCollisionDetector().isColliding(this, rect);
	}

	public boolean intersect(CircleBoundingBox circle) {
		return getCollisionDetector().isColliding(this, circle);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RectBoundingBox that = (RectBoundingBox) o;
		return Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0 && point.equals(that.point);
	}
}
