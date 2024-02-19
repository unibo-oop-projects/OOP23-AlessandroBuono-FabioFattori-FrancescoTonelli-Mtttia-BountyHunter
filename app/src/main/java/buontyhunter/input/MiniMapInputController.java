package buontyhunter.input;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class MiniMapInputController implements InputComponent {

    private boolean readyToUpdate = true;

    @Override
    public void update(GameObject player, InputController c, World w) {
        // check if player is an HidableObject
        if (player instanceof HidableObject) {
            // check if player is shown
            if (c.isMPressed()) {
                if (readyToUpdate) {
                    ((HidableObject) player).toggleShow();
                    readyToUpdate = false;
                }
            } else {
                readyToUpdate = true;
            }
        }
    }
}
