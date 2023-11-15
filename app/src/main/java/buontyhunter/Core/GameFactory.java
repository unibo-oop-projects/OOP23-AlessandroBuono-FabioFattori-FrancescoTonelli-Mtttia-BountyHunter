package buontyhunter.Core;

import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.PlayerGraphicsComponent;
import buontyhunter.InputHandlers.PlayerInputController;
import buontyhunter.Models.GameObject;

/* this class has methods to create all gameObjects */
public class GameFactory {
    public static GameObject createPlayer(){
        return createPlayer(50, 50, 6, 10, 10);
    }

    public static GameObject createPlayer(int x, int y, int speed,int healt,int damage){
        return new GameObject(GameObjectType.Player,new PlayerGraphicsComponent(),new PlayerInputController(), healt, damage, x, y, speed);
    }
}
