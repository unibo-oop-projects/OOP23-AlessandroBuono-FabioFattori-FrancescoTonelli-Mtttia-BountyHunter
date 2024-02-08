package buontyhunter.model;

public interface Quest {
    
    public void start(PlayerEntity player);
    public void end(PlayerEntity player);

    public String getName();
    public String getDescription();
    public int getDoblonsReward();
}
