package Deadwood;
import java.util.ArrayList;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - BOARD CLASS                                    //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

public class Board {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Fields
    private ArrayList<Scene> scene_deck = new ArrayList<Scene>(40);
    private Location[] locations = new Location[12];
    private int[][] board_tiles = new int[2][2];

    private final int num_locations = 12;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods

    // Constructor
    public Board() {

        // Create all the locations and set adjacent locations as well
        locations[0] = new Trailers("Trailers");
        locations[1] = new CastingOffice("Casting Office");
        locations[2] = new Set("Jail");
        locations[3] = new Set("Train Station");
        locations[4] = new Set("General Store");
        locations[5] = new Set("Saloon");
        locations[6] = new Set("Main Street");
        locations[7] = new Set("Secret Hideout");
        locations[8] = new Set("Ranch");
        locations[9] = new Set("Bank");
        locations[10] = new Set("Church");
        locations[11] = new Set("Hotel");

        // Set adjacent locations

        // ~~~ Trailers
        locations[0].addAdjLocation(locations[5]);
        locations[0].addAdjLocation(locations[6]);
        locations[0].addAdjLocation(locations[11]);

        // ~~~ Casting Office
        locations[1].addAdjLocation(locations[3]);
        locations[1].addAdjLocation(locations[8]);
        locations[1].addAdjLocation(locations[7]);

        // ~~~ Jail
        locations[2].addAdjLocation(locations[3]);
        locations[2].addAdjLocation(locations[4]);
        locations[2].addAdjLocation(locations[6]);

        // ~~~ Train Station
        locations[3].addAdjLocation(locations[2]);
        locations[3].addAdjLocation(locations[4]);
        locations[3].addAdjLocation(locations[1]);

        // ~~~ General Store
        locations[4].addAdjLocation(locations[3]);
        locations[4].addAdjLocation(locations[2]);
        locations[4].addAdjLocation(locations[5]);
        locations[4].addAdjLocation(locations[8]);

        // ~~~ Saloon
        locations[5].addAdjLocation(locations[9]);
        locations[5].addAdjLocation(locations[0]);
        locations[5].addAdjLocation(locations[6]);
        locations[5].addAdjLocation(locations[4]);

        // ~~~ Main Street
        locations[6].addAdjLocation(locations[0]);
        locations[6].addAdjLocation(locations[2]);
        locations[6].addAdjLocation(locations[5]);

        // ~~~ Secret Hideout
        locations[7].addAdjLocation(locations[1]);
        locations[7].addAdjLocation(locations[8]);
        locations[7].addAdjLocation(locations[10]);

        // ~~~ Ranch
        locations[8].addAdjLocation(locations[1]);
        locations[8].addAdjLocation(locations[7]);
        locations[8].addAdjLocation(locations[9]);
        locations[8].addAdjLocation(locations[4]);

        // ~~~ Bank
        locations[9].addAdjLocation(locations[8]);
        locations[9].addAdjLocation(locations[11]);
        locations[9].addAdjLocation(locations[5]);
        locations[9].addAdjLocation(locations[10]);

        // ~~~ Church
        locations[10].addAdjLocation(locations[7]);
        locations[10].addAdjLocation(locations[9]);
        locations[10].addAdjLocation(locations[11]);

        // ~~~ Hotel
        locations[11].addAdjLocation(locations[9]);
        locations[11].addAdjLocation(locations[10]);
        locations[11].addAdjLocation(locations[0]);

        // Create Scenes/Roles

        // Create scene

        // Create roles

        // Attach scene to deck

        // Repeat 40 times

    }

}
