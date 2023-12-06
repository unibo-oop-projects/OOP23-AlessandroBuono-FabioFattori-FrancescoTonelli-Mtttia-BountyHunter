package buontyhunter.input;

public class KeyboardInputController implements InputController {

	//Movement variables
	private boolean isMoveUp;
	private boolean isMoveDown;
	private boolean isMoveLeft;
	private boolean isMoveRight;
	
	//Attack variables
	private boolean isAttackUp;
	private boolean isAttackDown;
	private boolean isAttackLeft;
	private boolean isAttackRight;

	//Map variables
	private boolean isMPressed;

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
}
