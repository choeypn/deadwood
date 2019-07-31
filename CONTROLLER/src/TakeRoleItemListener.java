package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TakeRoleItemListener implements ItemListener{
	private Controller c;

	public TakeRoleItemListener(Controller c){
		this.c = c;
	}
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem().toString());
	}
}
