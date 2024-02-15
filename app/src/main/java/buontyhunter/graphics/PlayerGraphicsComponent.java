package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.World;

public class PlayerGraphicsComponent implements GraphicsComponent {

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawPlayer(obj, world);
    }
}
