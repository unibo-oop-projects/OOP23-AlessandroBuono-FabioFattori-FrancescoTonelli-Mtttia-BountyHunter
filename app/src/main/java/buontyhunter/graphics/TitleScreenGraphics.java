package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class TitleScreenGraphics implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof HidableObject) {
            w.drawTitleScreen((HidableObject) obj, world);
        }
    }
    
}
