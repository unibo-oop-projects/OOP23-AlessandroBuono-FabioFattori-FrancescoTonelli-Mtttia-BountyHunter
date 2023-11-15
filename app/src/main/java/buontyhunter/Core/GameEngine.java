package buontyhunter.Core;

import buontyhunter.Graphics.ScreenHandlerImpl;
import buontyhunter.InputHandlers.KeyBoardController;
import buontyhunter.Models.GameObject;
import buontyhunter.Models.GameState;

public class GameEngine {
    private ScreenHandlerImpl screenHandler;
    private GameState gameState;
    private GameConfiguration configuration;
    private KeyBoardController keyBoardController;

    public GameEngine() {
        this.keyBoardController = new KeyBoardController();
        gameState = new GameState();
        screenHandler = new ScreenHandlerImpl(this.gameState,this.keyBoardController);
        configuration = new GameConfiguration();
    }

    public void gameRun() {
        double drawInterval = (1000000000 / configuration.getFPS());
        double delta = 0;
        long lastTime = System.nanoTime();

        long timer = 0;
        int drawCount = 0;

        while (!gameState.isGameOver()) {
            long currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                inputHandler();
                update();
                draw();

                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {

                System.out.println(drawCount + " FPS");

                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void inputHandler() {
        for (GameObject obj : gameState.getGameObjects()) {
            obj.inputHadler(keyBoardController);
        }
    }

    public void update() {
        // TODO
    }

    public void draw() {
        screenHandler.draw();
    }
}
