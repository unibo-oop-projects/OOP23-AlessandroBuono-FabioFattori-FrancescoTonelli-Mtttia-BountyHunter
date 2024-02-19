package buontyhunter.model;

public class PlayerIsDeadEvent implements WorldEvent{
    
    public PlayerIsDeadEvent(World w) {
        ((PlayerEntity)w.getPlayer()).deadBehaviour();
    }
}
