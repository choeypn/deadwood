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
        c.getGame().getGm().startDay();
        c.setActivePlayer(
        		c.getGame().getActive_player().getPlayer_num());
        c.getUi().enablePlayerInfo(3);
        String info;
        for(int i = 1; i <= 3; i++) {
            info = c.getGame().getPlayers().get(i-1).playerInfo();
            c.getUi().updatePlayerInfo(i, info);
        }
    }
}

