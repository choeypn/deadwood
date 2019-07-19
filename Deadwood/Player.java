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
	    this.currency = new Currency(10,10);
	    this.rank = 1;
	    this.name = "NattyNAt";
	    this.rehearsal_chips = 0;
	    this.moved = false;
	}
	
	// Get the current player location
	public Location getLocation() {
		return location;
	}
	
	// Get player's rank
	public int getRank() {
		return rank;
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

	//Upgrade player from input payment type and input rank number
	public void playerUpgrade(char type,int rank) throws UpgradeException{
		//handle user's input payment type
				switch(type){
					case('d'):
						if(currency.getDollar() < Constants.RD[rank-2]){
							throw new UpgradeException();
						}
						if(this.rank >= rank) {
							throw new UpgradeException();
						}
						this.rank = rank;
						currency.removeDollar(Constants.RD[rank-2]);
						break;
					case('c'):
						if(currency.getCredit() < Constants.RC[rank-2]){
							throw new UpgradeException();
						}
						if(this.rank >= rank) {
							throw new UpgradeException();
						}
						this.rank = rank;
						currency.removeCredit(Constants.RD[rank-2]);
						break;
					default:
						throw new UpgradeException();
						
				}
	}
	
	public void playerAct() {}
	// Adds practice chips to the player for rehearsal option
	public void playerRehearse() throws RehearsalException{
		// If the player is not in a role, they cannot rehearse
		if (this.role == null) {
			throw new RehearsalException();
		}
		// If the player has too many practice chips, they cannot rehearse
		if (this.rehearsal_chips > ((Set)(this.location)).getScene().getBudget()-1) {
			throw new RehearsalException();
		}
	}
	// Assigns player desired role to player if player passed all requirements
	// Set role availability to false when occupied
	public void playerTakeRole(char type,int idx) throws RoleException{
		//handle user's input role type
		switch(type){
			case('m'):
				if(idx > ((Set)location).getScene().getRoleSize()) {
					throw new RoleException();
				}
				if(((Set)location).getScene().getRole(idx).getAvailable() == false) {
					throw new RoleException();
				}
				if(rank < ((Set)location).getScene().getRole(idx).getRank()) {
					throw new RoleException();
				}
				this.role = ((Set)location).getScene().getRole(idx);
				role.setAvailable(false);
				break;
			case('x'):
				if(idx > ((Set)location).getExtraSize()) {
					throw new RoleException();
				}
				if(((Set)location).getExtra(idx).getAvailable() == false) {
					throw new RoleException();
				}
				if(rank < ((Set)location).getExtra(idx).getRank()) {
					throw new RoleException();
				}
				this.role = ((Set)location).getExtra(idx);
				role.setAvailable(false);
				break;
			default:
				throw new RoleException();
				
		}
	}
	
	
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
