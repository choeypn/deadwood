package MODEL.src;

import java.util.ArrayList;
import java.util.Collections;
import CONTROLLER.src.*;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - LOCATION CLASS                                 //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public abstract class Location {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Fields
    protected ArrayList<Player> active_players = new ArrayList<Player>(8);
    protected ArrayList<Location> adj_locations = new ArrayList<Location>();
    protected String name;
    private Controller observer;
    protected int locNum;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    //get location name;
    public String getName() {
    	return this.name;
    }
    
    //get location number;
    public int getlocNum() {
    	return this.locNum;
    }
    
    // Add an adjacent location
    public void addAdjLocation(Location location) {
        adj_locations.add(location);
    }

}
