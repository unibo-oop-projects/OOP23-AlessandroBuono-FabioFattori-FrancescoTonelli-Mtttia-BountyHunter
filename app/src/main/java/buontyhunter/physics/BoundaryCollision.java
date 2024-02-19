package buontyhunter.physics;

import buontyhunter.common.Point2d;

public class BoundaryCollision {

	public enum CollisionEdge {
		TOP, BOTTOM, LEFT, RIGHT
	}

	private CollisionEdge edge;
	private Point2d where;

	public BoundaryCollision(CollisionEdge edge, Point2d where) {
		this.edge = edge;
		this.where = where;
	}

	public CollisionEdge getEdge() {
		return edge;
	}

	public Point2d getWhere() {
		return where;
	}
}
