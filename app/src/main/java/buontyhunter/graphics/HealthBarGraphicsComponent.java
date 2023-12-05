package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HealthBar;
import buontyhunter.model.World;

public class HealthBarGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawHealthBar((HealthBar)obj, world);
        
    }
    
}
