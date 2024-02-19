package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public class KilledEnemyEvent implements WorldEvent{
    private EnemyType killedType;
    private int moneyReward;

    /**
     * create a new KilledEnemyEvent , it is generated when an enemy is killed
     * @param killedType the type of the killed enemy
     */
    public KilledEnemyEvent(EnemyType killedType) {
        this.killedType = killedType;
        this.moneyReward = Math.random() > 0.6 ? 1 : 3;
    }

    /**
     * get the type of the killed enemy
     * @return the type of the killed enemy
     */
    public EnemyType getKilledType() {
        return killedType;
    }

    /**
     * get the money reward for killing the enemy
     * @return the money reward for killing the enemy
     */
    public int getMoneyReward() {
        return moneyReward;
    }

}
