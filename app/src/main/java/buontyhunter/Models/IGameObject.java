package buontyhunter.Models;

import java.awt.Graphics2D;

public interface IGameObject {
    public void update();
    public void draw(Graphics2D g2d);
    public void inputHadler();

}
