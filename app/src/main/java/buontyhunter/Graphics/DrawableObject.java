package buontyhunter.Graphics;

import java.awt.Graphics2D;

import buontyhunter.Models.GameObject;

public interface DrawableObject {
    public void draw(GameObject gameObject,Graphics2D g2d);
}
