package Deadwood.MODEL;
import java.util.*;

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
			System.out.println("Day : "+gm.getDayNum());
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// During the day

			// Players work in rotation - 1 - 3
			// Players operate in a loop - this loop runs until there is only once scene card left on the board
			while(!endDay) {

				// Player turn
				endOfTurn = false;
				active_player = players.get(0);
				System.out.println("Your turn");
				System.out.println(active_player.playerInfo());
				System.out.println("What would you like to do this turn?\n");

				// Players turn until they decide to end it
				while(!endOfTurn){

					// Players have options
					// 1) Move if not on a role, this can be paired with taking a role
					// 3) If you are located at the casting office, you can upgrade

					System.out.println("Options: \n a - act \n m - move \n r - rehearse \n"
							+ " u - upgrade \n t - take role \n i - player information \n e - end turn \n l - display player locations \n");

					// Get user input
					
					char input = prompter.next().charAt(0);
					prompter.reset();
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

								// Catch the movement case
								if(active_player.getMoved() == true) {
									System.out.println("You can not act this turn");
									break;
								}
								
								//Check if the player just took the role
								if(active_player.getTookRole() == true) {
									System.out.println("You just took a role in this turn");
									break;
								}
								
								// Act!
								boolean	success = active_player.playerAct(die);
								boolean main_role = active_player.getRole().getMain();
								Currency payout;

								// Success
								if (success) {
									System.out.println("Acting succeeded!!!");
									// If on a main role
									if (main_role) {
										System.out.println("You received 2 credits!");
										payout = new Currency(0, 2);
										
										
									} // If on off card role
									else {
										System.out.println("You received 1 dollar and 1 credit!");
										payout = new Currency(1, 1);
										
									}
									//remove one shot counter when succeeded
									gm.removeShotCounter((Set)active_player.getLocation());
									
									// If the last shot counter was removed, we use the GM for wrapping
									if(!((Set)active_player.getLocation()).getActive()) {
										System.out.println("Scene "+
									((Set)active_player.getLocation()).getScene().getName()+" finished!");
										System.out.println("It's a wrap!!");
										gm.wrapSet(((Set)active_player.getLocation()));
									}
								}

								// Failure
								else {
									System.out.println("Acting failed!!!");
									// If on a main role
									if (main_role) {
										System.out.println("You received nothing!");
										payout = new Currency(0, 0);
									} // If on off card role
									else {
										System.out.println("You received 1 dollar!");
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
							// If the player has already worked, they cannot move again
							if(active_player.getWorked()) {
								System.out.println("You just finished working");
								break;
							}


							// Movement location prompt
							System.out.println("Where would you like to move? (Enter a number 0-11)");
							System.out.println(" 0 - Trailers \n"
											 + " 1 - Casting Office \n"
											 + " 2 - Jail \n"
											 + " 3 - Train Station \n"
											 + " 4 - General Store \n"
											 + " 5 - Saloon \n"
											 + " 6 - Main Street \n"
											 + " 7 - Secret Hideout \n"
											 + " 8 - Ranch \n"
											 + " 9 - Bank \n"
											 + "10 - Church \n"
											 + "11 - Hotel");
							// If they try to move to the same location - maybe implement this later


							// Try to move - catch if invalid movement
							try {
								String locS = prompter.next();
								prompter.reset();
								int loc = Integer.parseInt(locS);
								String previousLoc = active_player.getLocation().getName();
								active_player.playerMove(gameboard.getLocation(loc));
								System.out.println("Player successfully moved from "+previousLoc+" to "
										+active_player.getLocation().getName());
								//flip the scene card up if location player entered is a Set location
								if(gameboard.getLocation(loc) instanceof Set) {
									((Set)gameboard.getLocation(loc)).getScene().setFlipped(true);
								}
								
							}
							catch(MovementException e){
								System.out.println("Invalid movement");
							}
							catch(NumberFormatException e) {
								System.out.println("Input is not an integer");
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index out of bound");
							}
							break;

						// Rehearse ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'r':
							
							if (active_player.getWorked() == true) {
								System.out.println("You have already worked this turn");
								break;
							}
							
							//Check if the player just took the role
							if(active_player.getTookRole() == true) {
								System.out.println("You just took a role in this turn");
								break;
							}
							
							// Try to rehearse, catch if the player is not allowed to rehearse
							try {
								active_player.playerRehearse();
								System.out.println("1 practice chip added");
							}
							catch (RehearsalException e){
								System.out.println("You cannot rehearse \n");
							}
							break;

						// Upgrade ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'u':
							//check if the player is at Casting Office
							if(active_player.getLocation() instanceof CastingOffice == false) {
								System.out.println("You are currently not at Casting Office");
								break;
							}
							//check if the player already upgraded in his turn 
							if(active_player.getUpgraded() == true) {
								System.out.println("You already upgraded this round");
								break;
							}
							//Display upgrade information
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
							
							//verify and upgrade player's rank 
							try {
								String input_rank = prompter.next();
								prompter.reset();
								char r2 = input_rank.charAt(1);
								int r1 = Character.getNumericValue(input_rank.charAt(0));
								gm.upgradePlayer(active_player,r2,r1);
							}
							catch(UpgradeException e) {
								System.out.println("Rank upgrade failed, new rank unassignned");
							}
							catch(NumberFormatException e) {
								System.out.println("Input is not an integer");
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index out of bound");
							}
							catch(StringIndexOutOfBoundsException e) {
								System.out.println("Invalid input");
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
								// If the scene is not active, we can't take a role there
								if (!((Set)active_player.getLocation()).getActive()) {
									System.out.println("This scene has wrapped");
									break;
								}
								// Display current scene information
								System.out.printf("Active scene : %s, Budget : %d \n",
										((Set)active_player.getLocation()).getScene().getName(),
										((Set)active_player.getLocation()).getScene().getBudget());
								System.out.println("Player chose to take role");
								System.out.printf("Here are the main roles :  %s \n",
										((Set)active_player.getLocation()).getScene().getRoleDetails());
								System.out.printf("Here are the side roles :  %s \n",
										((Set)active_player.getLocation()).getExtraDetails());
								System.out.println("Enter x# for extra roles or m# for main roles");
								//get user's input
								String input_role = prompter.next();
								char c1 = input_role.charAt(0);
								int c2 = Character.getNumericValue(input_role.charAt(1));
								prompter.reset();
								//verify and assign role to player 
								active_player.playerTakeRole(c1,c2);
								System.out.println("Role "+active_player.getRole().getName()+" assigned!");
								active_player.setTookRole(true);
							}
							catch(RoleException e) {
								System.out.println("Invalid input, role not assigned");
							}
							catch(ClassCastException e) {
								System.out.println("You are currently not in a Set location");
							}
							catch(StringIndexOutOfBoundsException e) {
								System.out.println("Invalid input, role not assigned");
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Invalid input, role not assigned");
							}
							break;
						
						case 'i':
							System.out.println(active_player.playerInfo());
							break;
						
						// End turn ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'e':
							endOfTurn=true;
							break;

						// Print player locations ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						case 'l':
							for (int i = 0; i < players.size(); i++) {
								System.out.printf("Player %d -  %s \n", players.get(i).getPlayer_num() ,players.get(i).getLocation().getName());
							}
							break;
					}

				}

				
				// End of player turn
				active_player.setMoved(false);
				active_player.setUpgraded(false);
				active_player.setWorked(false);
				active_player.setTookRole(false);
				players.remove(0);
				players.add(active_player);
				System.out.println("~~~~~~~~~~~~ END OF TURN ~~~~~~~~~~~ \n");

				
				//check when only one scene left, exit if there is only one left
				if(gm.checkActive() == 1) {
					endDay = true;
				}


			}

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// End of day
			System.out.println("Day "+gm.getDayNum()+" has ended!!");
			// Remove all scenes cards (should only be one left)
			gm.endDay();

			// Next day
			gm.decrementDay();
			endDay = false;
		}
		prompter.close();
		// END OF GAME! ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		int[] scores = gm.endGame();

		// Iterate through the players and print scores
		for (int i = 0; i < players.size(); i++) {
			System.out.printf("Player %d - Score %d \n", players.get(i).getPlayer_num(), scores[i]);
		}

	}
    
}