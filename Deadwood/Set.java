package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - SET CLASS                                      //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Set extends Location{


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Fields
    private Scene current_scene;
    private Role[] extras;
    private int shotcounters;
    private boolean active;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    // Constructor
    public Set(String name){
        this.name = name;
        this.active = false;
    }

    public boolean getActive() {
    	return active;
    }
    
    
    public void setActive(boolean s) {
    	this.active = s;
    }
    
    public void addActivePlayer(Player player) {
    }

    public void addAdjLocation(Location location) {
    }

    public void placeScene(Scene scene){
        this.current_scene = scene;
    }

    public void removeScene(){}

    public void removeShotCounter(){
    	this.shotcounters--;
    	if(shotcounters == 0) {
    		this.active = false;
    	}
    	
    }

    public void setShotcounters(int shotcounters){
        this.shotcounters = shotcounters;
    }

}
