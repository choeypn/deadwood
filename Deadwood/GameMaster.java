package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - GAMEMASTER CLASS                               //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

import java.util.ArrayList;

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
	public void wrapSet(Set s){}

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

