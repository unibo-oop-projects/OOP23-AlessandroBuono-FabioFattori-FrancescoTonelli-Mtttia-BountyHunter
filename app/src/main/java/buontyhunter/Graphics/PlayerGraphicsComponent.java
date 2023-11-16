package buontyhunter.Graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import buontyhunter.Models.GameObject;

public class PlayerGraphicsComponent implements DrawableObject{
    

    public PlayerGraphicsComponent() {
    }

    @Override
    public void draw(GameObject gameObject, Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(gameObject.getX(), gameObject.getY(), 32, 32);
    }
    
}
