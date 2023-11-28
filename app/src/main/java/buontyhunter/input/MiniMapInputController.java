package buontyhunter.input;

import buontyhunter.common.Vector2d;
import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;

public class MiniMapInputController implements InputComponent {

    private boolean readyToUpdate = true;

    @Override
    public void update(GameObject player, InputController c) {
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
