package buontyhunter.weaponClasses;

import buontyhunter.common.ImageType;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.model.FighterEntity;

public class DefaultWeapon extends Weapon {


    //TODO creare immagine per i pugni da mettere al posto di null
    public DefaultWeapon(FighterEntity entity, Vector2d v2) {
        super(1, 1, 1, 1, null, entity);
        this.setDamagingArea(GameFactory.getInstance(GameEngine.resizator).WeaponDamagingArea(entity, v2));
    }
    
}
