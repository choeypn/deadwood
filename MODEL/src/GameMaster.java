package MODEL.src;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - GAMEMASTER CLASS                               //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GameMaster {
	
	private int game_days;
	private int totalDays;
	private Board game_board;
	ArrayList<Player> players;

	// Constructor
	public GameMaster(int day, Board b, ArrayList<Player> players) {
		this.game_days = day;
		this.totalDays = day;
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

	// Pay the player
	public void payPlayer(Player p, Currency c) {
		p.getCurrency().addCredit(c.getCredit());
		p.getCurrency().addDollar(c.getDollar());
	}

	// Ending the day sequence
	public void endDay() {
		
		//Remove Everyone's role and chips at the end of the day
		for(int j = 0;j < players.size();j++) {
			players.get(j).setRole(null);
			players.get(j).removeRehearsalChips();
		}

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

	}

	// End of game scoring
	public int[] endGame() {

		// Create hashmap for scores
		int[] scores = new int[players.size()];

		// Calculate scores
		for (int i = 0; i < players.size(); i++) {
			int dollar_score = players.get(i).getCurrency().getDollar();
			int credit_score = players.get(i).getCurrency().getCredit();
			int rank_score = players.get(i).getRank() * 5;

			scores[i] = dollar_score + credit_score + rank_score;
		}

		return scores;
	}
	
	// Method for wrapping the set
	public void wrapSet(Set s){
		// On card and off card roles
		ArrayList<Player> on_card = new ArrayList<Player>();
		ArrayList<Player> off_card = new ArrayList<Player>();

		// Check where players are
		for(int i = 0; i < players.size(); i++) {

			// Check if player is on the set being wrapped
			if (players.get(i).getLocation().getName().equals(s.getName())) {

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
		// Also remove every player's role in the scene
		if(on_card.size() == 0) {
			// Remove player's role after wrapup
			for(int k = 0;k < off_card.size();k++) {
				removePlayerRole(off_card.get(k));
				removePracticeChips(off_card.get(k));
			}
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
				String playRole = on_card.get(j).getRole().getName();
				String paidRole = s.getScene().getRole(i).getName();
				if (playRole.equals(paidRole)){

					// Pay the player
					Currency c = new Currency(totals[i], 0);
					payPlayer(on_card.get(j), c);
					break;
				}

				
			}
		}
		// Remove player's role after wrapup
		for(int k = 0;k < on_card.size();k++) {
			removePlayerRole(on_card.get(k));
			removePracticeChips(on_card.get(k));
		}

		// Off card payment
		for (int j = 0; j < off_card.size(); j++) {
			int dollars = off_card.get(j).getRole().getRank();
			Currency c = new Currency(dollars, 0);
			payPlayer(off_card.get(j), c);
			removePlayerRole(off_card.get(j));
			removePracticeChips(off_card.get(j));
		}
		

	}
	
	// Remove Player's practice chips
	public void removePracticeChips(Player p) {
		p.removeRehearsalChips();
	}
	
	// Remove Player Method
	public void removePlayerRole(Player p) {
		p.setRole(null);
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
	}
	
	public void removeShotCounter(Set s) {
		s.removeShotCounter();
	}

	// Decrement day
	public void decrementDay(){
		this.game_days -= 1;
	}

	//Get day number
	public int getDayNum() {
		return (totalDays +1) - game_days;
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

