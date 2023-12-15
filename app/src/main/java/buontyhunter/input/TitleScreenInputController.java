package buontyhunter.input;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;

public class TitleScreenInputController implements InputComponent{

    private boolean readyToUpdate = true;

    @Override
    public void update(GameObject title, InputController c) {
        // check if player is an HidableObject
        if (title instanceof HidableObject) {
            // check if player is shown
            if (c.getAKeyIsPressed()) {
                if (readyToUpdate) {
                    ((HidableObject) title).toggleShow();
                    readyToUpdate = false;
                }
            } else {
                
                readyToUpdate = true;
            }
        }
    }

    
}
