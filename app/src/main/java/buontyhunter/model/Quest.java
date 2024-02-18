package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public interface Quest{
    
    /**
     * start the quest
     * @param player the player that started the quest
     */
    public void start(PlayerEntity player);

    /**
     * end the quest
     * @param player the player that ended the quest
     */
    public void end(PlayerEntity player);

    /**
     * get the name of the quest
     * @return the name of the quest
     */
    public String getName();
    
    /**
     * get the description of the quest
     * @return the description of the quest
     */
    public String getDescription();

    /**
     * get the doblons reward of the quest
     * @return the doblons reward of the quest
     */
    public int getDoblonsReward();

    /**
     * get n target to kill for the quest to end
     * @return the n EnemyType to kill for the quest to end
     */
    public int getnTargetToKill();

    /**
     * get the target of the quest
     * @return the target of the quest
     */
    public EnemyType getTarget();

    /**
     * get the n target actually killed of the quest
     * @return the n target actually killed of the quest
     */
    public int getnTargetActuallyKilled();

    /**
     * increment the n target actually killed of the quest
     * @return the n target actually killed of the quest
     */
    public void incrementTargetActuallyKilled();

    @Override
    public boolean equals(Object o);
}
