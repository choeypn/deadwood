package CONTROLLER.src;

import java.awt.event.MouseEvent;

public class UpgradeButtonListener extends BaseMouseListener{
    private final String UPGRADE_SELECT_MSG = "Upgrade is Selected";

    public void mouseClicked(MouseEvent e) {
        System.out.println(UPGRADE_SELECT_MSG);
    }
}
