package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public class killedEnemyEvent implements WorldEvent{
    private EnemyType killedType;
    private int moneyReward;

    public killedEnemyEvent(EnemyType killedType) {
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
