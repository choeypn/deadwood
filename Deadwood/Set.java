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
    
    public void addExtras(Role[] r) {
    	this.extras = r;
    }
    
    public void addActivePlayer(Player player) {
    }


    public void placeScene(Scene scene){
        this.current_scene = scene;
    }

    public void removeScene(){}


    public void removeShotCounter(){
    	this.shotcounters--;

    	// If there are no shot counters left on a scene, set the active status to false
    	if(shotcounters == 0) {
    		this.active = false;
    	}
    	
    }

    public void setShotcounters(int shotcounters){
        this.shotcounters = shotcounters;
    }

}
