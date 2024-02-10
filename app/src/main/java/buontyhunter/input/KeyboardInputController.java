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


	//Movement keys state update functions
	public void notifyMoveUp() {
		isMoveUp = true;
	}

	public void notifyNoMoreMoveUp() {
		isMoveUp = false;
	}

	public void notifyMoveDown() {
		isMoveDown = true;
	}

	public void notifyNoMoreMoveDown() {
		isMoveDown = false;
	}

	public void notifyMoveLeft() {
		isMoveLeft = true;
	}

	public void notifyNoMoreMoveLeft() {
		isMoveLeft = false;
	}

	public void notifyMoveRight() {
		isMoveRight = true;
	}

	public void notifyNoMoreMoveRight() {
		isMoveRight = false;
	}

	//Attack keys state update functions

	public void notifyAttackUp(){
		isAttackUp=true;
	}

	public void notifyNoMoreAttackUp(){
		isAttackUp=false;
	}

	public void notifyAttackDown(){
		isAttackDown=true;
	}

	public void notifyNoMoreAttackDown(){
		isAttackDown=false;
	}

	public void notifyAttackLeft(){
		isAttackLeft=true;
	}

	public void notifyNoMoreAttackLeft(){
		isAttackLeft=false;
	}

	public void notifyAttackRight(){
		isAttackRight=true;
	}

	public void notifyNoMoreAttackRight(){
		isAttackRight=false;
	}

	//Map pressed state update functions
	public void notifyMPressed() {
		isMPressed = true;
	}

	public void notifyNoMoreMPressed() {
		isMPressed = false;
	}

	public void notifyEPressed() {
		isEPressed = true;
	}

	public void notifyNoMoreEPressed() {
		isEPressed = false;
	}

	public void notifyIPressed() {
		isIPressed = true;
	}

	public void notifyNoMoreIPressed() {
		isIPressed = false;
	}

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

	public void notifyJPressed() {
		isJPressed = true;
	}

	public void notifyNoMoreJPressed() {
		isJPressed = false;
	}

	@Override
	public boolean isJPressed() {
		return isJPressed;
	}
}
