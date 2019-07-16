package Deadwood;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - TRAILERS CLASS                                 //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Trailers extends Location {

    private String name;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    // Constructor
    public Trailers(String name){
        this.name = name;
    }

    public void addActivePlayer(Player player) {
    }

    public void addAdjLocation(Location location) {
    }

    // Getters and setters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
