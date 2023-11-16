package buontyhunter.Graphics;

import java.awt.Graphics2D;

import buontyhunter.Models.TileManager;
import buontyhunter.Core.GameConfiguration;
import buontyhunter.Core.GameEngine;
import buontyhunter.Graphics.ScreenHandlerImpl.ScenePanel;
import buontyhunter.Models.Tile;
import java.util.List;

public class MapGraphicsComponent implements DrawableMap{

    @Override
    public void draw(TileManager manager, Graphics2D g2d) {

        for (int x = manager.getX(); x < manager.getTiles().size(); x += 1) {
            for (int y = manager.getY(); y < manager.getTiles().get(x).size(); y += 1) {
                g2d.drawImage(manager.getTiles().get(x).get(y).getImage(), x * 32, y * 32, null);
            }
        }
    }

    
    
}
