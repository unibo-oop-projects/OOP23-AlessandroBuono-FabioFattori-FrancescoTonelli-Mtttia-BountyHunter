package buontyhunter.model;

import java.util.List;

import java.util.Optional;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.input.KeyboardInputController;
import buontyhunter.model.AI.enemySpawner.EnemyRegistry;
import buontyhunter.model.AI.enemySpawner.EnemyRegistryImpl;
import buontyhunter.physics.BoundaryCollision;

import java.util.ArrayList;

public class World {
    private GameObject player;
    private TileManager tileManager;
    private RectBoundingBox mainBBox;
    private WorldEventListener evListener;
    private HidableObject miniMap;
    private NavigatorLine navigatorLine;
    private HealthBar healthBar;
    private Teleporter tp;
    private HidableObject questJournal;
    private List<InterractableArea> interractableAreas;
    private EnemyRegistry enemyRegistry;

    public World(RectBoundingBox bbox) {
        mainBBox = bbox;
        this.healthBar = GameFactory.getInstance(GameEngine.resizator).createHealthBar();
        this.interractableAreas = new ArrayList<InterractableArea>();
        enemyRegistry = new EnemyRegistryImpl();
    }

    public void setEventListener(WorldEventListener l) {
        evListener = l;
    }

    public void setTileManager(TileManager tileManager, int settedMap) {
        this.tileManager = tileManager;
        laodMap(settedMap);
    }

    public void setTeleporter(Teleporter tp) {
        this.tp = tp;
    }

    public void setPlayer(GameObject player) {
        this.player = player;
    }

    public void setMiniMap(HidableObject miniMap) {
        this.miniMap = miniMap;
    }

    public void setNavigatorLine(NavigatorLine navigatorLine) {
        this.navigatorLine = navigatorLine;
    }

    public void addInterractableArea(InterractableArea area) {
        interractableAreas.add(area);
    }

    public List<InterractableArea> getInterractableAreas() {
        return interractableAreas;
    }

    public List<EnemyEntity> getEnemies() {
        return enemyRegistry.getEnemies();
    }

    public void updateState(long dt) {
        if (player != null) {
            player.updatePhysics(dt, this);
        }
        if (tileManager != null) {
            tileManager.updatePhysics(dt, this);
        }
        if (miniMap != null) {
            miniMap.updatePhysics(dt, this);
        }
        if (tp != null) {
            tp.updatePhysics(dt, this);
        }

        this.interractableAreas.forEach(area -> area.updatePhysics(dt, this));
        for (var enemy : getEnemies()) {
            enemy.updatePhysics(dt, this);
        }
    }

    public void processAiInput(KeyboardInputController controller) {
        for (var enemy : getEnemies()) {
            enemy.updateInput(controller, this);
        }
        generateEnemy();
    }

    public void notifyWorldEvent(WorldEvent ev) {
        evListener.notifyEvent(ev);
    }

    public RectBoundingBox getBBox() {
        return mainBBox;
    }

    public GameObject getPlayer() {
        return player;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public HidableObject getMiniMap() {
        return miniMap;
    }

    public HidableObject getQuestJournal() {
        return questJournal;
    }

    public void setQuestJournal(HidableObject questJournal) {
        this.questJournal = questJournal;
    }

    public NavigatorLine getNavigatorLine() {
        return navigatorLine;
    }

    public Teleporter getTeleporter() {
        return tp;
    }

    public List<GameObject> getSceneEntities() {
        List<GameObject> entities = new ArrayList<GameObject>();
        if (tileManager != null)
            entities.add(tileManager);
        if (player != null)
            entities.add(player);
        if (navigatorLine != null)
            entities.add(navigatorLine);
        if (healthBar != null)
            entities.add(healthBar);
        if (tp != null)
            entities.add(tp);
            for (var enemy : getEnemies()) {
                entities.add(enemy);
            }
        if (miniMap != null)
            entities.add(miniMap);
        if (questJournal != null)
            entities.add(questJournal);
        

        this.interractableAreas.forEach(area -> entities.add(area));
        return entities;
    }

    public void laodMap(int map) {
        if (tileManager == null)
            return;
        var box = tileManager.loadMap(map);
        mainBBox = box;
    }

    public Optional<BoundaryCollision> checkCollisionWithBoundaries(Point2d pos, RectBoundingBox box) {
        Point2d ul = mainBBox.getULCorner();
        Point2d br = mainBBox.getBRCorner();
        RectBoundingBox rect = new RectBoundingBox(pos, box.getWidth(), box.getHeight());
        if (rect.getULCorner().y < ul.y) {
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.TOP, new Point2d(pos.x, ul.y)));
        } else if (rect.getBRCorner().y > br.y) {
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.BOTTOM,
                    new Point2d(pos.x, br.y - rect.getHeight())));
        } else if (rect.getBRCorner().x > br.x) {
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.RIGHT,
                    new Point2d(br.x - rect.getWidth(), pos.y)));
        } else if (rect.getULCorner().x < ul.x) {
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.LEFT, new Point2d(ul.x, pos.y)));
        } else {
            return Optional.empty();
        }
    }

    public void addEnemy(Point2d pos, Vector2d speed, int health) {
        enemyRegistry.addEnemy(pos, speed, health);
    }

    public void removeEnemy(int enemyIdentifier) {
        enemyRegistry.removeEnemy(enemyIdentifier);
    }

    public void generateEnemy() {
        enemyRegistry.generateEnemy(this);
    }

    public void disableEnemies() {
        enemyRegistry.disableEnemies();
    }

    public void enableEnemies() {
        enemyRegistry.enableEnemies();
    }
}
