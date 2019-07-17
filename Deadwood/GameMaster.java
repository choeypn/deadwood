package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - GAMEMASTER CLASS                               //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class GameMaster {
	
	//fields
	private int shot_counters;
	private int game_days;
	private Board game_board;
	
	public GameMaster(int day, Board b) {
		this.game_days = day;
		this.game_board = b;
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
		// Set the scene cards (10 face down on board)

		for (int i = 2; i <=11; i++){
			((Set)game_board.getLocation(i)).placeScene(game_board.drawScene());
		}


		// Reset shot counters on scenes



	}


	public void decrementDay(){
		this.game_days -= 1;
	}

	public int getGame_days(){
		return this.game_days;
	}

}

