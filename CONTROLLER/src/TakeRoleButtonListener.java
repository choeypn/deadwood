package CONTROLLER.src;

import MODEL.src.Player;

import java.awt.event.MouseEvent;

public class TakeRoleButtonListener extends BaseMouseListener{
    private final String TAKEROLE_SELECT_MSG = "Take Role is Selected";

    public TakeRoleButtonListener(Controller c){
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        Player currentPlayer = c.getGame().getActive_player();
    	String input = c.getChosenRole();
    	try {
            char cast = input.charAt(0);
            int number = Character.getNumericValue(input.charAt(1));
            c.getGame().ModelPlayerTakeRole(c.getGame().getActive_player(), number, cast);
            c.getUi().updatePlayerInfo(currentPlayer.getPlayer_num(),currentPlayer.playerInfo());
        }
    	catch (Exception h) {
        }
    }
}
