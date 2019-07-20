package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - GAMEMASTER CLASS                               //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

import java.util.ArrayList;
import java.util.Collections;

public class GameMaster {
	
	//fields
	private int shot_counters;
	private int game_days;
	private Board game_board;
	ArrayList<Player> players;
	private int activeSets;

	// Constructor
	public GameMaster(int day, Board b, ArrayList<Player> players) {
		this.game_days = day;
		this.game_board = b;
		this.players = players;
	}
	
	//methods
	public void upgradePlayer(Player p,char type,int rank) throws UpgradeException{
		//handle user's input payment type
		switch(type){
			case('d'):
				if(p.getCurrency().getDollar() < Constants.RD[rank-2]){
					throw new UpgradeException();
				}
				if(p.getRank() >= rank) {
					throw new UpgradeException();
				}
				p.setRank(rank);
				p.getCurrency().removeDollar(Constants.RD[rank-2]);
				p.setUpgraded(true);
				break;
			case('c'):
				if(p.getCurrency().getCredit() < Constants.RD[rank-2]){
					throw new UpgradeException();
				}
				if(p.getRank() >= rank) {
					throw new UpgradeException();
				}
				p.setRank(rank);
				p.getCurrency().removeCredit(Constants.RD[rank-2]);
				p.setUpgraded(true);
				break;
			default:
				throw new UpgradeException();
				
		}
	}
	//public void gameInit(Player[] ps) {}

	// Pay the player
	public void payPlayer(Player p, Currency c) {
		p.getCurrency().addCredit(c.getCredit());
		p.getCurrency().addDollar(c.getDollar());
	}

	public void endDay(Player[] ps) {}
	public void endGame(Player[] ps) {}
	
	// Method for wrapping the set
	public void wrapSet(Set s){

		// On card and off card roles
		ArrayList<Player> on_card = new ArrayList<Player>();
		ArrayList<Player> off_card = new ArrayList<Player>();

		// Check where players are
		for(int i = 0; i < players.size(); i++) {

			// Check if player is on the set being wrapped
			if (((Set)(players.get(i).getLocation())) == s) {

				// check if they are a main role - add to on card
				if (players.get(i).getRole().getMain()) {
					on_card.add(players.get(i));
				}
				// Extra, add to off card
				else {
					off_card.add(players.get(i));
				}
			}
		}

		// Check if there were no on card players
		if(on_card.size() == 0) {
			return;
		}

		// Payout to players at this set
		Die d = Die.getD();
		int budget = s.getScene().getBudget();
		int num_oncard_roles = s.getScene().getRoleSize();

		// Dice rolls
		ArrayList<Integer> dice_roll = new ArrayList<Integer>();
		for (int i = 0; i < budget; i++) {
			dice_roll.add(d.roll());
		}

		// Sort the array list (highest to lowest)
		Collections.sort(dice_roll);

		// Create the total array
		int[] totals = new int[num_oncard_roles];

		// Calculate totals
		int roll = 0;
		for (int i = 0; i < budget; i++) {
			roll = dice_roll.remove(0);
			totals[i%num_oncard_roles] += roll;
		}

		// Find all on card roles
		for(int i = 0; i < s.getScene().getRoleSize(); i++) {

			// Is the player on this role?
			for (int j = 0; j < on_card.size(); j++) {
				// Yes
				if (on_card.get(j).getRole() == s.getScene().getRole(i)) {

					// Pay the player
					Currency c = new Currency(totals[i], 0);
					payPlayer(on_card.get(j), c);
				}

				on_card.get(j).setRole(null);
			}
		}

		// Ofd card payment
		for (int j = 0; j < off_card.size(); j++) {
			int dollars = off_card.get(j).getRank();
			Currency c = new Currency(dollars, 0);
			payPlayer(off_card.get(j), c);
			off_card.get(j).setRole(null);
		}
	}

	// Starting day method
	public void startDay(){

		// Beginning of day - GAME-MASTER controller
		for (int i = 2; i <=11; i++){

			// Set the scene cards (10 face down on board)
			((Set)game_board.getLocation(i)).placeScene(game_board.drawScene());

			// Reset shot counters on scenes
			((Set)game_board.getLocation(i)).setShotcounters(game_board.getSetShotCounters(i));
			
			// Set all set to active
			((Set)game_board.getLocation(i)).setActive(true);
			
		}

		// Move all the players to the trailers
		for (int i = 0; i < players.size(); i++){
			players.get(i).setLocation(game_board.getLocation(Constants.TRAILERS));
		}
		
		activeSets = 10;
	}
	
	public void removeShotCounter(Set s) {
		s.removeShotCounter();
	}
	
	
	
	// Decrement active sets
	public void decrementActive() {
		activeSets--;
	}

	// Decrement day
	public void decrementDay(){
		this.game_days -= 1;
	}

	// Get the number of game days left
	public int getGame_days(){
		return this.game_days;
	}

	// Check how many active scenes there are on the board
	public int checkActive() {
		int total = 0;
		for(int i = 2; i <= 11;i++) {
			if(((Set)game_board.getLocation(i)).getActive()) {
				total++;
			}
		}
		
		return total;
	}
}

