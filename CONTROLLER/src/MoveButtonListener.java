package CONTROLLER.src;

import java.awt.event.MouseEvent;

import MODEL.src.*;

public class MoveButtonListener extends BaseMouseListener{
	private final String MOVE_SELECT_MSG = "Move is Selected";

	public MoveButtonListener(Controller c){
		this.c = c;
	}

	public void mouseClicked(MouseEvent e) {
		Player currentPlayer = c.getGame().getActive_player();
		c.getGame().setActive_player(currentPlayer);
		int location = c.getChosenLocation();
		c.getGame().ModelPlayerMove(c.getGame().getActive_player(), location);
		c.getUi().updatePlayerInfo(currentPlayer.getPlayer_num(),currentPlayer.playerInfo());
	}
}
