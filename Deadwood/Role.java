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
	
	//constructor
	public Role(String starring, int rank) {
	    this.name = starring;
	    this.rank = rank;
	    this.available = true;
	}
	
	
	//accessor & mutator
	public String getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
	
}
