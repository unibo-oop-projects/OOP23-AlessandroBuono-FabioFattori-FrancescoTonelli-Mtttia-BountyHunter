package buontyhunter.model.event;

import buontyhunter.core.WinnerType;
import buontyhunter.model.WorldEvent;

/**
 * The game over event
 */
public class GameOverEvent implements WorldEvent {
    private final WinnerType winnerType;

    /**
     * Create a new GameOverEvent
     * 
     * @param winnerType the winner of the game
     */
    public GameOverEvent(WinnerType winnerType) {
        this.winnerType = winnerType;
    }

    /**
     * Get the winner of the game
     * 
     * @return the winner of the game
     */
    public WinnerType getWinner() {
        return this.winnerType;
    }
}