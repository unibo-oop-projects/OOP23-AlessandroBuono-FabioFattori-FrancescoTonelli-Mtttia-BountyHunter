package buontyhunter.graphics;

import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.model.GameObject;
import buontyhunter.model.HealthBar;
import buontyhunter.model.World;

public class HealthBarGraphicsComponent implements GraphicsComponent{

    
    @Override
    public void update(GameObject obj, Graphics w, World world) {

		int weaponContainerDimension = GameEngine.RESIZATOR.getWINDOW_HEIGHT() / 8;
		int weaponContainerX = 10;
		int weaponContainerY = GameEngine.RESIZATOR.getWINDOW_HEIGHT() - weaponContainerDimension - 50;

        ((HealthBar)obj).setPos(new Point2d(weaponContainerX + weaponContainerDimension + 10, weaponContainerY));

        w.drawHealthBar((HealthBar)obj, world);
        
    }
    
}
