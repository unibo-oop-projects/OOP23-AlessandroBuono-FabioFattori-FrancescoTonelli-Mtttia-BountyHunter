package buontyhunter.Graphics;

import buontyhunter.model.*;

public interface Graphics {

	void drawPlayer(GameObject obj, World w);

	void drawMap(TileManager tileManager, World w);
}
