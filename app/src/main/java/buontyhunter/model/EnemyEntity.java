package buontyhunter.model;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import java.util.Collections;
import java.util.Iterator;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.model.AI.AIFactory;
import buontyhunter.model.AI.AIFactory.PathFinderType;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.physics.PhysicsComponent;

public class EnemyEntity extends FighterEntity {

    private AIFollowPathHelper followPathHelper;

    public EnemyEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth);

        followPathHelper = AIFactory.CreateFollowPathHelper(PathFinderType.AStar, false);
    }

    public void moveItem(World world) {
        var currentPos = this.getPos();
        var playerPos = world.getPlayer().getPos();
        var tiles = world.getTileManager().getTiles();
        var speed = getVel();
        this.setPos(followPathHelper.moveItem(currentPos, playerPos, speed, tiles));
    }

}
