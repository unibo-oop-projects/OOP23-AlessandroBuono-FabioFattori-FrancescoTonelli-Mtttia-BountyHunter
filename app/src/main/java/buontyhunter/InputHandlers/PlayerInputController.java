package buontyhunter.InputHandlers;

import buontyhunter.Models.GameObject;

/**
 * PlayerInputController
 */
public class PlayerInputController implements InputComponent{

    @Override
    public void update(GameObject player, InputController c) {
        if (c.isMoveUp()){
			player.setY(player.getY() - player.getSpeed());
		} else if (c.isMoveDown()){
			player.setY(player.getY() + player.getSpeed());
		} else if (c.isMoveLeft()){
			player.setX(player.getX() - player.getSpeed());			
		} else if (c.isMoveRight()){
			player.setX(player.getX() + player.getSpeed());		
		}
    }

	

    
}