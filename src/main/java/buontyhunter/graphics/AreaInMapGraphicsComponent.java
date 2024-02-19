package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class AreaInMapGraphicsComponent implements GraphicsComponent{

    private final String messageToShow;

    public AreaInMapGraphicsComponent(final String messageToShow) {
        this.messageToShow = messageToShow;
    }

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawStringUnderPlayer(messageToShow);
    }
    
}
