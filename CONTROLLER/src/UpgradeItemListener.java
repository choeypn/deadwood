package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpgradeItemListener implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem().toString());
	}
}
