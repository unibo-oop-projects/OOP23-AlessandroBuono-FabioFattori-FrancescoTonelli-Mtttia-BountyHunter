package buontyhunter.input;

public interface InputController {
	/**
	 * get if the W key is pressed
	 */
	boolean isMoveUp();

	/**
	 * get if the S key is pressed
	 */
	boolean isMoveDown();

	/**
	 * get if the A key is pressed
	 */
	boolean isMoveLeft();

	/**
	 * get if the D key is pressed
	 */
	boolean isMoveRight();

	/**
	 * get if the UP key is pressed
	 */
	boolean isAttackUp();

	/**
	 * get if the DOWN key is pressed
	 */
	boolean isAttackDown();

	/**
	 * get if the LEFT key is pressed
	 */
	boolean isAttackLeft();
	
	/**
	 * get if the RIGHT key is pressed
	 */
	boolean isAttackRight();

	/**
	 * get if the M key is pressed
	 */
	boolean isMPressed();

	/**
	 * get if the E key is pressed
	 */
	boolean isEPressed();

	/**
	 * get if the I key is pressed
	 */
	boolean isIPressed();

	/**
	 * get if the J key is pressed
	 */
	boolean isJPressed();

	/**
	 * get if any key is pressed
	 */
	boolean anyKeyIsPressedSinceStart();
}
