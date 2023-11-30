package buontyhunter.core;

import java.util.LinkedList;

import buontyhunter.graphics.*;
import buontyhunter.input.*;
import buontyhunter.model.*;
import java.awt.Toolkit;


public class GameEngine implements WorldEventListener {

    public static final int WORLD_WIDTH = 20;
    public static final int WORLD_HEIGHT = 20;
    public static final int WINDOW_WIDTH = ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2;
    public static final int WINDOW_HEIGHT = 700;
    public static final int RATIO_WIDTH = (int) Math.floor(WINDOW_WIDTH / WORLD_WIDTH);
    public static final int RATIO_HEIGHT = (int) Math.floor(WINDOW_HEIGHT / WORLD_HEIGHT);

    private long FPS = 30;
    private Scene view;
    private LinkedList<WorldEvent> eventQueue;
    private GameState gameState;
    private KeyboardInputController controller;

    
    public GameEngine() {
        eventQueue = new LinkedList<WorldEvent>();
    }

    /**
     * Initialize the game by starting the game loop
     */
    public void initGame() {
        gameState = new GameState(this);
        controller = new KeyboardInputController();
        view = new SwingScene(gameState, controller, WINDOW_WIDTH, WINDOW_HEIGHT, WORLD_WIDTH, WORLD_HEIGHT);
        this.mainLoop();
    }

    /**
     * start the game loop and keep it running until the game is over
     */
    private void mainLoop() {
        long previousCycleStartTime = System.currentTimeMillis();
        var drawCount = 0;
        long lastFPSPrint = 0;
        while (!gameState.isGameOver()) {
            long currentCycleStartTime = System.currentTimeMillis();
            long elapsed = currentCycleStartTime - previousCycleStartTime;
            processInput();
            updateGame(elapsed);
            render();
            drawCount++;
            waitForNextFrame(currentCycleStartTime);
            previousCycleStartTime = currentCycleStartTime;
            if (System.currentTimeMillis() - lastFPSPrint > 1000) {
                lastFPSPrint = System.currentTimeMillis();
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
            }
        }
        renderGameOver();
    }

    /**
     * Wait until the next frame should be drawn
     * @param cycleStartTime time when the current cycle started
     */
    protected void waitForNextFrame(long cycleStartTime) {
        long dt = System.currentTimeMillis() - cycleStartTime;
        if (dt < FPS) {
            try {
                Thread.sleep(FPS - dt);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Process the input foreach game object that needs it
     */
    protected void processInput() {
        gameState.getWorld().getPlayer().updateInput(controller);
        gameState.getWorld().getMiniMap().updateInput(controller);
    }

    /**
     * Update the game state
     * @param elapsed time elapsed since last update
     */
    protected void updateGame(long elapsed) {
        gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    /**
     * Check the event queue and handle the events
     */
    protected void checkEvents() {
        World scene = gameState.getWorld();
        eventQueue.stream().forEach(ev -> {
            // EVENT HANDLING GO HERE
        });
        eventQueue.clear();
    }

    /**
     * call the render method of the view which will draw each game object
     */
    protected void render() {
        view.render();
    }

    /**
     * call the renderGameOver method of the view which will draw the game over screen
     */
    protected void renderGameOver() {
        view.renderGameOver();
    }

    @Override
    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }
}
