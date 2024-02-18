package buontyhunter.model;

import buontyhunter.common.Direction;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.common.Logger.AppLogger;
import buontyhunter.common.Logger.LogType;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponFactory;
import buontyhunter.model.AI.AIFactoryImpl;
import buontyhunter.model.AI.AttackHelper;
import buontyhunter.model.AI.enemySpawner.EnemySpawner;
import buontyhunter.model.AI.enemySpawner.EnemySpawnerFixed;
import buontyhunter.model.AI.enemySpawner.EnemyType;
import buontyhunter.model.AI.pathFinding.AIEnemyFollowPathHelper;

import java.util.*;
import java.util.stream.Collectors;

public class WizardBossEntity extends FighterEntity {

    private static final int health = 100;
    private static final int maxHealth = 100;
    private static final Vector2d vel = new Vector2d(0.5, 0.5);
    private final AIEnemyFollowPathHelper followPathHelper;
    private Point2d currentTarget;
    private boolean gpsActive = true;
    private EnemySpawner enemySpawner;
    private final long spawnCoolDown = 50000;
    private final long attachCoolDown = 9000;
    private final AttackHelper attachHelper = new AttackHelper(attachCoolDown);
    private final AttackHelper spawnHelper = new AttackHelper(spawnCoolDown);
    protected FighterEntityType type = FighterEntityType.ENEMY;
    private boolean die = false;

    /**
     * is true if the boss can attack the player (JUST FOR DEBUG PURPOSES)
     */
    private final boolean attackPlayer = true;
    public static final EnemyType enemyType = EnemyType.WIZARD;

    /**
     * is how much the boss have to be near the player for attack him
     */
    private final int deltaPlayerNear = 10;

    public WizardBossEntity(GameObjectType type, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, World w) {
        super(type, new Point2d(0, 0), vel, box, input, graph, phys, health, maxHealth, null);

        // is important to set in this order beacuse set the target point need the
        // position of the boss to be setted correctly for an accurate calculation
        setPos(generateAvailablePoint(w, -1));
        generateTargetPoint(w);
        setWeapon(generateWeapon());

        enemySpawner = new EnemySpawnerFixed(3);

        var aiFactory = new AIFactoryImpl();
        followPathHelper = aiFactory.CreateEnemyFollowPathHelper(AIFactoryImpl.PathFinderType.AStar, false);
    }

    public boolean isGpsActive() {
        return gpsActive;
    }

    public void setGpsActive(boolean gpsActive) {
        this.gpsActive = gpsActive;
    }

    public void setCurrentTarget(Point2d currentTarget) {
        this.currentTarget = currentTarget;
    }

    /**
     * generate a random available point in the map
     * 
     * @param w
     * @param maxDistance -1 if none
     * @return
     */
    private Point2d generateAvailablePoint(World w, int maxDistance) {
        // get a list of tile, getTiles is list<list<tile>> I want list<tile>
        List<Point2d> path;
        Point2d startPoint;
        do {
            var availablePoints = flattenList(w.getTileManager().getTiles()).stream()
                    .filter(tile -> tile.isTraversable())
                    .filter(tile -> maxDistance < 0 || (tile.getPoint().deltaX(getPos()) < maxDistance)
                            && (tile.getPoint().deltaY(getPos()) < maxDistance))
                    .collect(Collectors.toList());
            var random = new Random();
            startPoint = availablePoints.get(random.nextInt(availablePoints.size())).getPoint();
            var pathFinder = new AIFactoryImpl().CreatePathFinder(AIFactoryImpl.PathFinderType.AStar, false);
            path = pathFinder.findPath(startPoint, w.getPlayer().getPos(), w.getTileManager().getTiles(),
                    new HashSet<>());
        } while (path.isEmpty());

        return startPoint;
    }

    private Weapon generateWeapon() {
        return WeaponFactory.getInstance().createBossBow(this);
    }

    private List<Tile> flattenList(List<List<Tile>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * Update the wizard boss entity
     * 
     * @param w the world object
     */
    public void update(World w, long elapsed) {
        var currentPos = getPos();
        var speed = getVel();

        Point2d nextPos;

        if (die || checkDie(w)) {
            return;
        }

        /// if boss is near player, then attack him
        /// else follow a random path, if he arrive to the random target, generate a new
        /// random target
        if (checkNearPlayer(w)) {
            nextPos = followPathHelper.followPlayer(this, speed, w);
            tryGenerateEnemy(w, elapsed);
            tryAttackPlayer(w, elapsed);
            w.setEnemySpawnActive(false);
        } else {
            w.setEnemySpawnActive(true);
            nextPos = followPathHelper.moveItem(getPos(), currentTarget, speed, w.getTileManager().getTiles());
            if (nextPos.equals(currentPos)) {
                generateTargetPoint(w);
            }
        }

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

        setPos(nextPos);
        setBBox(((RectBoundingBox) getBBox()).withPoint(nextPos));
    }

    private boolean checkNearPlayer(World world) {
        var playerPos = world.getPlayer().getPos();
        var currentPos = getPos();
        return Math.abs(playerPos.x - currentPos.x) < deltaPlayerNear
                && Math.abs(playerPos.y - currentPos.y) < deltaPlayerNear;
    }

    private void generateTargetPoint(World w) {
        if (attackPlayer) {
            setCurrentTarget(w.getPlayer().getPos());
        } else {
            setCurrentTarget(generateAvailablePoint(w, 40));
        }
    }

    private void tryGenerateEnemy(World w, long elapsed) {
        if (spawnHelper.canAttack(elapsed)) {
            enemySpawner.spawn(w);
        }
    }

    private void tryAttackPlayer(World w, long elapsed) {
        if (attachHelper.canAttack(elapsed)) {
            var playerPos = w.getPlayer().getPos();
            setDirection(attachHelper.getAttackDirection(getPos(), playerPos));
            getWeapon().directAttack();
            getDamagingArea().setShow(true);
        } else if (attachHelper.getMillisecondSinceLastAttach() > 250) {
            getDamagingArea().setShow(false);
        }
    }

    private boolean checkDie(World w) {
        die = getHealth() <= 0;
        if (die) {
            w.handleBossKilled();
            w.notifyWorldEvent(new KilledEnemyEvent(EnemyType.WIZARD));
        }
        return die;
    }

}
