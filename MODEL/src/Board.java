import java.util.ArrayList;
import java.util.Collections;


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
    private final int[] shotcounters = {0, 0, 1, 3, 2, 2, 3, 3, 2, 1, 2, 3};

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Methods
    
    // Constructor
    public Board() {

        // Create all the locations and set adjacent locations as well
        locations[Constants.TRAILERS] = new Trailers("Trailers");
        locations[Constants.CASTING] = new CastingOffice("Casting Office");
        locations[Constants.JAIL] = new Set("Jail");
        locations[Constants.TRAIN] = new Set("Train Station");
        locations[Constants.GENERAL] = new Set("General Store");
        locations[Constants.SALOON] = new Set("Saloon");
        locations[Constants.MAIN] = new Set("Main Street");
        locations[Constants.SECRET] = new Set("Secret Hideout");
        locations[Constants.RANCH] = new Set("Ranch");
        locations[Constants.BANK] = new Set("Bank");
        locations[Constants.CHURCH] = new Set("Church");
        locations[Constants.HOTEL] = new Set("Hotel");

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
        
        //Create extra roles
        Role[] exr2 = {new Role("Prisoner in Cell",2),new Role("Feller in Irons",3)};
        Role[] exr3 = {new Role("Crusty Prospector",1),new Role("Dragged by Train",1),
        		new Role("Preacher with Bag",2),new Role("Cyrus the Gunfighter",4)};
        Role[] exr4 = {new Role("Man in Overalls",1),new Role("Mister Keach",3)};
        Role[] exr5 = {new Role("Woman in Red Dress",2),new Role("Reluctant Farmer",1)};
        Role[] exr6 = {new Role("Railroad Worker",1),new Role("Woman in Black Dress",2),
        		new Role("Falls off Roof",2),new Role("Mayor McGinty",4)};
        Role[] exr7 = {new Role("Clumsy Pit Fighter",1),new Role("Dangerous Tom",3),
        		new Role("Thug with Knife",2),new Role("Penny, who is Lost",4)};
        Role[] exr8 = {new Role("Shot in Leg",1),new Role("Man Under Horse",3),
        		new Role("Saucy Fred",2)};
        Role[] exr9 = {new Role("Flustered Teller",3),new Role("Suspicious Gentleman",2)};
        Role[] exr10 = {new Role("Dead Man",1),new Role("Crying Woman",2)};
        Role[] exr11 = {new Role("Faro Player",1),new Role("Australian Bartender",3),
        		new Role("Sleeping Drunkard",1),new Role("Falls from Balcony",2)};
        
        //Add extra roles to set locations
        ((Set)locations[Constants.JAIL]).addExtras(exr2);
        ((Set)locations[Constants.TRAIN]).addExtras(exr3);
        ((Set)locations[Constants.GENERAL]).addExtras(exr4);
        ((Set)locations[Constants.SALOON]).addExtras(exr5);
        ((Set)locations[Constants.MAIN]).addExtras(exr6);
        ((Set)locations[Constants.SECRET]).addExtras(exr7);
        ((Set)locations[Constants.RANCH]).addExtras(exr8);
        ((Set)locations[Constants.BANK]).addExtras(exr9);
        ((Set)locations[Constants.CHURCH]).addExtras(exr10);
        ((Set)locations[Constants.HOTEL]).addExtras(exr11);
        
        // Create roles first, then add them into scene 
        Role[] r1 = {new Role("Defrocked Priest",2),new Role("Marshal Canfield",3),
        		new Role("One-Eyed Man",4)};
        Scene s1 = new Scene("Evil Wears a Hat",4,r1);

        Role[] r2 = {new Role("Rug Merchant",1),new Role("Banker",2),
        		new Role("Talking Mul",5)};
        Scene s2 = new Scene("Law and the Old West",3,r2);
        
        Role[] r3 = {new Role("Auctioneer",5),new Role("General Custer",6)};
        Scene s3 = new Scene("The Life and Times of John Skywater",5,r3);
        
        Role[] r4 = {new Role("Drunk",3),new Role("Librarian",4),
        		new Role("Man with Hay",6)};
        Scene s4 = new Scene("My Years on the Prairie",5,r4);
        
        Role[] r5 = {new Role("Hollering Boy",2),new Role("Drunk Farmer",3),
        		new Role("Meek Little Sarah",5)};
        Scene s5 = new Scene("Buffalo Bill: The Lost Years",4,r5);
        
        Role[] r6 = {new Role("Squeaking Boy",2),new Role("Pharaoh Imhotep",4),
        		new Role("Aunt Martha",6)};
        Scene s6 = new Scene("Square Deal City",6,r6);
        
        Role[] r7 = {new Role("The Duck",4),new Role("His Brother",6)};
        Scene s7 = new Scene("Davy Crockett: A Drunkard's Tale",4,r7);
        
        Role[] r8 = {new Role("Town Drunk",2),new Role("Squinting Miner",4),
        		new Role("Poltergeist",5)};
        Scene s8 = new Scene("The Way the West Was Run",4,r8);
        
        Role[] r9 = {new Role("Angry Barber",1),new Role("Woman with Board",3),
        		new Role("Man on Fire",5)};
        Scene s9 = new Scene("Down in the Valley",3,r9);
        
        Role[] r10 = {new Role("Sleeping Man",1),new Role("Man with Pig",2),
        		new Role("Shooter",4)};
        Scene s10 = new Scene("Ol'Shooter and Little Doll",4,r10);
        
        
        Role[] r11 = {new Role("Buster",1),new Role("Man Reading Paper",4),
        		new Role("Fat Pete",5)};
        Scene s11 = new Scene("The Robbers of Trains",4,r11);

        Role[] r12 = {new Role("Martin",6)};
        Scene s12 = new Scene("Beyond the Pail: Life without Lactose",2,r12);
        
        Role[] r13 = {new Role("Preacher",3),new Role("Amused Witness",6)};
        Scene s13 = new Scene("A Man called 'Cow'",3,r13);
        
        Role[] r14 = {new Role("Curious Girl",3),new Role("Ghost of Plato",4)};
        Scene s14 = new Scene("Taffy Commercial",2,r14);
        
        Role[] r15 = {new Role("Surprised Bison",2),new Role("Man with Horn",4)};
        Scene s15 = new Scene("Gum Commercial",2,r15);
        
        Role[] r16 = {new Role("Shot in Back",2),new Role("Shot in Leg",4),
        		new Role("Leaps into Cake",5)};
        Scene s16 = new Scene("Jesse James: Man of Action",5,r16);
        
        Role[] r17 = {new Role("Piano Player",2),new Role("Man in Turban",3),
        		new Role("Falls on Hoe",4)};
        Scene s17 = new Scene("Disaster at Flying J",5,r17);
        
        Role[] r18 = {new Role("Falls from Tree",1),new Role("Laughing Woman",3),
        		new Role("Man with Whistle",4)};
        Scene s18 = new Scene("Shakespeare in Lubbock",3,r18);
        
        Role[] r19 = {new Role("Ex-Convict",4),new Role("Man with Onion",6)};
        Scene s19 = new Scene("Go West, You!",3,r19);
        
        Role[] r20 = {new Role("Staggering Man",3),new Role("Woman with Beer",5),
        		new Role("Marcie",6)};
        Scene s20 = new Scene("The Life and Times of John Skywater",5,r20);
        
        
        Role[] r21 = {new Role("Looks like Elvis",4),new Role("Singing Dead Man",5),
        		new Role("Apothecary",6)};
        Scene s21 = new Scene("Gun! The Musical",6,r21);

        Role[] r22 = {new Role("Jailer",2),new Role("Mephistopheles",4),
        		new Role("Breaks a Window",5)};
        Scene s22 = new Scene("Humor at the Expense of Others",5,r22);
        
        Role[] r23 = {new Role("Film Critic",5),new Role("Hobo with Bat",6)};
        Scene s23 = new Scene("The Search for Maggie White",6,r23);
        
        Role[] r24 = {new Role("Bewhisker'd Cowpoke",3),new Role("Dog",5)};
        Scene s24 = new Scene("Picante Sauce Commercial",2,r24);
        
        Role[] r25 = {new Role("Shot in Head",1),new Role("Leaps Out of Cake",4),
        		new Role("Shot Three Times",6)};
        Scene s25 = new Scene("Jesse James: Man of Action",5,r25);
        
        Role[] r26 = {new Role("Flustered Man",1),new Role("Space Monkey",2),
        		new Role("Cowbot Dan",5)};
        Scene s26 = new Scene("One False Step for Mankind",6,r26);
        
        Role[] r27 = {new Role("Man in Poncho",1),new Role("Ecstatic Housewife",3),
        		new Role("Isaac",5)};
        Scene s27 = new Scene("Thirteen the Hard Way",5,r27);
        
        Role[] r28 = {new Role("Cow",2),new Role("St. Clement of Alexandria",3),
        		new Role("Josie",4)};
        Scene s28 = new Scene("How They Get Milk",4,r28);
        
        Role[] r29 = {new Role("Willard",2),new Role("Leprechaun",3),
        		new Role("Startled Ox",5)};
        Scene s29 = new Scene("My Years on the Prairie",5,r29);
        
        Role[] r30 = {new Role("Voice of God",2),new Role("Hands of God",3),
        		new Role("Jack Kemp",4)};
        Scene s30 = new Scene("Davy Crockett: A Drunkard's Tale",4,r30);
        
       
        Role[] r31 = {new Role("Opice (Monkey)",5),new Role("Man with Gun",6)};
        Scene s31 = new Scene("Czechs in the Sonora",4,r31);

        Role[] r32 = {new Role("Thrifty Mike",1),new Role("Sober Physician",3),
        		new Role("Man on Floor",5)};
        Scene s32 = new Scene("Swing'em Wide",6,r32);
        
        Role[] r33 = {new Role("Liberated Nun",3),new Role("Witch Doctor",5),
        		new Role("Voice of Reason",6)};
        Scene s33 = new Scene("Swing'em Wide",6,r33);
        
        Role[] r34 = {new Role("Burning Man",2),new Role("Cheese Vendor",4),
        		new Role("Hit with Table",5)};
        Scene s34 = new Scene("Trials of the First Pioneers",4,r34);
        
        Role[] r35 = {new Role("Detective",3),new Role("File Clerk",4),
        		new Role("Cindy Lou",5)};
        Scene s35 = new Scene("How the Grinch Stole Texas",5,r35);
        
        Role[] r36 = {new Role("Man with Rope",1),new Role("Svetlana",2),
        		new Role("Accidental Victim",5)};
        Scene s36 = new Scene("J.Robert Lucky, Man of Substance",4,r36);
        
        Role[] r37 = {new Role("Very Wet Man",2),new Role("Dejected Housewife",4),
        		new Role("Man with Box",5)};
        Scene s37 = new Scene("Thirteen the Hard Way",5,r37);
        
        Role[] r38 = {new Role("Marksman",4),new Role("Postal Worker",5),
        		new Role("A Horse",6)};
        Scene s38 = new Scene("How They Get Milk",4,r38);
        
        Role[] r39 = {new Role("Fraternity Pledge",2),new Role("Man with Sword",6)};
        Scene s39 = new Scene("Breakin' in Trick Ponies",3,r39);
        
        Role[] r40 = {new Role("Farmer",2),new Role("Exploding Horse",4),
        		new Role("Jack",6)};
        Scene s40 = new Scene("Custer's Other Stands",5,r40);
        
        
        // Attach scene to deck
        // Repeat 40 times
        scene_deck.add(s1);
        scene_deck.add(s2);
        scene_deck.add(s3);
        scene_deck.add(s4);
        scene_deck.add(s5);
        scene_deck.add(s6);
        scene_deck.add(s7);
        scene_deck.add(s8);
        scene_deck.add(s9);
        scene_deck.add(s10);
        
        scene_deck.add(s11);
        scene_deck.add(s12);
        scene_deck.add(s13);
        scene_deck.add(s14);
        scene_deck.add(s15);
        scene_deck.add(s16);
        scene_deck.add(s17);
        scene_deck.add(s18);
        scene_deck.add(s19);
        scene_deck.add(s20);
        
        scene_deck.add(s21);
        scene_deck.add(s22);
        scene_deck.add(s23);
        scene_deck.add(s24);
        scene_deck.add(s25);
        scene_deck.add(s26);
        scene_deck.add(s27);
        scene_deck.add(s28);
        scene_deck.add(s29);
        scene_deck.add(s30);
        
        scene_deck.add(s31);
        scene_deck.add(s32);
        scene_deck.add(s33);
        scene_deck.add(s34);
        scene_deck.add(s35);
        scene_deck.add(s36);
        scene_deck.add(s37);
        scene_deck.add(s38);
        scene_deck.add(s39);
        scene_deck.add(s40);
        
        // Shuffle the deck
        Collections.shuffle(scene_deck);
        
        // Set the type of roles
        for(int i = 0;i < scene_deck.size();i++) {
        	for(int j = 0; j < scene_deck.get(i).getRoleSize();j++) {
        		scene_deck.get(i).getRole(j).setMain(true);
        	}
        }
    }

    // Draw a scene card from the deck
    public Scene drawScene(){
        return scene_deck.remove(0);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Getters/setters

    // Get the shot counters left on a set
    public int getSetShotCounters(int ix) {
        return shotcounters[ix];
    }

    // Get location
    public Location getLocation(int d) {
        return locations[d];
    }

}
