package buontyhunter.model;

import buontyhunter.model.AI.enemySpawner.EnemyType;

public class QuestEntity implements Quest{
    private final String name;
    private final String description;
    private final int doblonsReward;
    private final EnemyType target;
    private final int nTargetToKill;
    private int nTargetActuallyKilled;

    public QuestEntity(String name, String description, int doblonsReward , EnemyType target, int nTargetToKill) {
        this.name = name;
        this.description = description;
        this.doblonsReward = doblonsReward;
        this.target = target;
        this.nTargetToKill = nTargetToKill;
        this.nTargetActuallyKilled = 0;
    }

    @Override
    public String getName() {
        return new String(name);
    }

    @Override
    public String getDescription() {
        return new String(description);
    }

    @Override
    public int getDoblonsReward() {
        return doblonsReward;
    }

    @Override
    public void start(PlayerEntity player) {
        player.addQuest(this);
    }

    @Override
    public void end(PlayerEntity player) {
        player.removeQuest(this);
        player.depositDoblons(doblonsReward);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        QuestEntity that = (QuestEntity) o;

        if (doblonsReward != that.doblonsReward) return false;
        if (!name.equals(that.name)) return false;
        return description.equals(that.description);
    }

    

    @Override
    public int getnTargetToKill() {
        return nTargetToKill;
    }

    @Override
    public EnemyType getTarget() {
        return target;
    }

    @Override
    public int getnTargetActuallyKilled() {
        return nTargetActuallyKilled;
    }

    @Override
    public void incrementTargetActuallyKilled() {
        nTargetActuallyKilled++;
    }
}
