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

    // Get the set status
    public boolean getActive() {
    	return active;
    }
    
    // Set the set status
    public void setActive(boolean s) {
    	this.active = s;
    }
    
    public String getExtraDetails() {
		String s = "| ";
		for(int i =0; i < extras.length;i++) {
			s += extras[i].getName()+" "+extras[i].getRank()+" | ";
		}
		
		return s;
	}
    
    public Role getExtra(int d) {
    	return extras[d];
    }
    
    public int getExtraSize() {
    	return extras.length;
    }
    
    // Add extras to the set
    public void addExtras(Role[] r) {
    	this.extras = r;
    }

    
    // Get the scene
    public Scene getScene() {
    	return current_scene;
    }
    
    // Place the scene
    public void placeScene(Scene scene){
        this.current_scene = scene;
    }

    // Remove shot counters
    public void removeShotCounter(){
    	this.shotcounters--;

    	// If there are no shot counters left on a scene, set the active status to false
    	if(shotcounters == 0) {
    		this.active = false;
    	}
    	
    }

    // Set the shot counters
    public void setShotcounters(int shotcounters){
        this.shotcounters = shotcounters;
    }

}
