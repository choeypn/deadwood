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
        Model m = new Model(c);
        
        NumPlayerBox pb = new NumPlayerBox(c);
        c.setGame(m);
       
        c.setUi(gui);
        c.setPlayerBox(pb);

        // Run!
        System.out.println("begin");

    }

}