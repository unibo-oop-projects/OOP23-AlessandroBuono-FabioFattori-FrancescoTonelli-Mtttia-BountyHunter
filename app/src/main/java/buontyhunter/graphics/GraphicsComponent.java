package buontyhunter.graphics;

import buontyhunter.model.*;

public interface GraphicsComponent {

	/**
	 * this method is used to draw the object on the screen
	 * @param obj the object to draw
	 * @param w the world
	 */
	void update(GameObject obj, Graphics w, World world);
}
