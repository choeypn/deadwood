package MAIN.src;
import MODEL.src.*;
import VIEW.src.*;
import CONTROLLER.src.*;


import javax.swing.*;


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                                DEADWOOD                                  //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//  This program is our design of the Deadwood board game.                  //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
public class Deadwood {

    // Main Method - program entry point
    public static void main(String[] argv) {

        // Create the Controller (references to model and GUI)
        Controller c = new Controller();

        // Create the GUI
        GUI gui = new GUI(c);
        gui.setVisible(true);

        // Create the Model
        Model m = new Model();

       c.setGame(m);
       c.setUi(gui);



        // Create popup window
        final JFrame parent = new JFrame();
        JButton two_play = new JButton();
        JButton three_play = new JButton();

        parent.setLayout(null);
        parent.setSize(270, 175);

        two_play.setText("Two Players");
        two_play.setBounds(20 , 20 , 200 , 30);
        parent.add(two_play);

        three_play.setText("Three Players");
        three_play.setBounds(20 , 70 , 200 , 30);
        parent.add(three_play);


        parent.setVisible(true);

        two_play.addMouseListener(new TwoPlayerNumberButtonListener(c));
        three_play.addMouseListener(new ThreePlayerNumberButtonListener(c));


        // Run!
        System.out.println("begin");

    }

}