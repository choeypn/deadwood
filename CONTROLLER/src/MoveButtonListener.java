package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class MoveButtonListener extends BaseMouseListener{
	private final String MOVE_SELECT_MSG = "Move is Selected";
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(MOVE_SELECT_MSG);
	}
}