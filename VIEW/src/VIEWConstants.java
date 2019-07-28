package VIEW.src;

public class VIEWConstants {
    public static final String DEADWOOD_TITLE = "Deadwood";

	 
	public static final String SHOTCOUNTER_IMAGE = "src/shot.png";
    public static final String GAME_BOARD_IMAGE = "src/board.jpg";
    public static final String[] CARDS_IMAGE = {"src/cards/01.png","src/cards/02.png",
                                                "src/cards/03.png","src/cards/04.png",
                                                "src/cards/05.png","src/cards/06.png",
                                                "src/cards/07.png","src/cards/08.png",
                                                "src/cards/09.png","src/cards/10.png",
                                                "src/cards/11.png","src/cards/12.png",
                                                "src/cards/13.png","src/cards/14.png",
                                                "src/cards/15.png","src/cards/16.png",
                                                "src/cards/17.png","src/cards/18.png",
                                                "src/cards/19.png","src/cards/20.png",
                                                "src/cards/21.png","src/cards/22.png",
                                                "src/cards/23.png","src/cards/24.png",
                                                "src/cards/25.png","src/cards/26.png",
                                                "src/cards/27.png","src/cards/28.png",
                                                "src/cards/29.png","src/cards/30.png",
                                                "src/cards/31.png","src/cards/32.png",
                                                "src/cards/33.png","src/cards/34.png",
                                                "src/cards/35.png","src/cards/36.png",
                                                "src/cards/37.png","src/cards/38.png",
                                                "src/cards/39.png","src/cards/40.png"};
    public static final String[] DICE_IMAGE = {"src/dice/b1.png","src/dice/b2.png",
                                                "src/dice/b3.png","src/dice/b4.png",
                                                "src/dice/b5.png","src/dice/b6.png",
                                                "src/dice/c1.png","src/dice/c2.png",
                                                "src/dice/c3.png","src/dice/c4.png",
                                                "src/dice/c5.png","src/dice/c6.png",
                                                "src/dice/g1.png","src/dice/g2.png",
                                                "src/dice/g3.png","src/dice/g4.png",
                                                "src/dice/g5.png","src/dice/g6.png"};
      
      /*
	public static final String SHOTCOUNTER_IMAGE = "shot.png";
    public static final String GAME_BOARD_IMAGE = "board.jpg";
    public static final String[] CARDS_IMAGE = {"cards/01.png","cards/02.png",
    											"cards/03.png","cards/04.png",
    											"cards/05.png","cards/06.png",
    											"cards/07.png","cards/08.png",
    											"cards/09.png","cards/10.png",
    											"cards/11.png","cards/12.png",
    											"cards/13.png","cards/14.png",
    											"cards/15.png","cards/16.png",
    											"cards/17.png","cards/18.png",
    											"cards/19.png","cards/20.png",
    											"cards/21.png","cards/22.png",
    											"cards/23.png","cards/24.png",
    											"cards/25.png","cards/26.png",
    											"cards/27.png","cards/28.png",
    											"cards/29.png","cards/30.png",
    											"cards/31.png","cards/32.png",
    											"cards/33.png","cards/34.png",
    											"cards/35.png","cards/36.png",
    											"cards/37.png","cards/38.png",
    											"cards/39.png","cards/40.png"};
    public static final String[] DICE_IMAGE = {"dice/b1.png","dice/b2.png",
    											"dice/b3.png","dice/b4.png",
    											"dice/b5.png","dice/b6.png",
    											"dice/c1.png","dice/c2.png",
    											"dice/c3.png","dice/c4.png",
    											"dice/c5.png","dice/c6.png",
    											"dice/g1.png","dice/g2.png",
    											"dice/g3.png","dice/g4.png",
    											"dice/g5.png","dice/g6.png"};
    */

	public static final int[][] ShotCounterCoordinates = {{445, 155}, // JAIL (1)
			                                              {145, 12}, {92, 12}, {38, 12}, // TRAIN (1) (2) (3)
														  {315,330}, {315,281}, // GENERAL (1) (2)
													      {680,221}, {625,221}, // SALOON (1) (2)
														  {805,28}, {860,28}, {915,28}, // MAIN (1) (2) (3)
														  {355,760}, {300,760}, {245,760}, // SECRET (1) (2) (3)
													      {525,476}, {475,476}, // RANCH (1) (2)
			                                              {842,550}, // BANK (1)
														  {682,680}, {622,680}, // CHURCH (1) (2)
														  {1110,685}, {1060,685}, {1005,685}}; // HOTEL (1) (2) (3)

    public static final int[][] CardsCoordinates = {{0,0},{0,0},{282,28},{20,65},
    												{371,281},{631,281},{970,28},{27,732},
    												{254,476},{622,473},{622,733},{970,740}};
    
    public static final int[][] ExtrasCoordinates = {{0,0},{0,0},{523,28},{20,65},
													 {371,281},{631,281},{970,28},{27,732},
													 {254,476},{622,473},{622,733},{970,740}};;
    
}
