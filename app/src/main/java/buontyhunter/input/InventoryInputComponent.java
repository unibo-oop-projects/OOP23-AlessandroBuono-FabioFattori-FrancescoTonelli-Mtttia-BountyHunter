package buontyhunter.input;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class InventoryInputComponent implements InputComponent{

    private boolean readyToUpdate = true;
    @Override
    public void update(GameObject ball, InputController c, World w) {
        if (c.isIPressed()) {
                if (readyToUpdate) {
                    ((HidableObject) ball).toggleShow();
                    readyToUpdate = false;
                }
            } else {
                readyToUpdate = true;
            }
    }
    
}
