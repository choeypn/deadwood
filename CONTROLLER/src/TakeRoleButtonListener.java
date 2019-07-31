package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class TakeRoleButtonListener extends BaseMouseListener{
    private final String TAKEROLE_SELECT_MSG = "Take Role is Selected";

    public TakeRoleButtonListener(Controller c){
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(TAKEROLE_SELECT_MSG);
    }
}
