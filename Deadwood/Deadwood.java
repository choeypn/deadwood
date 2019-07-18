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

		// Initialize the board - standard tile configuration
		Board gameboard = new Board();

		// Create number of players from the input
		int playNum = Integer.parseInt(argv[0]);
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 1;i <= playNum;i++) {
			players.add(new Player(i));
		}

		// Create a gamemaster, initialize total days to 3
		GameMaster gm = new GameMaster(3, gameboard, players);

		// Variable for currently active player
		Player active_player;
		boolean endOfTurn = false;

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GAMEPLAY LOOP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		boolean endDay = false;
		// Continue until no gameplay days are left
		while(gm.getGame_days() != 0){

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// Beginning of day - GAME-MASTER controller
			// Set the scene cards (10 face down on board)
			// Reset shot counters on scenes
			// Move players to trailers
			gm.startDay();
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// During the day

			// Players work in rotation - 1 - 3
			// Players operate in a loop - this loop runs until there is only once scene card left on the board
			while(!endDay) {

				// Player turn
				active_player = players.remove(0);
				System.out.println(active_player.playerInfo());

				// Players turn until they decide to end it
				while(!endOfTurn){

					// Players have options
					// 1) Move if not on a role, this can be paired with taking a role
					// 3) If you are located at the casting office, you can upgrade
					if(active_player.getRole() == null) {

					}


					// 2) If you are on a role, you can rehearse or act



					endOfTurn = true;

				}
				
				
				
				
				
				
				
				// End of player turn
				players.add(active_player);
				System.out.println("~~~~~~~~~~~~ END OF TURN ~~~~~~~~~~~ \n");

				
				//check when only one scene left, exit if there is only one left
				if(gm.checkActive() == 1) {
					endDay = true;
				}
				
				
			}



			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// End of day

			// Remove all scenes cards (should only be one left)


			// Next day
			gm.decrementDay();
			endDay = false;
		}


    	//test scene and role classes
    	//Role[] rs = {new Role("one",1),new Role("two",2)};
    	//Scene s1 = new Scene("scene one",2,rs);
    	//s1.firstRoleInfo();

    }
    
}