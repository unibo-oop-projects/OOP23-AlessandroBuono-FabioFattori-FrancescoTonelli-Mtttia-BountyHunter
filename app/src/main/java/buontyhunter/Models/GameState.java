package buontyhunter.Models;

import java.util.ArrayList;

import buontyhunter.Core.GameFactory;

/* this class will have all the global variables of the game , like UserMoney ecc.. */
public class GameState {
    
    private boolean gameIsOver;
    private ArrayList<GameObject> gameObjects;
    private TileManager tileManager;

    public GameState(int tileSize){
        gameIsOver = false;

        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(GameFactory.createPlayer());
        tileManager = GameFactory.creaTileManager(tileSize);
        //load the first map
        tileManager.loadMap(0);
    }

    public boolean isGameOver(){
        return gameIsOver ? true : false;
    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }

    public TileManager getTileManager(){
        return tileManager;
    }

    public void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        gameObjects.remove(gameObject);
    }

    public void setGameOver(boolean gameIsOver){
        this.gameIsOver = gameIsOver;
    }
}
