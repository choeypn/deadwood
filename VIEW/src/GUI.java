package VIEW.src;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import CONTROLLER.src.*;
import MODEL.src.Constants;

public class GUI extends JFrame {
    private JLabel labelGameBoard;
    private JLabel[] labelCard = new JLabel[40];
    private JLabel[] labelPlayer = new JLabel[3];
    private JLabel labelMenu;
    private JLabel[] shotcounters = new JLabel[22];
    private JButton buttonAct;
    private JButton buttonRehearse;
    private JButton buttonMove;
    private JLayeredPane paneDeadwood;
    private ImageIcon iconGameBoard;

    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel gameplay;
    private JPanel player1box;
	private JPanel player2box;
	private JPanel player3box;
	private JPanel gameplaybox;

    private final static String newline = "\n";
    private static final String MENU_LABEL_TEXT = "MENU";
    private static final String ACT_BUTTON_TEXT = "ACT";
    private static final String REHEARSE_BUTTON_TEXT = "REHEARSE";
    private static final String MOVE_BUTTON_TEXT = "MOVE";
    public GUI() {
        super(VIEWConstants.DEADWOOD_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeLabels();
        initializeButtons();
        initializeDeadwoodPane();
    }
    private void initializeLabels() {
        setupGameBoardLabel();
        setupCardsLabel();
        setupPlayerLabel();
        setupMenuLabel();
        setupShotLabel();
        setupTextBoxes();
    }
    
    public void setLabelBounds(JLabel obj, int xCord, int yCord) {
    	obj.setBounds(xCord, yCord, obj.getIcon().getIconWidth(), obj.getIcon().getIconHeight());
    }


    
    public void placePlayerRole(JLabel player,int loc,int pos,int numRoles) {
    	switch(numRoles) {
    	case 1: 
    		setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+82,
					VIEWConstants.CardsCoordinates[loc][1]+49);
			break;
    	
    	case 2:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+53,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+115,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		}   		
    		break;
    	case 3:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+19,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+82,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+145,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		}
    		break;
    	}
    
    }
    
    public void placePlayerExtra(JLabel player,int loc,int pos) {
    	switch(loc) {
    	case Constants.JAIL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+240,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+240,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.TRAIN:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+98,
    					VIEWConstants.CardsCoordinates[loc][1]+165);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+33,
    					VIEWConstants.CardsCoordinates[loc][1]+205);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+98,
    					VIEWConstants.CardsCoordinates[loc][1]+257);
    			break;
    		case 4:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+33,
    					VIEWConstants.CardsCoordinates[loc][1]+295);
    			break;
    		}
    		break;
    	case Constants.GENERAL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-132,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-132,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.SALOON:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+250,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+250,
    					VIEWConstants.CardsCoordinates[loc][1]+75);
    			break;
    		}
    		break;
    	case Constants.MAIN:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-330,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-330,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-247,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 4:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]-247,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.SECRET:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+410,
    					VIEWConstants.CardsCoordinates[loc][1]-10);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+410,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+497,
    					VIEWConstants.CardsCoordinates[loc][1]-10);
    			break;
    		case 4:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+497,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.RANCH:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+162,
    					VIEWConstants.CardsCoordinates[loc][1]+136);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+235,
    					VIEWConstants.CardsCoordinates[loc][1]+50);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+235,
    					VIEWConstants.CardsCoordinates[loc][1]+136);
    			break;
    		}
    		break;
    	case Constants.BANK:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+292,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+292,
    					VIEWConstants.CardsCoordinates[loc][1]+85);
    			break;
    		}
    		break;
    	case Constants.CHURCH:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+237,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+237,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.HOTEL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+77,
    					VIEWConstants.CardsCoordinates[loc][1]-226);
    			break;
    		case 2:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+77,
    					VIEWConstants.CardsCoordinates[loc][1]-140);
    			break;
    		case 3:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+143,
    					VIEWConstants.CardsCoordinates[loc][1]-267);
    			break;
    		case 4:
    			setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+143,
    					VIEWConstants.CardsCoordinates[loc][1]-180);
    			break;
    		}
    		break;
    	}
    }
    
    public void placePlayerOffRole(JLabel player,int loc,int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0],
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	case 2:
    		setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+50,
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	case 3:
    		setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0]+100,
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	}
    }
    
    public void placePlayerTrailers(JLabel player,int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(player,1000,300);
    		break;
    	case 2:
    		setLabelBounds(player,1050,300);
    		break;
    	case 3:
    		setLabelBounds(player,1100,300);
    		break;
    	}	
    }
    
    public void placePlayerCasting(JLabel player, int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(player,50,500);
    		break;
    	case 2:
    		setLabelBounds(player,100,500);
    		break;
    	case 3:
    		setLabelBounds(player,150,500);
    		break;
    	}
    }
    
    private void setupGameBoardLabel() {
        labelGameBoard = new JLabel();
        iconGameBoard = new ImageIcon(VIEWConstants.GAME_BOARD_IMAGE);
        labelGameBoard.setIcon(iconGameBoard);
        setLabelBounds(labelGameBoard,0,0);
        setSize(592, 506);
    }

    private void setupTextBoxes() {

    	// Player 1 Infobox
        player1 = new JLabel();
		player1.setText("Player 1");
		player1.setOpaque(true);
		player1.setBackground(Color.black);
		player1.setForeground(Color.cyan);
		Border border1 = BorderFactory.createLineBorder(Color.CYAN, 5);
		player1.setBounds(iconGameBoard.getIconWidth() + 200, 30, 200, 200);
		player1.setBorder(border1);
		player1.setHorizontalAlignment(JLabel.CENTER);
		player1.setVerticalAlignment(JLabel.CENTER);

		// Player 2 Infobox
		player2 = new JLabel();
		player2.setText("Player 2");
		player2.setOpaque(true);
		player2.setBackground(Color.black);
		player2.setForeground(Color.green);
		Border border2 = BorderFactory.createLineBorder(Color.GREEN, 5);
		player2.setBounds(iconGameBoard.getIconWidth() + 200, 280, 200, 200);
		player2.setBorder(border2);
		player2.setHorizontalAlignment(JLabel.CENTER);
		player2.setVerticalAlignment(JLabel.CENTER);

		// Player 3 Infobox
		player3 = new JLabel();
		player3.setText("Player 3");
		player3.setOpaque(true);
		player3.setBackground(Color.black);
		player3.setForeground(Color.red);
		Border border3 = BorderFactory.createLineBorder(Color.RED, 5);
		player3.setBounds(iconGameBoard.getIconWidth() + 200, 530, 200, 200);
		player3.setBorder(border3);
		player3.setHorizontalAlignment(JLabel.CENTER);
		player3.setVerticalAlignment(JLabel.CENTER);

		// Gameplay text
		gameplay = new JLabel();
		gameplay.setText("Gameplay");
		gameplay.setOpaque(true);
		gameplay.setBackground(Color.white);
		gameplay.setBounds(iconGameBoard.getIconWidth() + 50, 780, 500, 200);
		gameplay.setHorizontalAlignment(JLabel.CENTER);
		gameplay.setVerticalAlignment(JLabel.CENTER);

		//create new Font
		Font font = new Font("Courier", Font.BOLD,18);

		//set font for JLabel
		gameplay.setFont(font);

    }

    private void setupCardsLabel() {
        labelCard[Constants.TRAIN] = new JLabel();
        ImageIcon cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[0]);
        labelCard[Constants.TRAIN].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.TRAIN],
        		VIEWConstants.CardsCoordinates[Constants.TRAIN][0],
        		VIEWConstants.CardsCoordinates[Constants.TRAIN][1]);
        labelCard[Constants.TRAIN].setEnabled(false);
        //labelCard[Constants.TRAIN].setOpaque(true);
        
        labelCard[Constants.SECRET] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[15]);
        labelCard[Constants.SECRET].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.SECRET],
        		VIEWConstants.CardsCoordinates[Constants.SECRET][0],
        		VIEWConstants.CardsCoordinates[Constants.SECRET][1]);
        labelCard[Constants.SECRET].setOpaque(true);


        labelCard[Constants.JAIL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[22]);
        labelCard[Constants.JAIL].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.JAIL],
        		VIEWConstants.CardsCoordinates[Constants.JAIL][0],
        		VIEWConstants.CardsCoordinates[Constants.JAIL][1]);
        labelCard[Constants.JAIL].setOpaque(true);
        
        labelCard[Constants.GENERAL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[11]);
        labelCard[Constants.GENERAL].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.GENERAL],
        		VIEWConstants.CardsCoordinates[Constants.GENERAL][0],
        		VIEWConstants.CardsCoordinates[Constants.GENERAL][1]);
        labelCard[Constants.GENERAL].setOpaque(true);
    
        labelCard[Constants.RANCH] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[34]);
        labelCard[Constants.RANCH].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.RANCH],
        		VIEWConstants.CardsCoordinates[Constants.RANCH][0],
        		VIEWConstants.CardsCoordinates[Constants.RANCH][1]);
        labelCard[Constants.RANCH].setOpaque(true);
    
        labelCard[Constants.SALOON] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[39]);
        labelCard[Constants.SALOON].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.SALOON],
        		VIEWConstants.CardsCoordinates[Constants.SALOON][0],
        		VIEWConstants.CardsCoordinates[Constants.SALOON][1]);
        labelCard[Constants.SALOON].setOpaque(true);
        
        labelCard[Constants.BANK] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[1]);
        labelCard[Constants.BANK].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.BANK],
        		VIEWConstants.CardsCoordinates[Constants.BANK][0],
        		VIEWConstants.CardsCoordinates[Constants.BANK][1]);
        labelCard[Constants.BANK].setOpaque(true);
        
        labelCard[Constants.CHURCH] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[9]);
        labelCard[Constants.CHURCH].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.CHURCH],
        		VIEWConstants.CardsCoordinates[Constants.CHURCH][0],
        		VIEWConstants.CardsCoordinates[Constants.CHURCH][1]);
        labelCard[Constants.CHURCH].setOpaque(true);
        
        labelCard[Constants.MAIN] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[17]);
        labelCard[Constants.MAIN].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.MAIN],
        		VIEWConstants.CardsCoordinates[Constants.MAIN][0],
        		VIEWConstants.CardsCoordinates[Constants.MAIN][1]);
        labelCard[Constants.MAIN].setOpaque(true);
        
        labelCard[Constants.HOTEL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[26]);
        labelCard[Constants.HOTEL].setIcon(cardIcon);
        setLabelBounds(labelCard[Constants.HOTEL],
        		VIEWConstants.CardsCoordinates[Constants.HOTEL][0],
        		VIEWConstants.CardsCoordinates[Constants.HOTEL][1]);
        labelCard[Constants.HOTEL].setOpaque(true);
        
    }
    
    private void setupPlayerLabel() {

    	// Player 1 - Blue
    	labelPlayer[0] = new JLabel();
    	ImageIcon playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[3]);
        labelPlayer[0].setIcon(playerDiceIcon);
        //placePlayerRole(labelPlayer[0],Constants.GENERAL,1,1);
        //placePlayerOffRole(labelPlayer[0],Constants.HOTEL,3);
        placePlayerCasting(labelPlayer[0],1);

        // Player 2 - Green
        labelPlayer[1] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[15]);
        labelPlayer[1].setIcon(playerDiceIcon);
        //placePlayerExtra(labelPlayer[1],Constants.MAIN,1);
        //placePlayerOffRole(labelPlayer[1],Constants.HOTEL,2);
        placePlayerCasting(labelPlayer[1],3);

        // Player 3 - Red
        labelPlayer[2] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[6]);
        labelPlayer[2].setIcon(playerDiceIcon);
        labelPlayer[2].setBounds(114, 127, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        placePlayerCasting(labelPlayer[2],2);
        
        //labelPlayer.setBounds(114,227,46,46);
    }

    // Setup the shotcounter labels
    private void setupShotLabel() {
        for(int i = 0; i < shotcounters.length;i++) {
        	shotcounters[i] = new JLabel();
            ImageIcon shotIcon = new ImageIcon(VIEWConstants.SHOTCOUNTER_IMAGE);
            shotcounters[i].setIcon(shotIcon);
            shotcounters[i].setBounds(VIEWConstants.ShotCounterCoordinates[i][0],VIEWConstants.ShotCounterCoordinates[i][1]
                    ,shotIcon.getIconWidth(),shotIcon.getIconHeight());
        }
    }
    
    private void setupMenuLabel() {
        labelMenu = new JLabel(MENU_LABEL_TEXT);
        labelMenu.setBounds(iconGameBoard.getIconWidth() + 40, 0, 100, 20);
    }
    private void initializeButtons() {
        setupActButton();
        setupRehearseButton();
        setupMoveButton();
    }
    private void setupActButton() {
        buttonAct = new JButton(ACT_BUTTON_TEXT);
        buttonAct.setBackground(Color.white);
        buttonAct.setBounds(iconGameBoard.getIconWidth() + 10, 30, 100, 20);
        //buttonAct.addMouseListener(new ActButtonMouseListener());
    }
    private void setupRehearseButton() {
        buttonRehearse = new JButton(REHEARSE_BUTTON_TEXT);
        buttonRehearse.setBackground(Color.white);
        buttonRehearse.setBounds(iconGameBoard.getIconWidth() + 10, 60, 100, 20);
        //buttonRehearse.addMouseListener(new RehearseButtonMouseListener());
    }
    private void setupMoveButton() {
        buttonMove = new JButton(MOVE_BUTTON_TEXT);
        buttonMove.setBackground(Color.white);
        buttonMove.setBounds(iconGameBoard.getIconWidth() + 10, 90, 100, 20);
        //buttonMove.addMouseListener(new MoveButtonMouseListener());
    }
    private void initializeDeadwoodPane() {
        paneDeadwood = getLayeredPane();
        paneDeadwood.add(labelGameBoard, new Integer(0)); // Add the board to the lowest layer
        // Add the cards to the lower layer
        paneDeadwood.add(labelCard[Constants.TRAIN], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.SECRET], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.JAIL], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.GENERAL], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.RANCH], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.SALOON], new Integer(1)); 
        paneDeadwood.add(labelCard[Constants.BANK], new Integer(1));
        paneDeadwood.add(labelCard[Constants.CHURCH], new Integer(1));
        paneDeadwood.add(labelCard[Constants.MAIN], new Integer(1));
        paneDeadwood.add(labelCard[Constants.HOTEL], new Integer(1));
        // Add the player
        paneDeadwood.add(labelPlayer[0], new Integer(3));
        paneDeadwood.add(labelPlayer[1], new Integer(3));
        paneDeadwood.add(labelPlayer[2], new Integer(3));
        
        paneDeadwood.add(labelMenu, new Integer(2));
        paneDeadwood.add(buttonAct, new Integer(2));
        paneDeadwood.add(buttonRehearse, new Integer(2));
        paneDeadwood.add(buttonMove, new Integer(2));

        // Add the shotcounters to the pane
        for(int i = 0; i < shotcounters.length;i++) {
        	paneDeadwood.add(shotcounters[i],new Integer(3));
        }

        paneDeadwood.add(player1, 3);
        paneDeadwood.add(player2, 3);
        paneDeadwood.add(player3, 3);
        paneDeadwood.add(gameplay, 3);



    }
}
