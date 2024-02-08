package buontyhunter.model;

public class QuestEntity implements Quest{
    private final String name;
    private final String description;
    private final int doblonsReward;
    //TODO: add a optional reward item to the quest (weapon)
    //TODO: a quest has a boss that the player has to defeat => each boss on defeat generate an event 

    public QuestEntity(String name, String description, int doblonsReward) {
        this.name = name;
        this.description = description;
        this.doblonsReward = doblonsReward;
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
    }
}
