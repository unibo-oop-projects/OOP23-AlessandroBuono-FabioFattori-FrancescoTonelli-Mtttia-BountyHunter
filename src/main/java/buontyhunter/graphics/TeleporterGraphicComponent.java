package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.Teleporter;
import buontyhunter.model.World;

public class TeleporterGraphicComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawTeleporter((Teleporter)obj, world);
    }
    
}
