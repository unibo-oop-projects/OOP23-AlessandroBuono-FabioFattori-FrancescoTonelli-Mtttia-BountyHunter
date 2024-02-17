package buontyhunter.physics;

import buontyhunter.core.GameFactory;
import buontyhunter.model.GameObject;
import buontyhunter.model.WizardBossEntity;
import buontyhunter.model.World;
import buontyhunter.model.KilledEnemyEvent;
import buontyhunter.model.AI.enemySpawner.EnemyType;

public class WizardBossPhysicsComponent extends PhysicsComponent {

    public void update(long dt, GameObject obj, World w) {
        if (obj instanceof WizardBossEntity) {
            WizardBossEntity wizardBoss = (WizardBossEntity) obj;
            wizardBoss.update(w);

            if(wizardBoss.getHealth() <= 0){
                w.notifyWorldEvent(new KilledEnemyEvent(EnemyType.WIZARD));
                w.setWizardBoss(GameFactory.getInstance().createWizardBoss(w));
            }
        }
    }
}
