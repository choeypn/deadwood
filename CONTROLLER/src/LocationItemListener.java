package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

public class LocationItemListener implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem().toString());
	}
	

}
