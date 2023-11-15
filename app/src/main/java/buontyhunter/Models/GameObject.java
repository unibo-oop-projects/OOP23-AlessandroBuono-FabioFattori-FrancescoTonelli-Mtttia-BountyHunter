package buontyhunter.Models;

import java.awt.Graphics2D;

import buontyhunter.Common.GameObjectType;
import buontyhunter.Graphics.DrawableObject;
import buontyhunter.InputHandlers.InputComponent;
import buontyhunter.InputHandlers.InputController;

/* every thing that appear in the frame is a GameObject */
public class GameObject{
    private final DrawableObject graphicsComponent;
    private final InputComponent inputComponent;
    private GameObjectType type;
    private int healt;
    private int damage;
    private int x;
    private int y;
    private int speed;

    public GameObject(GameObjectType type,DrawableObject graphicsHandler,InputComponent inputComponent, int healt, int damage, int x , int y , int speed){
        this.type = type;
        setHealt(healt);
        setDamage(damage);
        setX(x);
        setY(y);
        setSpeed(speed);
        this.inputComponent = inputComponent;
        this.graphicsComponent = graphicsHandler;
    }


    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void draw(Graphics2D g2d) {
        this.graphicsComponent.draw(this,g2d);
    }

    public void inputHadler(InputController c) {
        this.inputComponent.update(this,c);
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

    public DrawableObject getGraphicsComponent() {
        return graphicsComponent;
    }

    public InputComponent getInputComponent() {
        return inputComponent;
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

    public void setX(int x){
        if (x < 0) {
            throw new IllegalArgumentException("X must be positive");
        }
        this.x = x;
    }

    public void setY(int y) {
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
