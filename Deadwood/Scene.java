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
	}
	
	//accessor & mutator 
	public int getBudget() {
		return budget;
	}
	
	public void firstRoleInfo() {
		System.out.println(this._roles[0].getName());
		System.out.println(this._roles[0].getRank());
	}
}
