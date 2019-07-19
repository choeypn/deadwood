package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - ROLE CLASS                                     //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Role {
	
	//fields
	private String name;
	private int rank;
	private boolean available;
	private boolean main;
	
	//constructor
	public Role(String starring, int rank) {
	    this.name = starring;
	    this.rank = rank;
	    this.available = true;
	    this.main = false;
	}
	
	public boolean getMain() {
		return main;
	}
	
	public void setMain(boolean s) {
		this.main = s;
	}
	
	// Get the name of the role
	public String getName() {
		return name;
	}

	// Get the rank of the role
	public int getRank() {
		return rank;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(boolean b) {
		available = b;
	}
	
}
