package buontyhunter.Core;

import buontyhunter.Graphics.ScreenHandler;

public class GameEngine {
    private ScreenHandler screenHandler;
    private GameState gameState;
    private GameConfiguration configuration;

    public GameEngine(){
        gameState = new GameState();
        screenHandler = new ScreenHandler(this.gameState);
        configuration = new GameConfiguration();
    }

    /* start the game cycle */
    public void gameRun(){
        double drawInterval = (1000000000 / configuration.getFPS());
        double delta = 0;
        long lastTime = System.nanoTime();

        long timer = 0;
        int drawCount = 0;

        while (gameState.isGameOver()) {
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

    public void inputHandler(){
        //TODO
    }

    public void update(){
        //TODO
    }

    public void draw(){
        screenHandler.draw();
    }
}
