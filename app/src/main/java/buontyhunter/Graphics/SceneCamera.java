package buontyhunter.Graphics;

import java.util.Optional;

import buontyhunter.Common.Point2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;

public interface SceneCamera {
    public World getWorld();

    public boolean inScene(Point2d p);

    public Optional<Point2d> getObjectPointInScene(Point2d obj);

    public void update(GameObject player, TileManager tm);

    public int getTileFirstX();

    public int getTileFirstY();

    public int getTileLastX();

    public int getTileLastY();

    public double getTileOffsetX();

    public double getTileOffsetY();

    public Point2d getPlayerPoint();
}
