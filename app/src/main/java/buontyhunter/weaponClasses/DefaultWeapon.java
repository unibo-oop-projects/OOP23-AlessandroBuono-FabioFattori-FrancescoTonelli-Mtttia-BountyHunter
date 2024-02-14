package buontyhunter.weaponClasses;

import buontyhunter.model.FighterEntity;

public class DefaultWeapon extends Weapon {


    //TODO creare immagine per i pugni da mettere al posto di null
    public DefaultWeapon(FighterEntity owner) {
        super(30, 1, 1, 1, null,owner);
    }
    
}
