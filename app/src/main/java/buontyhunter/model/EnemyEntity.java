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
import buontyhunter.weaponClasses.Weapon;

public class EnemyEntity extends FighterEntity {

    private AIFollowPathHelper followPathHelper;

    private final List<TileType> deathTile = List.of(TileType.water);
    private final int deathDistance = 40;
    private int enemyIdentifier;

    public EnemyEntity(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, int health, int maxHealth, Weapon w, int enemyIdentifier) {
        super(type, pos, vel, box, input, graph, phys, health, maxHealth, w);

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

    private boolean isDeath(World w) {
        var manager = w.getTileManager();
        var tile = manager.getTileFromPosition(getPos());
        return !tile.isPresent() || deathTile.contains(tile.get().getType())
                || followPathHelper.getLastPathDistance() > deathDistance
                || (followPathHelper.getLastPathDistance() == 0 && getPos() != w.getPlayer().getPos());
    }

    public boolean moveItemAssertIsDeath(World world) {
        moveItem(world);
        return isDeath(world);
    }

    public int getEnemyIdentifier() {
        return enemyIdentifier;
    }
}