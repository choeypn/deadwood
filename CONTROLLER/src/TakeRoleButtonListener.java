package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class TakeRoleButtonListener extends BaseMouseListener{
    private final String TAKEROLE_SELECT_MSG = "Take Role is Selected";

    public TakeRoleButtonListener(Controller c){
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
    	String input = c.getChosenRole();
		char cast = input.charAt(0);
		int number = Character.getNumericValue(input.charAt(1));
		c.getGame().ModelPlayerTakeRole(c.getGame().getActive_player(), number, cast);
    }
}
