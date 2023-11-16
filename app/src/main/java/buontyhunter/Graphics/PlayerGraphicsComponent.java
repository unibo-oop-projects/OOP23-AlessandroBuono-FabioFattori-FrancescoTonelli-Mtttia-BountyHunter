package buontyhunter.graphics;

import buontyhunter.model.GameObject;

public class PlayerGraphicsComponent implements GraphicsComponent {

    public PlayerGraphicsComponent() {
    }

    @Override
    public void update(GameObject obj, Graphics w) {
        w.drawPlayer(obj);
    }
}
