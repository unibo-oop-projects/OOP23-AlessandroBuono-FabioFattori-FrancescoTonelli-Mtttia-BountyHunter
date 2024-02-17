package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public class KilledEnemyEvent implements WorldEvent{
    private EnemyType killedType;
    private int moneyReward;

    public KilledEnemyEvent(EnemyType killedType) {
        this.killedType = killedType;
        this.moneyReward = Math.random() > 0.6 ? 1 : 3;
    }

    public EnemyType getKilledType() {
        return killedType;
    }

    public int getMoneyReward() {
        return moneyReward;
    }

}
