package CONTROLLER.src;

import java.awt.event.MouseEvent;

import MODEL.src.Player;

public class EndButtonListener extends BaseMouseListener {
	private final String END_SELECT_MSG = "End is Selected";

	public EndButtonListener(Controller c){
		this.c = c;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println(END_SELECT_MSG);
		System.out.println(c.getActivePlayer());
		c.getGame().nextPlayer();
		c.setActivePlayer(c.getGame().getActive_player().getPlayer_num());
		c.getUi().displayActivePlayer(c.getActivePlayer());
	}

}
