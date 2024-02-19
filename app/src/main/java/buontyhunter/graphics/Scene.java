package buontyhunter.graphics;

public interface Scene {

	/**
	 * this method is used to render the scene
	 */
	void render();

	/**
	 * this method is used to render the game over
	 */
	void renderGameOver();

	/**
	 * this method set the isHub value to the value of the parameter
	 * @param isHub the value to set
	 */
	void setIsHub(boolean isHub);

	/**
	 * this method is used to dispose the scene
	 */
	void dispose();
}
