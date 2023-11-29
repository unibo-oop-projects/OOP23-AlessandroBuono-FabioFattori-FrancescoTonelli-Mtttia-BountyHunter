package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.NavigatorLine;
import buontyhunter.model.World;

public class NavigatorLineGraphicsComponent implements GraphicsComponent {

    public NavigatorLineGraphicsComponent() {
    }

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if (obj instanceof NavigatorLine) {
            w.drawNavigatorLine((NavigatorLine) obj, world);
        }
    }
}
