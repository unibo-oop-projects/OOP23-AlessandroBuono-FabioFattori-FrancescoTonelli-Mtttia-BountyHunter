package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class QuestJournalGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if(obj instanceof HidableObject){
            if(((HidableObject) obj).isShow()){
                w.drawQuestJournal(world);
            }
        }
    }
    
}
