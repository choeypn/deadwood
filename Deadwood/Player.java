package Deadwood;

public class Player {
	//awaiting Location and Role classes
	
	//fields
	private Currency currency;
	private Location location;	
	private Role role;
	private int rank;
	private int player_num;
	private String name;
	private int rehearsal_chips;
	
	//constructor
	public Player(int player_num) {
	    this.player_num = player_num;
	    this.currency = new Currency(2,3);
	    this.rank = 1;
	    this.name = "NattyNAt";
	    this.rehearsal_chips = 0;
	}

	public void setLocation(Location l) {
		this.location = l;
	}
	
	
	public void getInfo() {
		System.out.println("yo name (the movie) : "+this.name);
		System.out.println("yo play_num : "+this.player_num);
		System.out.println("yo dolla : "+this.currency.getDollar());
		System.out.println("yo curren : "+this.currency.getCredit());
		System.out.println("yo rank : "+this.rank);
	}
	
	
	//method
	//public void playerMove(Location location) {}
	public void playerUpgrade(int rank) {}
	public void platerAct() {}
	public void playerRehearse() {}
	//public void playerTakeRole(Role r) {}
	public void playerRollDice(int dice) {}

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

		String playerinfo = String.format("Your turn player %d \n - Money: %d \n - Credits: %d \n - Rank: %d \n - Location: %s \n - Role: %s",
				this.player_num, this.currency.getDollar(), this.currency.getCredit(), this.rank, this.location.name, playerRole);
		return playerinfo;
	}
}
