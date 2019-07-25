package Deadwood;
import java.util.ArrayList;
import java.util.Collections;

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

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    //get location name;
    public String getName() {
    	return this.name;
    }
    
    // Add an adjacent location
    public void addAdjLocation(Location location) {
        adj_locations.add(location);
    }

}
