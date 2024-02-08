package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.QuestPannel;
import buontyhunter.model.World;

public class QuestPanelGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawQuestPannel((QuestPannel)obj, world);
    }
    
}
