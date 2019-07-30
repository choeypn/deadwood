package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class TakeRoleButtonListener extends BaseMouseListener{
    private final String TAKEROLE_SELECT_MSG = "Take Role is Selected";


    public void mouseClicked(MouseEvent e) {
        System.out.println(TAKEROLE_SELECT_MSG);
    }
}
