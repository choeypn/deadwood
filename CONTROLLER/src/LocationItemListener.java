package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

public class LocationItemListener implements ItemListener{
	private final String LOC_SELECT_MSG = "Location is Selected";
	
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.toString());
	}
}
