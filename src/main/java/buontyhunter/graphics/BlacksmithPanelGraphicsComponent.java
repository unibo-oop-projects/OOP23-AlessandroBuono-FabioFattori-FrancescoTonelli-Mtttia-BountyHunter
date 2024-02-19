package buontyhunter.graphics;

import buontyhunter.model.BlacksmithPanel;
import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class BlacksmithPanelGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawBlacksmithPanel((BlacksmithPanel)obj, world);
    }
    
}
