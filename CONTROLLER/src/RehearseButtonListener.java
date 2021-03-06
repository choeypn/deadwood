package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class RehearseButtonListener extends BaseMouseListener{
	private final String REHEARSE_SELECT_MSG = "Rehearse is Selected";

	public RehearseButtonListener(Controller c){
		this.c = c;
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(REHEARSE_SELECT_MSG);
		c.getGame().ModelPlayerRehearse(c.getGame().getActive_player());
		String info = c.getGame().getPlayers().get(0).playerInfo();
		c.getUi().updatePlayerInfo(c.getActivePlayer(), info);
	}
}
