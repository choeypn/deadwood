package CONTROLLER.src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PaymentItemListener implements ItemListener{
	private Controller c;

	public PaymentItemListener(Controller c){
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
			c.setChosenPayment(inputPayment(s));
			run = 0;
		}
		else {
			run += 1;
		}
	}
	public char inputPayment(String select) {
		char out = ' ';
		switch(select) {
			case "Dollar":
				out = 'd';
				break;
			case "Credit":
				out = 'c';
				break;				
		}
		
		
		return out;
	}
}
