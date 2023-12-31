package buontyhunter.model;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.model.AI.AIFactoryImpl;
import buontyhunter.model.AI.AIFactory.PathFinderType;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.physics.PhysicsComponent;

public class EnemyEntity extends FighterEntity {

    private AIFollowPathHelper followPathHelper;

    private final List<TileType> deathTile = List.of(TileType.water);
    private int enemyIdentifier;

    public EnemyEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth, int enemyIdentifier) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth);

        var aiFactory = new AIFactoryImpl();
        followPathHelper = aiFactory.CreateFollowPathHelper(PathFinderType.AStar, false);
        this.enemyIdentifier = enemyIdentifier;
    }

    public void moveItem(World world) {
        var currentPos = this.getPos();
        var playerPos = world.getPlayer().getPos();
        var tiles = world.getTileManager().getTiles();
        var speed = getVel();
        this.setPos(followPathHelper.moveItem(currentPos, playerPos, speed, tiles));
    }

    private boolean isDeath(TileManager manager) {
        var tile = manager.getTileFromPosition(getPos());
        return !tile.isPresent() || deathTile.contains(tile.get().getType());
    }

    public boolean moveItemAssertIsDeath(World world) {
        moveItem(world);
        return isDeath(world.getTileManager());
    }

    public int getEnemyIdentifier() {
        return enemyIdentifier;
    }
}
