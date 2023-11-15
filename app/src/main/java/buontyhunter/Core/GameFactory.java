package buontyhunter.Core;

import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.PlayerGraphicsComponent;
import buontyhunter.InputHandlers.PlayerInputController;
import buontyhunter.Models.GameObject;

/* this class has methods to create all gameObjects */
public class GameFactory {
    public static GameObject createSquare(){
        return new GameObject(GameObjectType.Bullet,new PlayerGraphicsComponent(),new PlayerInputController(), 10, 10, 50, 50, 6);
    }
}
