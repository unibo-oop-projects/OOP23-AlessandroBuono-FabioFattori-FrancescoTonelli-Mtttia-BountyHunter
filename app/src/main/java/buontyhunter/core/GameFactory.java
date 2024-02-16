package buontyhunter.core;

import buontyhunter.input.*;
import buontyhunter.model.*;
import buontyhunter.model.AI.enemySpawner.EnemyConfiguration;
import buontyhunter.model.AI.enemySpawner.EnemyType;
import buontyhunter.physics.*;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponFactory;
import buontyhunter.common.*;
import buontyhunter.graphics.*;
import java.util.*;

/* this class has methods to create all gameObjects */
public class GameFactory {

        static private GameFactory instance;

        private GameFactory() {
        }

        static public GameFactory getInstance() {
                if (instance == null) {
                        instance = new GameFactory();
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
                                new PlayerInputController(), new PlayerGraphicsComponent(),
                                new PlayerPhysicsComponent(),
                                health, maxHealth, null);
        }

        /**
         * Create a new tile manager; this object will be used to manage the tiles in
         * the game
         * 
         * @return the tile manager created
         */
        public TileManager createTileManager() {
                return new TileManager(GameObjectType.TileManager,
                                new Point2d(-(GameEngine.RESIZATOR.getWORLD_WIDTH() / 2),
                                                GameEngine.RESIZATOR.getWORLD_HEIGHT() / 2),
                                new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
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
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
                                new MiniMapInputController(), new MiniMapGraphicsComponent(),
                                new NullPhysicsComponent(), false);
        }

        // TODO tutte le classi qui dentro @Buono
        public DamagingArea WeaponDamagingArea(FighterEntity entity, Vector2d direction) {
                return new DamagingArea(GameObjectType.Weapon, entity.getPos(), direction,
                                entity.getWeapon().getHitbox(),
                                new NullInputComponent(), new WeaponGraphicsComponent(),
                                new WeaponPhysicsComponent(entity), false,
                                entity);
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
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
                                new NullInputComponent(), new NavigatorLineGraphicsComponent(),
                                new NullPhysicsComponent(), world);
        }

        public EnemyEntity createEnemy(Point2d point, EnemyConfiguration conf, int enemyIdentifier) {
                return new EnemyEntity(GameObjectType.Enemy, point,
                                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                                new EnemyInputController(), new EnemyGraphicsComponent(), new EnemyPhysicsComponent(),
                                conf, enemyIdentifier);
        }

        /**
         * Create a new health bar; this object will be used to show the health bar in
         * the game
         * 
         * @return the health bar created
         */
        public HealthBar createHealthBar() {
                return new HealthBar(GameObjectType.HealthBar,
                                new Point2d(
                                                (GameEngine.RESIZATOR.getWORLD_WIDTH() / 2)
                                                                * (GameEngine.RESIZATOR.getWINDOW_WIDTH()
                                                                                / GameEngine.RESIZATOR.getWORLD_WIDTH())
                                                                - 100,
                                                GameEngine.RESIZATOR.getWORLD_HEIGHT()
                                                                * (GameEngine.RESIZATOR.getWINDOW_HEIGHT()
                                                                                / GameEngine.RESIZATOR.getWORLD_WIDTH())
                                                                - 100),
                                new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
                                new NullInputComponent(), new HealthBarGraphicsComponent(), new NullPhysicsComponent());
        }

        public Teleporter createTeleporterToHub() {
                return new Teleporter(GameObjectType.Teleporter,
                                Teleporter.OPEN_WORLD_TELEPORT_POS,
                                new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(Teleporter.OPEN_WORLD_TELEPORT_POS.x - 0.3,
                                                Teleporter.OPEN_WORLD_TELEPORT_POS.y - 0.3), 1, 1),
                                new NullInputComponent(), new TeleporterGraphicComponent(),
                                new TeleporterPhysicsComponent(),
                                DestinationOfTeleporterType.HUB);
        }

        public Teleporter createTeleporterToOpenWorld() {
                return new Teleporter(GameObjectType.Teleporter,
                                Teleporter.HUB_TELEPORT_POS,
                                new Vector2d(0, 0),
                                new RectBoundingBox(
                                                new Point2d(Teleporter.HUB_TELEPORT_POS.x - 0.3,
                                                                Teleporter.HUB_TELEPORT_POS.y - 0.3),
                                                1, 1),
                                new NullInputComponent(), new TeleporterGraphicComponent(),
                                new TeleporterPhysicsComponent(),
                                DestinationOfTeleporterType.OpenWorld);
        }

        public InterractableArea createQuestPannelForHub(Point2d pos) {
                QuestPannel panel = new QuestPannel(GameObjectType.HidableObject,
                                new Point2d(0, 0), new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWINDOW_WIDTH(),
                                                GameEngine.RESIZATOR.getWINDOW_HEIGHT()),
                                new NullInputComponent(), new QuestPanelGraphicsComponent(), new NullPhysicsComponent(),
                                false);

                return new InterractableArea(GameObjectType.InterractableArea,
                                pos, new Vector2d(0, 0),
                                new RectBoundingBox(pos, 3, 4),
                                panel);
        }

        public InterractableArea createBlacksmithForHub(Point2d pos) {

                BlacksmithPanel panel = new BlacksmithPanel(GameObjectType.HidableObject,
                                new Point2d(0, 0), new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWINDOW_WIDTH(),
                                                GameEngine.RESIZATOR.getWINDOW_HEIGHT()),
                                new NullInputComponent(), new BlacksmithPanelGraphicsComponent(),
                                new NullPhysicsComponent(), false);

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
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
                                new QuestJournalInputComponent(), new QuestJournalGraphicsComponent(),
                                new NullPhysicsComponent(),
                                false);
        }

        public LoadingBar createLoadingBar() {
                return new LoadingBar(GameObjectType.LoadingBar,
                                new Point2d(0, 0), new Vector2d(0, 0),
                                new RectBoundingBox(new Point2d(0, 0), GameEngine.RESIZATOR.getWORLD_HEIGHT(),
                                                GameEngine.RESIZATOR.getWORLD_WIDTH()),
                                new NullInputComponent(), new LoadingBarGraphicsComponent(),
                                new NullPhysicsComponent());
        }

        public WizardBossEntity createWizardBoss(World w) {
                return new WizardBossEntity(GameObjectType.WizardBoss,
                                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                                new NullInputComponent(), new WizardBossGraphicsComponent(),
                                new WizardBossPhysicsComponent(), w);
        }

        public World createLoadingScreenWorld(WorldEventListener l) {
                var toRet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
                toRet.setLoadingBar(this.createLoadingBar());
                toRet.setEventListener(l);
                toRet.setHealthBar(null);
                return toRet;
        }

        public World createOpenWorld(World oldWorld) {
                var toRet = new World(new RectBoundingBox(new Point2d(0, 0), 20, 18));
                if (oldWorld != null && oldWorld.getPlayer() != null && oldWorld.getPlayer() instanceof PlayerEntity) {
                        oldWorld.getPlayer().setPos(GameEngine.OPEN_WORLD_PLAYER_START);
                        toRet.setPlayer(oldWorld.getPlayer());
                } else {
                        toRet.setPlayer(this.createPlayer(GameEngine.OPEN_WORLD_PLAYER_START, Vector2d.symmetrical(0),
                                        100, 100));

                }
                if (oldWorld != null) {
                        toRet.setEventListener(oldWorld.getEventListener());
                }
                toRet.setTileManager(this.createTileManager(), 0);
                toRet.setMiniMap(this.createMinimap());
                toRet.setNavigatorLine(this.createNavigatorLine(toRet));
                toRet.setTeleporter(this.createTeleporterToHub());
                toRet.setQuestJournal(this.createQuestJournal());
                toRet.setWizardBoss(this.createWizardBoss(toRet));
                return toRet;
        }

        public World createHubWorld(World oldWorld) {
                var toRet = new World(new RectBoundingBox(new Point2d(0, 0), 16, 16));
                if (oldWorld != null && oldWorld.getPlayer() != null && oldWorld.getPlayer() instanceof PlayerEntity) {
                        oldWorld.getPlayer().setPos(GameEngine.HUB_PLAYER_START);
                        toRet.setPlayer(oldWorld.getPlayer());
                } else {
                        toRet.setPlayer(this.createPlayer(GameEngine.HUB_PLAYER_START, Vector2d.symmetrical(0), 100,
                                        100));
                }

                // TODO delete this
                ((PlayerEntity) toRet.getPlayer())
                                .setWeapon(WeaponFactory.getInstance().createBow((FighterEntity) toRet.getPlayer()));

                if (oldWorld != null) {
                        toRet.setEventListener(oldWorld.getEventListener());
                }

                toRet.setTileManager(this.createTileManager(), 1);
                toRet.setNavigatorLine(this.createNavigatorLine(toRet));
                toRet.setTeleporter(this.createTeleporterToOpenWorld());
                toRet.addInterractableArea(this.createQuestPannelForHub(new Point2d(7, 5)));
                toRet.addInterractableArea(this.createBlacksmithForHub(new Point2d(1, 4)));
                toRet.setQuestJournal(this.createQuestJournal());
                toRet.disableEnemies();
                return toRet;
        }
}
