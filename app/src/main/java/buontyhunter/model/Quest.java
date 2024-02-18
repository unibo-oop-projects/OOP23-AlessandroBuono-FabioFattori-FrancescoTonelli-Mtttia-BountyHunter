package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public interface Quest{
    
    public void start(PlayerEntity player);
    public void end(PlayerEntity player);

    public String getName();
    public String getDescription();
    public int getDoblonsReward();
    public int getnTargetToKill();
    public EnemyType getTarget();
    public int getnTargetActuallyKilled();
    public void incrementTargetActuallyKilled();

    @Override
    public boolean equals(Object o);
}
