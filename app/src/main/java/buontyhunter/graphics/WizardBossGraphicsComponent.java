package buontyhunter.graphics;

import buontyhunter.model.GameObject;
import buontyhunter.model.WizardBossEntity;
import buontyhunter.model.World;

public class WizardBossGraphicsComponent implements GraphicsComponent {

    @Override
    public void update(GameObject obj, Graphics w, World world) {
        w.drawWizardBoss((WizardBossEntity) obj, world);
    }

}
