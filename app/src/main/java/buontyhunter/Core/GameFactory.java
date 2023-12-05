package buontyhunter.core;

import buontyhunter.input.MiniMapInputController;
import buontyhunter.input.NullInputComponent;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.GameObjectType;
import buontyhunter.model.HidableObject;
import buontyhunter.model.NavigatorLine;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.TileManager;
import buontyhunter.model.World;
import buontyhunter.physics.NullPhysicsComponent;
import buontyhunter.physics.PlayerPhysicsComponent;
import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.MapGraphicsComponent;
import buontyhunter.graphics.MiniMapGraphicsComponent;
import buontyhunter.graphics.NavigatorLineGraphicsComponent;
import buontyhunter.graphics.PlayerGraphicsComponent;
import buontyhunter.input.PlayerInputController;

/* this class has methods to create all gameObjects */
public class GameFactory {

    static private GameFactory instance;

    static public GameFactory getInstance() {
        if (instance == null) {
            instance = new GameFactory();
        }
        return instance;
    }

    public FighterEntity createPlayer(Point2d point, Vector2d vector, int health, int maxHealth) {
        return new FighterEntity(GameObjectType.Player, point, vector,
                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                new PlayerInputController(), new PlayerGraphicsComponent(), new PlayerPhysicsComponent(),
                health, maxHealth);
    }

    public TileManager createTileManager() {
        return new TileManager(GameObjectType.TileManager,
                new Point2d(-(GameEngine.WORLD_WIDTH / 2), GameEngine.WORLD_HEIGHT / 2), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.WORLD_HEIGHT, GameEngine.WORLD_WIDTH),
                new NullInputComponent(), new MapGraphicsComponent(), new NullPhysicsComponent());
    }

    public HidableObject createMinimap() {
        return new HidableObject(GameObjectType.MiniMap,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.WORLD_HEIGHT, GameEngine.WORLD_WIDTH),
                new MiniMapInputController(), new MiniMapGraphicsComponent(), new NullPhysicsComponent(), false);
    }

    public NavigatorLine createNavigatorLine(World world) {
        return new NavigatorLine(GameObjectType.NavigatorLine,
                new Point2d(0, 0), new Vector2d(0, 0),
                new RectBoundingBox(new Point2d(0, 0), GameEngine.WORLD_HEIGHT, GameEngine.WORLD_WIDTH),
                new NullInputComponent(), new NavigatorLineGraphicsComponent(), new NullPhysicsComponent(), world);
    }

    public FighterEntity createEnemy(Point2d point, Vector2d vector, int health, int maxHealth) {
        return new FighterEntity(GameObjectType.Enemy, point, vector,
                new RectBoundingBox(new Point2d(0, 0), 1, 1),
                new NullInputComponent(), new PlayerGraphicsComponent(), new NullPhysicsComponent(),
                health, maxHealth);
    }
}
