package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class QuestPanelGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawQuestPannel((HidableObject )obj, world);
    }
    
}
