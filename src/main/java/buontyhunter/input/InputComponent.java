package buontyhunter.input;

import buontyhunter.model.*;

public interface InputComponent {
	/**
	 * this method is used to update the object
	 * @param ball the object to update
	 * @param c the input controller
	 * @param w the world
	 */
	void update(GameObject ball, InputController c, World w);
}
