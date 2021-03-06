package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpgradeItemListener implements ItemListener{

	private Controller c;

	public UpgradeItemListener(Controller c){
		this.c = c;
	}
	private String s;
	private int run = 0;
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			s = e.getItem().toString();
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			s = "";
		}
		
		if (run == 1) {
			c.setChosenRank(inputUpgrade(s));
			run = 0;
		}
		else {
			run += 1;
		}
	}
	public int inputUpgrade(String select) {
		int out = 1;
		switch(select) {
			case "Rank 2":
				out = 2;
				break;
			case "Rank 3":
				out = 3;
				break;
			case "Rank 4":
				out = 4;
				break;
			case "Rank 5":
				out = 5;
				break;
			case "Rank 6":
				out = 6;
				break;
				
		}
		
		
		return out;
	}

}
