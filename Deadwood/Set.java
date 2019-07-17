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
    private Role[] extras = new Role[3];
    private int shotcounters;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    // Constructor
    public Set(String name){
        this.name = name;
    }

    public void addActivePlayer(Player player) {
    }

    public void addAdjLocation(Location location) {
    }

    public void placeScene(Scene scene){
        this.current_scene = scene;
    }

    public void removeScene(){}

    public void removeShotCounter(){}

    public void setShotcounters(int shotcounters){
        this.shotcounters = shotcounters;
    }

}
