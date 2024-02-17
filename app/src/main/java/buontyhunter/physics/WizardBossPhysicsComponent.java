package buontyhunter.physics;

import buontyhunter.model.GameObject;
import buontyhunter.model.WizardBossEntity;
import buontyhunter.model.World;

public class WizardBossPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        if (obj instanceof WizardBossEntity) {
            WizardBossEntity wizardBoss = (WizardBossEntity) obj;
            wizardBoss.update(w);
        }
    }
}
