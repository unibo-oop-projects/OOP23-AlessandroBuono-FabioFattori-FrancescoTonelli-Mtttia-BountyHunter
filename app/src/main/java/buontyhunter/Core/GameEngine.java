package buontyhunter.Core;

import java.util.LinkedList;

import buontyhunter.Graphics.*;
import buontyhunter.input.*;
import buontyhunter.model.*;

public class GameEngine implements WorldEventListener {

    public static double WORLD_WIDTH = 20;
    public static double WORLD_HEIGHT = 20;

    private long FPS = 30;
    private Scene view;
    private LinkedList<WorldEvent> eventQueue;
    private GameState gameState;
    private KeyboardInputController controller;

    public GameEngine() {
        eventQueue = new LinkedList<WorldEvent>();
    }

    public void initGame() {
        gameState = new GameState(this);
        controller = new KeyboardInputController();
        view = new SwingScene(gameState, controller, 600, 600, WORLD_WIDTH, WORLD_HEIGHT);
    }

    public void mainLoop() {
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

    protected void waitForNextFrame(long cycleStartTime) {
        long dt = System.currentTimeMillis() - cycleStartTime;
        if (dt < FPS) {
            try {
                Thread.sleep(FPS - dt);
            } catch (Exception ex) {
            }
        }
    }

    protected void processInput() {
        gameState.getWorld().getPlayer().updateInput(controller);
    }

    protected void updateGame(long elapsed) {
        gameState.getWorld().updateState(elapsed);
        checkEvents();
    }

    protected void checkEvents() {
        World scene = gameState.getWorld();
        eventQueue.stream().forEach(ev -> {
            // EVENT HANDLING GO HERE
        });
        eventQueue.clear();
    }

    protected void render() {
        view.render();
    }

    protected void renderGameOver() {
        view.renderGameOver();
    }

    @Override
    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }
}
