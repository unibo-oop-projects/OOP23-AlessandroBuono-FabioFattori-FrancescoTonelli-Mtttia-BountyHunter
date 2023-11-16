package buontyhunter.Models;

import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.DrawableObject;
import buontyhunter.InputHandlers.InputComponent;

public class FighterEntity extends GameObject{

    private int healt;
    private int damage;

    public FighterEntity(GameObjectType type, DrawableObject graphicsHandler, InputComponent inputComponent, int healt,
            int damage, int x, int y, int speed) {
        super(type, graphicsHandler, inputComponent, x, y, speed);
        setHealt(healt);
        setDamage(damage);
        
    }
    
    public int getHealt() {
        return healt;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealt(int healt) {
        if (healt <= 0) {
            throw new IllegalArgumentException("Healt must be positive");
        }
        this.healt = healt;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage must be positive");
        }
        this.damage = damage;
    }
}
