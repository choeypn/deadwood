package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TakeRoleItemListener implements ItemListener{
	private Controller c;

	public TakeRoleItemListener(Controller c){
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
			c.setChosenRole(inputRole(s));
			run = 0;
		}
		else {
			run += 1;
		}
	}
	public String inputRole(String s) {
		String out = "";
		switch(s){
		case "Main 1":
			out = "m0";
			break;
		case "Main 2":
			out = "m1";
			break;
		case "Main 3":
			out = "m2";
			break;
		case "Extra 1":
			out = "x0";
			break;
		case "Extra 2":
			out = "x1";
			break;
		case "Extra 3":
			out = "x2";
			break;
		case "Extra 4":
			out = "x3";
			break;
		}
		return out;
	}
}

