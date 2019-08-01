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
        c.setActivePlayer(
        		c.getGame().getActive_player().getPlayer_num());
        c.getUi().enablePlayerInfo(2);
        String info;
        for(int i = 1; i <= 2; i++) {
            info = c.getGame().getPlayers().get(i-1).playerInfo();
            c.getUi().updatePlayerInfo(i, info);
        }

    }
}

