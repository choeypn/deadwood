package Deadwood;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
		
		Die die = Die.getD();
		System.out.println(die.roll());
		System.out.println(die.roll());
		System.out.println(die.roll());
		System.out.println(die.roll());
		System.out.println(die.roll());
		System.out.println(die.roll());

		// User input tool
		Scanner prompter = new Scanner(System.in);





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
				endOfTurn = false;
				active_player = players.remove(0);
				System.out.println(active_player.playerInfo());
				System.out.println("What would you like to do this turn?\n");

				// Players turn until they decide to end it
				while(!endOfTurn){

					// Players have options
					// 1) Move if not on a role, this can be paired with taking a role
					// 3) If you are located at the casting office, you can upgrade

					System.out.println("Options: \n a - act \n m - move \n r - rehearse \n u - upgrade \n t - take role \n e - end turn \n");

					// Get user input
					char input = prompter.next().charAt(0);
					switch (input) {

						// Act ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'a':

								// Check if the player has a role
								if (active_player.getRole() == null) {
									System.out.println("You have no role, you can not act");
									break;
								}

								// If the player has already worked or rehearsed, they cannot act
								if(active_player.getWorked()) {
									System.out.println("You have already worked - can not act");
									break;
								}

								// Act!
								boolean	success = active_player.playerAct(die);
								boolean main_role = active_player.getRole().getMain();
								Currency payout;

								// Success
								if (success) {

									// If on a main role
									if (main_role) {
										payout = new Currency(0, 2);
									} // If on off card role
									else {
										payout = new Currency(1, 1);
									}
								}

								// Failure
								else {
									// If on a main role
									if (main_role) {
										payout = new Currency(0, 0);
									} // If on off card role
									else {
										payout = new Currency(1, 0);
									}
								}

								// Player payout
								gm.payPlayer(active_player, payout);
								active_player.setWorked(true);
								break;

						// Move ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'm':
							if(active_player.getRole() != null) {
								System.out.println("You are currently working in a role");
								break;
							}
							// If the player has already moved, they cannot move again
							if(active_player.getMoved()) {
								System.out.println("You cannot move again this turn");
								break;
							}



							// Movement location prompt
							System.out.println("Where would you like to move? (Enter a number 0-11)");
							int loc = prompter.nextInt();

							// If they try to move to the same location - maybe implement this later


							// Try to move - catch if invalid movement
							try {
								active_player.playerMove(gameboard.getLocation(loc));
								System.out.println("Player successfully moved");
								//flip the scene card up if location player entered is a Set location
								if(gameboard.getLocation(loc) instanceof Set) {
									((Set)gameboard.getLocation(loc)).getScene().setFlipped(true);
								}
							}
							catch(MovementException e){
								System.out.println("Invalid movement \n");
							}
							break;

						// Rehearse ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'r':
							// Try to rehearse, catch if the player is not allowed to rehearse
							try {
								active_player.playerRehearse();
							}
							catch (RehearsalException e){
								System.out.println("You cannot rehearse \n");
							}
							break;

						// Upgrade ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'u':
							if(active_player.getLocation() instanceof CastingOffice == false) {
								System.out.println("You are currently not at Casting Office");
								break;
							}
							if(active_player.getUpgraded() == true) {
								System.out.println("You already upgraded this round");
								break;
							}
							System.out.println("The cost to upgrade is shown below:");

							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("Pay dollars OR credits to upgrade");
							System.out.println("Rank 2 : Dollars  4, Credits  5");
							System.out.println("Rank 3 : Dollars 10, Credits 10");
							System.out.println("Rank 4 : Dollars 18, Credits 15");
							System.out.println("Rank 5 : Dollars 28, Credits 20");
							System.out.println("Rank 6 : Dollars 40, Credits 25");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

							System.out.println("Enter #d for rank with Dollar payment method");
							System.out.println("Enter #c for rank with Crredit payment method");
							String input_rank = prompter.next();
							char r2 = input_rank.charAt(1);
							int r1 = Character.getNumericValue(input_rank.charAt(0));
							try {
								gm.upgradePlayer(active_player,r2,r1);
							}
							catch(UpgradeException e) {
								System.out.println("Rank upgrade failed, new rank unassignned");
							}
							break;

						// Take role ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 't':
							//If player already has a role, player cannot take another role
							if(active_player.getRole() != null) {
								System.out.println("You cannot have more than one role");
								break;
							}
							//Check if player is in a working Set location
							try {
								System.out.printf("Active scene : %s, Budget : %d \n",
										((Set)active_player.getLocation()).getScene().getName(),
										((Set)active_player.getLocation()).getScene().getBudget());
								System.out.println("Player chose to take role");
								System.out.printf("Here are the main roles :  %s \n",
										((Set)active_player.getLocation()).getScene().getRoleDetails());
								System.out.printf("Here are the side roles :  %s \n",
										((Set)active_player.getLocation()).getExtraDetails());
								System.out.println("Enter x# for extra roles or m# for main roles");
								String input_role = prompter.next();
								char c1 = input_role.charAt(0);
								int c2 = Character.getNumericValue(input_role.charAt(1));
								try {
									active_player.playerTakeRole(c1,c2);
									System.out.println("Role "+active_player.getRole().getName()+" assigned!");
								}
								catch(RoleException e) {
									System.out.println("Invalid Role, role not assigned");
								}
							}
							catch(ClassCastException e) {
								System.out.println("You are currently not in a Set location");
							}

							break;

						// End turn ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'e':
							endOfTurn=true;
							break;
					}


					//if(active_player.getRole() == null) {

					//}


					// 2) If you are on a role, you can rehearse or act

				}

				
				// End of player turn
				active_player.setMoved(false);
				active_player.setUpgraded(false);
				active_player.setWorked(false);
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