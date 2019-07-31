package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

public class LocationItemListener implements ItemListener{
	private Controller c;
	private int loc;
	public LocationItemListener(Controller c){
		this.c = c;
	}
	
	private int run = 0;
	
	private String s;
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			s = e.getItem().toString();
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			s = "";
		}
		
		if (run == 1) {
			loc = intLocation(s);
			c.setChosenLocation(loc);
			run = 0;
		}
		else {
			run += 1;
		}
	}
	
	public int intLocation(String s) {
		int out = 0;
		switch(s){
		case "Trailers":
			out = 0;
			break;
		case "Casting Office":
			out = 1;
			break;
		case "Jail":
			out = 2;
			break;
		case "Train Station":
			out = 3;
			break;
		case "General Store":
			out = 4;
			break;
		case "Saloon":
			out = 5;
			break;
		case "Main Street":
			out = 6;
			break;
		case "Secret Hideout":
			out = 7;
			break;
		case "Ranch":
			out = 8;
			break;
		case "Bank":
			out = 9;
			break;
		case "Church":
			out = 10;
			break;
		case "Hotel":
			out = 11;
			break;
		}
		return out;
	}
}
