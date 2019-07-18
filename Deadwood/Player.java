package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - PLAYER CLASS                                   //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Player {

	
	//fields
	private Currency currency;
	private Location location;	
	private Role role;
	private int rank;
	private int player_num;
	private String name;
	private int rehearsal_chips;
	private boolean moved;
	
	//constructor
	public Player(int player_num) {
	    this.player_num = player_num;
	    this.currency = new Currency(2,3);
	    this.rank = 1;
	    this.name = "NattyNAt";
	    this.rehearsal_chips = 0;
	    this.moved = false;
	}

	// Set the current player location
	public void setLocation(Location l) {
		this.location = l;
	}
	
	// Get player info (debugging)
	public void getInfo() {
		System.out.println("yo name (the movie) : "+this.name);
		System.out.println("yo play_num : "+this.player_num);
		System.out.println("yo dolla : "+this.currency.getDollar());
		System.out.println("yo curren : "+this.currency.getCredit());
		System.out.println("yo rank : "+this.rank);
	}

	// Move the player if the choice was valid, otherwise throw an exception
	public void playerMove(Location location) throws MovementException {

		// Move if the location is adjacent and not already moved
		if (this.location.adj_locations.contains(location)){
			this.location = location;
			this.moved = true;
		}
		// Otherwise, throw a movement exception
		else{
			throw new MovementException();
		}
	}

	// Set the movement boolean
	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	// Get the movement boolean
	public boolean getMoved(){
		return this.moved;
	}

	public void playerUpgrade(int rank) {}
	public void playerAct() {}
	public void playerRehearse() {}
	public void playerTakeRole(Role r) {}
	public void playerRollDice(int dice) {}

	// Get the player role
	public Role getRole() {
		return role;
	}

	// Return player ID for every new turn
	public String playerInfo(){

		String playerRole;
		// Role check
		if (this.role == null) {
			playerRole = "No role";
		}
		else {
			playerRole = this.role.getName();
		}

		String playerinfo = String.format("Your turn player %d \n - Money: %d \n - Credits: %d \n - Rank: %d \n - Location: %s \n - Role: %s\n",
				this.player_num, this.currency.getDollar(), this.currency.getCredit(), this.rank, this.location.name, playerRole);
		return playerinfo;
	}
}
