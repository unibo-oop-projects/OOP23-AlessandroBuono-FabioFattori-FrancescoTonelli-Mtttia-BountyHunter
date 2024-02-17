package buontyhunter.model;

import java.util.*;

import buontyhunter.common.Direction;
import buontyhunter.common.ExponentialProbability;
import buontyhunter.common.PercentageHelper;
import buontyhunter.common.Point2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.model.AI.AIFactoryImpl;
import buontyhunter.model.AI.AIFactory.PathFinderType;
import buontyhunter.model.AI.enemySpawner.EnemyConfiguration;
import buontyhunter.model.AI.enemySpawner.EnemyType;
import buontyhunter.model.AI.pathFinding.AIEnemyFollowPathHelper;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.WeaponFactory;

public class EnemyEntity extends FighterEntity {

    private AIEnemyFollowPathHelper followPathHelper;

    private final List<TileType> deathTile = List.of(TileType.water);
    private final int deathDistance = 40;
    private int enemyIdentifier;
    private EnemyType enemyType;
    protected FighterEntityType type = FighterEntityType.ENEMY;
    private ExponentialProbability probability;

    public EnemyEntity(GameObjectType type, Point2d pos, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, EnemyConfiguration conf, int enemyIdentifier) {
        super(type, pos, conf.getSpeed(), box, input, graph, phys, conf.getHealth(), conf.getHealth(), null);

        var aiFactory = new AIFactoryImpl();
        followPathHelper = aiFactory.CreateEnemyFollowPathHelper(PathFinderType.AStar, false);
        this.enemyIdentifier = enemyIdentifier;
        this.enemyType = conf.getType();
        this.probability = new ExponentialProbability(Math.pow(conf.getAttackCoolDown(), -1));

        switch (conf.getType()) {
            case BOW:
                this.setWeapon(WeaponFactory.getInstance().createBow(this));
                break;
            case SWORD:
                this.setWeapon(WeaponFactory.getInstance().createSword(this));
                break;
            case THROW_PUNCHES:
                this.setWeapon(WeaponFactory.getInstance().createBrassKnuckles(this));
                break;
            default:
                break;
        }
    }

    public void moveItem(World world) {
        var currentPos = this.getPos();
        var speed = this.getVel();

        var nextPos = followPathHelper.followPlayer(this, speed, world);

        if (nextPos.y < currentPos.y) {
            this.setDirection(Direction.MOVE_UP);
        } else if (nextPos.y > currentPos.y) {
            this.setDirection(Direction.MOVE_DOWN);
        } else if (nextPos.x < currentPos.x) {
            this.setDirection(Direction.MOVE_LEFT);
        } else if (nextPos.x > currentPos.x) {
            this.setDirection(Direction.MOVE_RIGHT);
        } else {
            this.setDirection(Direction.STAND_DOWN);
        }

        this.setPos(nextPos);
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

    public EnemyType getEnemyType() {
        return this.enemyType;
    }

    public boolean tryAttach(long millisecondSinceLastAttack, Point2d playerPos) {
        var match = PercentageHelper.match(probability.p(millisecondSinceLastAttack));
        if (match) {
            // attach
            setDirection(getAttackDirection(playerPos));

            this.getWeapon().directAttack();
            this.getDamagingArea().setShow(true);
        } else if (millisecondSinceLastAttack > 250) {
            this.getDamagingArea().setShow(false);
        }

        return match;
    }

    public Direction getAttackDirection(Point2d playerPos) {
        // set the direction based on where the player actually are
        var deltaX = Math.abs(playerPos.x - this.getPos().x);
        var deltaY = Math.abs(playerPos.y - this.getPos().y);

        if (deltaX > deltaY) {
            return playerPos.x > this.getPos().x ? Direction.STAND_RIGHT : Direction.STAND_LEFT;
        } else {
            return playerPos.y > this.getPos().y ? Direction.STAND_DOWN : Direction.STAND_UP;
        }
    }
}
