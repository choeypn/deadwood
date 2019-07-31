package CONTROLLER.src;
import MODEL.src.*;
import VIEW.src.*;

import java.awt.event.MouseEvent;

public class TwoPlayerNumberButtonListener extends BaseMouseListener{

    private final String PLAYERS_MSG = "Two Players";
    public TwoPlayerNumberButtonListener(Controller c){
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(PLAYERS_MSG);
        c.getGame().initModel(2);
        c.getPlayerBox().dispose();
        c.getGame().getGm().startDay();
    }
}

