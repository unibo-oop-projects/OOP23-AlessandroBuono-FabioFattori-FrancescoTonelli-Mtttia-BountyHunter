package buontyhunter.Models;

import java.awt.Graphics2D;

import buontyhunter.Graphics.IDrawableObject;
import buontyhunter.Utils.GameObjectType;

/* every thing that appear in the frame is a GameObject */
public class GameObject implements IGameObject{
    private final IDrawableObject graphicsComponent;
    private GameObjectType type;
    private int healt;
    private int damage;
    private int x;
    private int y;
    private int speed;

    public GameObject(GameObjectType type,IDrawableObject graphicsHandler, int healt, int damage, int x , int y , int speed){
        this.type = type;
        setHealt(healt);
        setDamage(damage);
        setX(x);
        setY(y);
        setSpeed(speed);
        this.graphicsComponent = graphicsHandler;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics2D g2d) {
        this.graphicsComponent.draw(this,g2d);
    }

    @Override
    public void inputHadler() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inputHadler'");
    }


    /* setter and getter area */

    public GameObjectType getType() {
        return type;
    }

    public int getHealt() {
        return healt;
    }

    public int getDamage() {
        return damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed(){
        return speed;
    }

    private void setHealt(int healt) {
        if (healt <= 0) {
            throw new IllegalArgumentException("Healt must be positive");
        }
        this.healt = healt;
    }

    private void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage must be positive");
        }
        this.damage = damage;
    }

    private void setX(int x){
        if (x < 0) {
            throw new IllegalArgumentException("X must be positive");
        }
        this.x = x;
    }

    private void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("Y must be positive");
        }
        this.y = y;
    }

    private void setSpeed(int speed){
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must be positive");
        }
        this.speed = speed;
    }

    
}
