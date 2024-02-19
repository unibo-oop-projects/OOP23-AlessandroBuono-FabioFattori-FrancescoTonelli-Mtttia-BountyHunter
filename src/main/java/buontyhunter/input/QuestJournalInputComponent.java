package buontyhunter.input;

import buontyhunter.model.GameObject;
import buontyhunter.model.HidableObject;
import buontyhunter.model.World;

public class QuestJournalInputComponent implements InputComponent {

    private boolean readyToUpdate = true;

    @Override
    public void update(GameObject ball, InputController c, World w) {
        if (ball instanceof HidableObject) {
            if (c.isJPressed()) {
                if (readyToUpdate) {
                    ((HidableObject) ball).toggleShow();
                    readyToUpdate = false;
                }
            } else {
                readyToUpdate = true;
            }
        }
    }

}
