package VIEW.src;

import javax.swing.JButton;
import javax.swing.JFrame;

import CONTROLLER.src.Controller;
import CONTROLLER.src.ThreePlayerNumberButtonListener;
import CONTROLLER.src.TwoPlayerNumberButtonListener;

public class NumPlayerBox extends JFrame{
    // Create popup window
    //final JFrame parent = new JFrame();
    JButton two_play = new JButton();
    JButton three_play = new JButton();
    private Controller c;
    public NumPlayerBox(Controller c) {
    	this.c = c;
    	setLayout(null);
    	setSize(270, 175);

    	two_play.setText("Two Players");
    	two_play.setBounds(20 , 20 , 200 , 30);
    	add(two_play);

    	three_play.setText("Three Players");
    	three_play.setBounds(20 , 70 , 200 , 30);
    	add(three_play);
    	
    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);

    	two_play.addMouseListener(new TwoPlayerNumberButtonListener(c));
    	three_play.addMouseListener(new ThreePlayerNumberButtonListener(c));
    }
}
