package buontyhunter.core;

import buontyhunter.input.*;
import buontyhunter.model.*;
import buontyhunter.model.AI.enemySpawner.EnemyType;
import buontyhunter.physics.*;
import buontyhunter.weaponClasses.DefaultWeapon;
import buontyhunter.weaponClasses.MeleeWeapon;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.common.*;
import buontyhunter.graphics.*;
import java.util.*;

/* this class has methods to create all gameObjects */
public class GameFactory {

    private Resizator resizator;

    public GameFactory(Resizator resizator) {
        this.resizator = resizator;
    }

    static private GameFactory instance;

    static public GameFactory getInstance(Resizator resizator) {
        if (instance == null) {
            instance = new GameFactory(resizator);
        }
        return instance;
    }

    /**
     * Create a new player
     * 
     * @param point     start position for the player
     * @param vector    current player velocity
     * @param health    current health that the player will have
     * @param maxHealth maximum health that the player can have
     * @return the player entity created
     */

    // TODO weapon input
    public PlayerEntity createPlayer(Point2d point, Vector2d vector, int health, int maxHealth) {
        return new PlayerEntity(GameObjectType.Player, point, vector,
                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                new PlayerInputController(), new PlayerGraphicsComponent(), new PlayerPhysicsComponent(),
                health, maxHealth,new DefaultWeapon());
    }

    /**
     * Create a new tile manager; this object will be used to manage the tiles in
     * the game
     * 
     * @return the tile manager created
     */
    public TileManager createTileManager() {
        return new TileManager(GameObjectType.TileManager,
                new Point2d(-(GameEngine.resizator.getWORLD_WIDTH() / 2), GameEngine.resizator.getWORLD_HEIGHT() / 2), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.resizator.getWORLD_HEIGHT(), GameEngine.resizator.getWORLD_WIDTH()),
                new NullInputComponent(), new MapGraphicsComponent(), new NullPhysicsComponent());
    }

    /**
     * Create a new minimap; this object will be used to show the minimap in the
     * game when pressing the M key
     * 
     * @return the minimap created
     */
    public HidableObject createMinimap() {
        return new HidableObject(GameObjectType.MiniMap,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.resizator.getWORLD_HEIGHT(), GameEngine.resizator.getWORLD_WIDTH()),
                new MiniMapInputController(), new MiniMapGraphicsComponent(), new NullPhysicsComponent(), false);
    }

    // TODO tutte le classi qui dentro @Buono
    public HidableObject WeaponDamagingArea(FighterEntity entity, Vector2d direction) {
        return new HidableObject(GameObjectType.Weapon, entity.getPos(), direction, entity.getWeapon().getHitbox(),
                new NullInputComponent(), new WeaponGraphicsComponent(), new WeaponPhysicsComponent(), false);
    }

    /**
     * Create a new navigator line; this object will be used to show the navigator
     * line in the game when pressing the N key
     * 
     * @param world the world where the navigator line will be used
     * @return the navigator line created
     */
    public NavigatorLine createNavigatorLine(World world) {
        return new NavigatorLine(GameObjectType.NavigatorLine,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.resizator.getWORLD_HEIGHT(), GameEngine.resizator.getWORLD_WIDTH()),
                new NullInputComponent(), new NavigatorLineGraphicsComponent(), new NullPhysicsComponent(), world);
    }

    public EnemyEntity createEnemy(Point2d point, Vector2d vector, int health, int enemyIdentifier, Weapon weapon) {
        return new EnemyEntity(GameObjectType.Enemy, point, vector,
                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                new EnemyInputController(), new EnemyGraphicsComponent(), new EnemyPhysicsComponent(),
                health, health, weapon, enemyIdentifier, EnemyType.SWORD);
    }

    /**
     * Create a new health bar; this object will be used to show the health bar in
     * the game
     * 
     * @return the health bar created
     */
    public HealthBar createHealthBar() {
        return new HealthBar(GameObjectType.HealthBar,
                new Point2d((GameEngine.resizator.getWORLD_WIDTH() / 2) * (this.resizator.getWINDOW_WIDTH() / GameEngine.resizator.getWORLD_WIDTH()) - 100,
                GameEngine.resizator.getWORLD_HEIGHT() * (this.resizator.getWINDOW_HEIGHT() / GameEngine.resizator.getWORLD_WIDTH()) - 100),
                new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.resizator.getWORLD_HEIGHT(), GameEngine.resizator.getWORLD_WIDTH()),
                new NullInputComponent(), new HealthBarGraphicsComponent(), new NullPhysicsComponent());
    }

    public Teleporter createTeleporterToHub() {
        return new Teleporter(GameObjectType.Teleporter,
                Teleporter.OPEN_WORLD_TELEPORT_POS,
                new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(Teleporter.OPEN_WORLD_TELEPORT_POS.x - 0.3,
                        Teleporter.OPEN_WORLD_TELEPORT_POS.y - 0.3), 1, 1),
                new NullInputComponent(), new TeleporterGraphicComponent(), new TeleporterPhysicsComponent(),
                DestinationOfTeleporterType.HUB);
    }

    public Teleporter createTeleporterToOpenWorld() {
        return new Teleporter(GameObjectType.Teleporter,
                Teleporter.HUB_TELEPORT_POS,
                new Vector2d(0, 0),
                new RectBoundingBox(
                        new Point2d(Teleporter.HUB_TELEPORT_POS.x - 0.3, Teleporter.HUB_TELEPORT_POS.y - 0.3), 1, 1),
                new NullInputComponent(), new TeleporterGraphicComponent(), new TeleporterPhysicsComponent(),
                DestinationOfTeleporterType.OpenWorld);
    }

    public InterractableArea createQuestPannelForHub(Point2d pos) {
        QuestPannel panel = new QuestPannel(GameObjectType.HidableObject,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), this.resizator.getWINDOW_WIDTH(), this.resizator.getWINDOW_HEIGHT ()),
                new NullInputComponent(), new QuestPanelGraphicsComponent(), new NullPhysicsComponent(), false);

        return new InterractableArea(GameObjectType.InterractableArea,
                pos, new Vector2d(0, 0),
                new RectBoundingBox(pos, 3, 4),
                panel);
    }

    public List<Quest> createQuests() {
        List<Quest> quests = new ArrayList<Quest>();
        quests.add(new QuestEntity("prova1", "descrizione", 10));
        quests.add(new QuestEntity("prova2", "descrizione", 10));
        quests.add(new QuestEntity("prova3", "descrizione", 10));
        return quests;
    }

    public HidableObject createQuestJournal() {
        return new HidableObject(GameObjectType.HidableObject,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.resizator.getWORLD_HEIGHT(), GameEngine.resizator.getWORLD_WIDTH()),
                new QuestJournalInputComponent(), new QuestJournalGraphicsComponent(), new NullPhysicsComponent(),
                false);
    }
}
