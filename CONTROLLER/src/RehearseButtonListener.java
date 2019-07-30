package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class RehearseButtonListener extends BaseMouseListener{
	private final String REHEARSE_SELECT_MSG = "Rehearse is Selected";
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(REHEARSE_SELECT_MSG);
	}
}
