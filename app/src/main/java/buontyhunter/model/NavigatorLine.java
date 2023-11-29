package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;

import java.util.*;
import buontyhunter.model.pathFinding.AStarPathFinding;
import buontyhunter.model.pathFinding.PathFinder;

public class NavigatorLine extends GameObject {

    private List<Point2d> path;
    private final World world;
    private PathFinder pathFinder;

    public NavigatorLine(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, World world) {
        super(type, pos, vel, box, input, graph, phys);
        this.world = world;
        path = new ArrayList<>();
        pathFinder = new AStarPathFinding();
    }

    public void setPath(Point2d initialPoint, Point2d finalPoint) {
        path = pathFinder.findPath(initialPoint, finalPoint, world.getTileManager().getTiles());
    }

    public List<Point2d> getPath() {
        return path;
    }

}