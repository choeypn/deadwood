package MODEL.src;

import java.util.ArrayList;
import java.util.Collection;
import CONTROLLER.src.*;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - SCENE CLASS                                    //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Scene {

	private Controller observer;

	//fields
	private String name;
	private int budget;
	private Role[]_roles;
	private boolean flipped;
	private int number;
	
	//constructor
	public Scene(String name,int budget,Role[] starring,int num){
	    this.name = name;
		this.budget = budget;
	    this._roles = starring;
	    this.flipped = false;
	    this.number = num;
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

	public int getNum() {
		return this.number;
	}
	
}
