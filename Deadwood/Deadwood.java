package Deadwood;
import java.util.ArrayList;
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

    	// ~~~~~~~~~~~~~~~~ GAME INITIALIZATION ROUTINE ~~~~~~~~~~~~~~~~~~~~
		// WRAP IN FUNCTION LATER!!!!

    	// Create number of players from the input
    	int playNum = Integer.parseInt(argv[0]);
    	ArrayList<Player> tot = new ArrayList<Player>();
    	for(int i = 1;i <= playNum;i++) {
    		tot.add(new Player(i));
    	}

    	// Initialize the board - standard tile configuration
    	Board gameboard = new Board();
		
    	//test scene and role classes
    	Role[] rs = {new Role("one",1),new Role("two",2)};
    	Scene s1 = new Scene("scene one",2,rs);
    	s1.firstRoleInfo();

    }
    
}