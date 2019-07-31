package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpgradeItemListener implements ItemListener{

	private Controller c;

	public UpgradeItemListener(Controller c){
		this.c = c;
	}

	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem().toString());
	}


}
