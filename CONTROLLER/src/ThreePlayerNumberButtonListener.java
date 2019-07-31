package CONTROLLER.src;
import MODEL.src.*;
import VIEW.src.*;

import java.awt.event.MouseEvent;

public class ThreePlayerNumberButtonListener extends BaseMouseListener{

    public ThreePlayerNumberButtonListener(Controller c){
        this.c = c;
    }

    private final String PLAYERS_MSG = "Three Players";

    public void mouseClicked(MouseEvent e) {
        System.out.println(PLAYERS_MSG);
        c.getGame().initModel(3);
        c.getPlayerBox().dispose();
    }
}

