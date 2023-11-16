package buontyhunter.Core;

import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.MapGraphicsComponent;
import buontyhunter.Graphics.PlayerGraphicsComponent;
import buontyhunter.InputHandlers.NullInputComponent;
import buontyhunter.InputHandlers.PlayerInputController;
import buontyhunter.Models.FighterEntity;
import buontyhunter.Models.TileManager;

/* this class has methods to create all gameObjects */
public class GameFactory {
    public static FighterEntity createPlayer(){
        return createPlayer(50, 50, 6, 10, 10);
    }

    public static FighterEntity createPlayer(int x, int y, int speed,int healt,int damage){
        return new FighterEntity(GameObjectType.Player,new PlayerGraphicsComponent(),new NullInputComponent(), healt, damage, x, y, speed);
    }

    public static TileManager creaTileManager(final int tileSize){
        return new TileManager(GameObjectType.TileManager, new MapGraphicsComponent(),new PlayerInputController(), 0, 0, 4, tileSize);
    }
}
