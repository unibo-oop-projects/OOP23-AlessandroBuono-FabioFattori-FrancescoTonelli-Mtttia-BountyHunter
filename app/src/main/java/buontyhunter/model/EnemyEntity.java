package buontyhunter.model;

import java.util.*;

import buontyhunter.common.Direction;
import buontyhunter.common.ExponentialProbability;
import buontyhunter.common.PercentageHelper;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.model.AI.AIFactoryImpl;
import buontyhunter.model.AI.AIFactory.PathFinderType;
import buontyhunter.model.AI.enemySpawner.EnemyConfiguration;
import buontyhunter.model.AI.enemySpawner.EnemyType;
import buontyhunter.model.AI.pathFinding.AIFollowPathHelper;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponFactory;

public class EnemyEntity extends FighterEntity {

    private AIFollowPathHelper followPathHelper;

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
        followPathHelper = aiFactory.CreateFollowPathHelper(PathFinderType.AStar, false);
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
        var playerPos = world.getPlayer().getPos();
        var tiles = world.getTileManager().getTiles();
        var speed = getVel();

        var nextPos = followPathHelper.moveItem(currentPos,
                getTargetPosition(world,
                        currentPos),
                speed,
                tiles);

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

    public Point2d getTargetPosition(World w, Point2d currentPos) {
        var range = getWeapon().getRange();
        var playerPos = w.getPlayer().getPos().duplicate();
        playerPos.x = (int) playerPos.x;
        playerPos.y = (int) playerPos.y;

        boolean foundTopX = false, foundTopY = false, foundBottomX = false, foundBottomY = false;
        int topX = -1, topY = -1, bottomX = -1, bottomY = -1;
        while (range >= 0 || !(foundTopX && foundTopY && foundBottomX && foundBottomY)) {
            if (!foundTopX) {
                topX = (int) (playerPos.x + range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(topX, playerPos.y));
                if (tile.isPresent() && !deathTile.contains(tile.get().getType())) {
                    foundTopX = true;
                }
            }
            if (!foundTopY) {
                topY = (int) (playerPos.y + range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(playerPos.x, topY));
                if (tile.isPresent() && !deathTile.contains(tile.get().getType())) {
                    foundTopY = true;
                }
            }
            if (!foundBottomX) {
                bottomX = (int) (playerPos.x - range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(bottomX, playerPos.y));
                if (tile.isPresent() && !deathTile.contains(tile.get().getType())) {
                    foundBottomX = true;
                }
            }
            if (!foundBottomY) {
                bottomY = (int) (playerPos.y - range);
                var tile = w.getTileManager().getTileFromPosition(new Point2d(playerPos.x, bottomY));
                if (tile.isPresent() && !deathTile.contains(tile.get().getType())) {
                    foundBottomY = true;
                }
            }

            range--;
        }

        // found the neares x and y to currentPos
        var nearestX = Math.abs(currentPos.x - topX) < Math.abs(currentPos.x - bottomX) ? topX : bottomX;
        var nearestY = Math.abs(currentPos.y - topY) < Math.abs(currentPos.y - bottomY) ? topY : bottomY;

        var deltaX = Math.abs(nearestX - currentPos.x);
        var deltaY = Math.abs(nearestY - currentPos.y);

        var x = deltaX < deltaY
                ? nearestX
                : playerPos.x;

        var y = deltaX < deltaY
                ? playerPos.y
                : nearestY;

        // // se sopra aggiungo uno sia a x che a y
        // if (playerPos.y > y && y < ((RectBoundingBox)
        // w.getTileManager().getBBox()).getHeight() - 1) {
        // y++;
        // }
        // if (playerPos.x > x && x < ((RectBoundingBox)
        // w.getTileManager().getBBox()).getWidth() - 1) {
        // x++;
        // }

        return new Point2d(x, y);
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
