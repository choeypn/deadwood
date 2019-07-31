package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

public class LocationItemListener implements ItemListener{
	private Controller c;

	public LocationItemListener(Controller c){
		this.c = c;
	}

	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem().toString());
	}
	

}
