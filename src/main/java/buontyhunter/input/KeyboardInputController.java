package buontyhunter.input;

public class KeyboardInputController implements InputController {

	//Movement variables
	private boolean isMoveUp;
	private boolean isMoveDown;
	private boolean isMoveLeft;
	private boolean isMoveRight;
	private boolean isEPressed;
	private boolean isMPressed;
	private boolean isIPressed;
	private boolean isJPressed;

	//Any key pressed since start => game need to start
	private boolean anyKeyIsPressedSinceStart;
	
	//Attack variables
	private boolean isAttackUp;
	private boolean isAttackDown;
	private boolean isAttackLeft;
	private boolean isAttackRight;

	@Override
	public boolean isMoveUp() {
		return isMoveUp;
	}

	@Override
	public boolean isMoveDown() {
		return isMoveDown;
	}

	@Override
	public boolean isMoveLeft() {
		return isMoveLeft;
	}

	@Override
	public boolean isMoveRight() {
		return isMoveRight;
	}

	@Override
	public boolean isMPressed() {
		return isMPressed;
	}

	@Override
	public boolean isAttackUp(){
		return isAttackUp;
	}

	@Override
	public boolean isAttackDown(){
		return isAttackDown;
	}

	@Override
	public boolean isAttackLeft(){
		return isAttackLeft;
	}
	
	@Override
	public boolean isAttackRight(){
		return isAttackRight;
	}


	/**
	 * this method is used to notify the controller that the W key is pressed
	 */
	public void notifyMoveUp() {
		isMoveUp = true;
	}

	/**
	 * this method is used to notify the controller that the W key is released
	 */
	public void notifyNoMoreMoveUp() {
		isMoveUp = false;
	}

	/**
	 * this method is used to notify the controller that the S key is pressed
	 */
	public void notifyMoveDown() {
		isMoveDown = true;
	}

	/**
	 * this method is used to notify the controller that the S key is released
	 */
	public void notifyNoMoreMoveDown() {
		isMoveDown = false;
	}

	/**
	 * this method is used to notify the controller that the A key is pressed
	 */
	public void notifyMoveLeft() {
		isMoveLeft = true;
	}

	/**
	 * this method is used to notify the controller that the A key is released
	 */
	public void notifyNoMoreMoveLeft() {
		isMoveLeft = false;
	}

	/**
	 * this method is used to notify the controller that the D key is pressed
	 */
	public void notifyMoveRight() {
		isMoveRight = true;
	}

	/**
	 * this method is used to notify the controller that the D key is released
	 */
	public void notifyNoMoreMoveRight() {
		isMoveRight = false;
	}

	/**
	 * this method is used to notify the controller that the UP key is pressed
	 */
	public void notifyAttackUp(){
		isAttackUp=true;
	}

	/**
	 * this method is used to notify the controller that the UP key is released
	 */
	public void notifyNoMoreAttackUp(){
		isAttackUp=false;
	}

	/**
	 * this method is used to notify the controller that the DOWN key is pressed
	 */
	public void notifyAttackDown(){
		isAttackDown=true;
	}

	/**
	 * this method is used to notify the controller that the DOWN key is released
	 */
	public void notifyNoMoreAttackDown(){
		isAttackDown=false;
	}

	/**
	 * this method is used to notify the controller that the LEFT key is pressed
	 */
	public void notifyAttackLeft(){
		isAttackLeft=true;
	}

	/**
	 * this method is used to notify the controller that the LEFT key is released
	 */
	public void notifyNoMoreAttackLeft(){
		isAttackLeft=false;
	}

	/**
	 * this method is used to notify the controller that the RIGHT key is pressed
	 */
	public void notifyAttackRight(){
		isAttackRight=true;
	}

	/**
	 * this method is used to notify the controller that the RIGHT key is released
	 */
	public void notifyNoMoreAttackRight(){
		isAttackRight=false;
	}

	/**
	 * this method is used to notify the controller that the M key is pressed
	 */
	public void notifyMPressed() {
		isMPressed = true;
	}

	/**
	 * this method is used to notify the controller that the M key is released
	 */
	public void notifyNoMoreMPressed() {
		isMPressed = false;
	}

	/**
	 * this method is used to notify the controller that the E key is pressed
	 */
	public void notifyEPressed() {
		isEPressed = true;
	}

	/**
	 * this method is used to notify the controller that the E key is released
	 */
	public void notifyNoMoreEPressed() {
		isEPressed = false;
	}

	/**
	 * this method is used to notify the controller that the I key is pressed
	 */
	public void notifyIPressed() {
		isIPressed = true;
	}

	/**
	 * this method is used to notify the controller that the I key is released
	 */
	public void notifyNoMoreIPressed() {
		isIPressed = false;
	}

	/**
	 * this method is used to reset the controller to its default state, so no key is pressed
	 */
	public void reset() {
		isMoveUp = false;
		isMoveDown = false;
		isMoveLeft = false;
		isMoveRight = false;
		isEPressed = false;
		isMPressed = false;
		isIPressed = false;
		isJPressed = false;
		isAttackUp = false;
		isAttackDown = false;
		isAttackLeft = false;
		isAttackRight = false;
	}

	@Override
	public boolean isEPressed() {
		return isEPressed;
	}

	@Override
	public boolean isIPressed() {
		return isIPressed;
	}

	/**
	 * this method is used to notify the controller that J key is pressed
	 */
	public void notifyJPressed() {
		isJPressed = true;
	}

	/**
	 * this method is used to notify the controller that J key is released
	 */
	public void notifyNoMoreJPressed() {
		isJPressed = false;
	}

	@Override
	public boolean isJPressed() {
		return isJPressed;
	}

	@Override
	public boolean anyKeyIsPressedSinceStart() {
		return anyKeyIsPressedSinceStart;
	}

	/**
	 * this method is used to reset the anyKeyIsPressedSinceStart variable to true
	 */
	public void notifyAnyKeyIsPressedSinceStart() {
		anyKeyIsPressedSinceStart = true;
	}

	/**
	 * this method is used to reset the anyKeyIsPressedSinceStart variable to false
	 */
	public void notifyNoMoreAnyKeyIsPressedSinceStart() {
		anyKeyIsPressedSinceStart = false;
	}
}
