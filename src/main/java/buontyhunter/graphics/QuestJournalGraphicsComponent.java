package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class QuestJournalGraphicsComponent implements GraphicsComponent{

    /**
     * this method is used to draw the quest journal on the screen when it is open
     * @param obj the object to draw
     * @param w the graphics to draw the object
     * @param world the world
     */
    @Override
    public void update(GameObject obj, Graphics w, World world) {
        if(obj instanceof HidableObject){
            if(((HidableObject) obj).isShow()){
                w.drawQuestJournal(world);
            }
        }
    }
    
}
