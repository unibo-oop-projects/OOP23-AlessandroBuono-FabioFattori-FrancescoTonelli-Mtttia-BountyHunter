package buontyhunter.model.event;

import buontyhunter.core.WinnerType;
import buontyhunter.model.WorldEvent;

public class GameOverEvent implements WorldEvent {
    private final WinnerType winnerType;

    public GameOverEvent(WinnerType winnerType) {
        this.winnerType = winnerType;
    }

    public WinnerType getWinner() {
        return this.winnerType;
    }
}