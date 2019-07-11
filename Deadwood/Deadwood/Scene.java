package Deadwood;

public class Scene {
	
	//fields
	private int budget;
	private Role[] starring_roles;
	private boolean flipped;
	
	//constructor
	public Scene(int budget,Role[] starring){
	    this.budget = budget;
	    this.starring_roles = starring;
	}
}
