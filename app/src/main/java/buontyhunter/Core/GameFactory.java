package buontyhunter.Core;

import buontyhunter.Graphics.PlayerGraphicsComponent;
import buontyhunter.Models.GameObject;
import buontyhunter.Utils.GameObjectType;

/* this class has methods to create all gameObjects */
public abstract class GameFactory {
    public static GameObject createSquare(){
        return new GameObject(GameObjectType.Bullet,new PlayerGraphicsComponent(), 10, 10, 0, 0, 0);
    }
}
