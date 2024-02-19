package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.LoadingBar;
import buontyhunter.model.World;

public class LoadingBarGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawProgressBar((LoadingBar)obj, world);
    }
    
}
