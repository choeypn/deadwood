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
	
	public GameMaster(int day, Board b, ArrayList<Player> players) {
		this.game_days = day;
		this.game_board = b;
		this.players = players;
	}
	
	//methods
	public void upgradePlayer(Player p) {}
	//public void gameInit(Player[] ps) {}
	public void payPlayer(Player p) {}
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

		}

		// Move all the players to the trailers
		for (int i = 0; i < players.size(); i++){
			players.get(i).setLocation(game_board.getLocation(Constants.TRAILERS));
		}

	}


	public void decrementDay(){
		this.game_days -= 1;
	}

	public int getGame_days(){
		return this.game_days;
	}

}

