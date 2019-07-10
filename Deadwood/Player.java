package Deadwood;

public class Player {
	//awaiting Location and Role classes
	
	//fields
	private int money;
	//private Location location;	
	//private Role role;
	private int rank;
	private int player_num;
	private String name;
	private int rehearsal_chips;
	
	//constructor
	public Player(int player_num) {
	    this.player_num = player_num;
	    
	}
	
	//method
	//public void playerMove(Location location) {}
	public void playerUpgrade(int rank) {}
	public void platerAct() {}
	public void playerRehearse() {}
	//public void playerTakeRole(Role r) {}
	public void playerRollDice(int dice) {}
}
