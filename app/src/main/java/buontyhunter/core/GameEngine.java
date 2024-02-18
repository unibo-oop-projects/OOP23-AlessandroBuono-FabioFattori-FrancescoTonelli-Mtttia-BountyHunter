package buontyhunter.core;

import java.util.LinkedList;

import buontyhunter.common.Point2d;
import buontyhunter.common.Resizator;
import buontyhunter.common.Logger.AppLogger;
import buontyhunter.common.Logger.LogType;
import buontyhunter.graphics.*;
import buontyhunter.input.*;
import buontyhunter.model.*;
import buontyhunter.model.event.ChangeWorldEvent;
import buontyhunter.model.event.GameOverEvent;
import buontyhunter.weaponClasses.RangedWeapon;

public class GameEngine implements WorldEventListener {

    public static final Resizator RESIZATOR = new Resizator();
    public static final Point2d HUB_PLAYER_START = new Point2d(8, 8);
    public static final Point2d OPEN_WORLD_PLAYER_START = new Point2d(5, 106);

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
     * 
     * @throws InterruptedException
     */
    public void initGame() throws InterruptedException {
        gameState = new GameState(this);
        controller = new KeyboardInputController();
        view = new SwingScene(gameState, controller, false);
        this.mainLoop();
    }

    public GameState getGameState() {
        return gameState;
    }

    /**
     * start the game loop and keep it running until the game is over
     * 
     * @throws InterruptedException
     */
    private void mainLoop() throws InterruptedException {
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
                AppLogger.getLogger().log("FPS: " + drawCount, LogType.CORE);
                drawCount = 0;
            }
        }
        renderGameOver();
    }

    /**
     * Wait until the next frame should be drawn
     * 
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
        // check if the game is in the title screen
        if (gameState.isInTitleScreen()) {

            if (controller.anyKeyIsPressedSinceStart()) {
                gameState.getWorld().getLoadingBar().startLoading();
            }
        } else {
            // check if the world has a minimap (the hub doesn't have a minimap)
            if (gameState.getWorld().getMiniMap() != null) {
                // if the map is not showing, the player can move
                if (!gameState.getWorld().getMiniMap().isShow()) {
                    gameState.getWorld().getPlayer().updateInput(controller, gameState.getWorld());
                    gameState.getWorld().processAiInput(controller);
                }

                gameState.getWorld().getMiniMap().updateInput(controller, gameState.getWorld());
            } else {
                gameState.getWorld().getPlayer().updateInput(controller, gameState.getWorld());
                gameState.getWorld().processAiInput(controller);
            }

            gameState.getWorld().getFighterEntities().stream()
                    .filter(fighter -> fighter.getWeapon() instanceof RangedWeapon)
                    .forEach(fighter -> ((RangedWeapon) fighter.getWeapon()).getShot());
            gameState.getWorld().getInventory().updateInput(controller, gameState.getWorld());
            gameState.getWorld().getQuestJournal().updateInput(controller, gameState.getWorld());
            gameState.getWorld().getInterractableAreas().forEach(area -> area.updateInput(controller));
        }
    }

    /**
     * 
     * Update the game state
     * 
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
            if (ev instanceof ChangeWorldEvent) {
                if (!gameState.isGameStarted()) {
                    gameState.startGame();
                }
                gameState.setWorld(((ChangeWorldEvent) ev).getNewWorld());
                gameState.getWorld().setEventListener(this);
                controller.reset();
                if (((ChangeWorldEvent) ev).getNewWorld().getTeleporter().getMapIdOfDestination() == 0) { // hub
                    this.view.setIsHub(true);
                } else {
                    this.view.setIsHub(false);
                }
            } else if (ev instanceof GameOverEvent) {
                var winner = ((GameOverEvent) ev).getWinner();

                // TODO: Show game over screen based on the winner

            } else if (ev instanceof KilledEnemyEvent) {
                ((PlayerEntity) gameState.getWorld().getPlayer()).getQuests().stream()
                        .filter(quest -> quest.getTarget().equals(((KilledEnemyEvent) ev).getKilledType()))
                        .forEach(quest -> quest.incrementTargetActuallyKilled());
                ((PlayerEntity) gameState.getWorld().getPlayer())
                        .depositDoblons(((KilledEnemyEvent) ev).getMoneyReward());
                ((PlayerEntity) gameState.getWorld().getPlayer()).getQuests().stream()
                        .filter(quest -> quest.getnTargetActuallyKilled() >= quest.getnTargetToKill())
                        .forEach(quest -> quest.end((PlayerEntity) gameState.getWorld().getPlayer()));

            } else if (ev instanceof PlayerIsDeadEvent) {
                gameState.gameOver();
            }
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
     * call the renderGameOver method of the view which will draw the game over
     * screen
     * 
     * @throws InterruptedException
     */
    protected void renderGameOver() throws InterruptedException {
        Thread.sleep(4000);
        view.renderGameOver();
    }

    @Override
    public void notifyEvent(WorldEvent ev) {
        eventQueue.add(ev);
    }
}
