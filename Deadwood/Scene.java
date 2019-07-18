package Deadwood;

import java.util.ArrayList;
import java.util.Collection;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - SCENE CLASS                                    //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Scene {
	
	//fields
	private String name;
	private int budget;
	private Role[]_roles;
	private boolean flipped;
	
	//constructor
	public Scene(String name,int budget,Role[] starring){
	    this.name = name;
		this.budget = budget;
	    this._roles = starring;
	    this.flipped = false;
	}
	
	public String getRoleDetails() {
		String s = "| ";
		for(int i =0; i < _roles.length;i++) {
			s += _roles[i].getName()+" "+_roles[i].getRank()+" | ";
		}
		
		return s;
	}
	
	public Role getRole(int d) {
		return _roles[d];
	}
	
	public int getRoleSize() {
		return _roles.length;
	}
	
	// Get the budget of the role
	public int getBudget() {
		return budget;
	}
	
	// Get the first role info
	public void firstRoleInfo() {
		System.out.println(this._roles[0].getName());
		System.out.println(this._roles[0].getRank());
	}

	// Get the name of the scene
	public String getName(){
		return this.name;
	}
	
	public boolean getFlipped() {
		return flipped;
	}
	
	public void setFlipped(boolean b) {
		this.flipped = b;
	}
	
}
