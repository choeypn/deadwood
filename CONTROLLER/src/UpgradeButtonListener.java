package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class UpgradeButtonListener extends BaseMouseListener{

    private final String UPGRADE_SELECT_MSG = "Upgrade is Selected";

    public UpgradeButtonListener(Controller c){
        this.c = c;
    }
    
    public void mouseClicked(MouseEvent e) {
        c.getGame().ModelPlayerUpgrade(c.getGame().getActive_player(),
        		c.getChosenRank(),c.getChosenPayment());
        String info = c.getGame().getPlayers().get(0).playerInfo();
        c.getUi().updatePlayerInfo(c.getActivePlayer(), info);
    }
}
