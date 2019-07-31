package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class ActButtonListener extends BaseMouseListener{
	private final String ACT_SELECT_MSG = "Acting is Selected";

	public ActButtonListener(Controller c){
		this.c = c;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println(ACT_SELECT_MSG);
	}
}
