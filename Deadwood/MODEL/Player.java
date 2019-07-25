package Deadwood.MODEL;

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
	private boolean upgraded;
	private boolean worked;
	private boolean tookRole;
	
	//constructor
	public Player(int player_num) {
	    this.player_num = player_num;
	    this.currency = new Currency(0,0);
	    this.rank = 1;
	    this.name = "NattyNAt";
	    this.rehearsal_chips = 0;
	    this.moved = false;
	    this.upgraded = false;
	    this.worked = false;
	    this.tookRole = false;
	}
	
	// Get the current player location
	public Location getLocation() {
		return location;
	}
	
	// Get player's rank
	public int getRank() {
		return rank;
	}
	
	// Set the player's rank
	public void setRank(int r) {
		this.rank = r;
	}
	
	// Set the current player location
	public void setLocation(Location l) {
		this.location = l;
	}

	// Get the players currency object
	public Currency getCurrency(){
		return currency;
	}

	public void removeRehearsalChips() {
		this.rehearsal_chips = 0;
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
	
	
	// Set the upgrade boolean
	public void setUpgraded(boolean s) {
		this.upgraded = s;
	}

	// Get the upgrade boolean
	public boolean getUpgraded(){
		return this.upgraded;
	}


	public boolean getWorked() {
		return this.worked;
	}

	public void setWorked(boolean worked) {
		this.worked = worked;
	}
	
	public boolean getTookRole() {
		return this.tookRole;
	}

	public void setTookRole(boolean tr) {
		this.tookRole = tr;;
	}
	
	// Player acting method
	public boolean playerAct(Die die) {

		// Roll the dice, compare the value to the budget of the movie
		int roll = die.roll();
		int budget = ((Set)(this.location)).getScene().getBudget();
		int total = roll + rehearsal_chips;

		// If the combined score was more than the budget, acting was a success
		return(total >= budget);

	}

	// Adds practice chips to the player for rehearsal option
	public void playerRehearse() throws RehearsalException{
		// If the player is not in a role, they cannot rehearse
		if (this.role == null) {
			throw new RehearsalException();
		}
		// If the player has too many practice chips, they cannot rehearse
		if (this.rehearsal_chips >= ((Set)(this.location)).getScene().getBudget()-1) {
			throw new RehearsalException();
		}

		// Otherwise we can add a rehearsal chip, also set the worked boolean
		this.rehearsal_chips+=1;
		this.worked = true;
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

	// Get the player role
	public Role getRole() {
		return role;
	}

	// Return player ID for every new turn
	public String playerInfo(){

		String playerRole;
		String RoleInfo;
		// Role check
		if (this.role == null) {
			playerRole = "No role";
			RoleInfo = "";
		}
		else {
			playerRole = this.role.getName();
			RoleInfo = role.getMainInfo();
		}

		String playerinfo = String.format("Player %d \n - Money: %d \n - Credits: %d \n - Rank: %d \n"
				+ " - Location: %s \n - Role: %s %s\n - Practice Chips: %d\n",
				this.player_num, this.currency.getDollar(), this.currency.getCredit(),
				this.rank, this.location.name, playerRole, RoleInfo,
				this.rehearsal_chips);
		return playerinfo;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getPlayer_num(){
		return this.player_num;
	}
}



