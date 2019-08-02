package VIEW.src;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import CONTROLLER.src.*;
import MODEL.src.Constants;

public class GUI extends JFrame {
    private JLabel labelGameBoard;
    private JLabel[] labelCard = new JLabel[12];
    private JLabel[] labelPlayer = new JLabel[3];
    private JLabel activePlayer = new JLabel();
    private JLabel labelMenu;


    private JLabel[] shotcountersJail = new JLabel[1];
	private JLabel[] shotcountersTrain = new JLabel[3];
	private JLabel[] shotcountersGeneral = new JLabel[2];
	private JLabel[] shotcountersSaloon = new JLabel[2];
	private JLabel[] shotcountersMain = new JLabel[3];
	private JLabel[] shotcountersSecret = new JLabel[3];
	private JLabel[] shotcountersRanch = new JLabel[2];
	private JLabel[] shotcountersBank = new JLabel[1];
	private JLabel[] shotcountersChurch = new JLabel[2];
	private JLabel[] shotcountersHotel = new JLabel[3];

	private JLabel[][] shotcounters = {shotcountersJail, shotcountersTrain, shotcountersGeneral, shotcountersSaloon,
									   shotcountersMain, shotcountersSecret, shotcountersRanch, shotcountersBank,
									   shotcountersChurch, shotcountersHotel};

    private JButton buttonAct;
    private JButton buttonRehearse;
    private JButton buttonMove;
    private JButton buttonUpgrade;
    private JButton buttonTakeRole;
    private JButton buttonEnd;
    private JLayeredPane paneDeadwood;
    private ImageIcon iconGameBoard;
    private JComboBox moveSelection;
    private JComboBox roleSelection;
    private JComboBox upgradeSelection;
    private Controller controller_ref;
    private JComboBox paymentSelection;

    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel gameplay;


    private final static String newline = "\n";
    private static final String MENU_LABEL_TEXT = "MENU";
    private static final String ACT_BUTTON_TEXT = "ACT";
    private static final String REHEARSE_BUTTON_TEXT = "REHEARSE";
    private static final String MOVE_BUTTON_TEXT = "MOVE";
    private static final String TAKEROLE_BUTTON_TEXT = "TAKE ROLE";
    private static final String UPGRADE_BUTTON_TEXT = "UPGRADE";
    private static final String END_BUTTON_TEXT = "END";
    public GUI(Controller c) {
        super(VIEWConstants.DEADWOOD_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller_ref = c;
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
    
    public void placePlayerRole(int player,int loc,int pos,int numRoles) {
    	switch(numRoles) {
    	case 1: 
    		setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+82,
					VIEWConstants.CardsCoordinates[loc][1]+49);
			break;
    	
    	case 2:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+53,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+115,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		}   		
    		break;
    	case 3:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+19,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+82,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+145,
    					VIEWConstants.CardsCoordinates[loc][1]+49);
    			break;
    		}
    		break;
    	}
    
    }
    
    public void placePlayerExtra(int player,int loc,int pos) {
    	switch(loc) {
    	case Constants.JAIL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+240,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+240,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.TRAIN:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+98,
    					VIEWConstants.CardsCoordinates[loc][1]+165);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+33,
    					VIEWConstants.CardsCoordinates[loc][1]+205);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+98,
    					VIEWConstants.CardsCoordinates[loc][1]+257);
    			break;
    		case 4:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+33,
    					VIEWConstants.CardsCoordinates[loc][1]+295);
    			break;
    		}
    		break;
    	case Constants.GENERAL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-132,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-132,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.SALOON:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+250,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+250,
    					VIEWConstants.CardsCoordinates[loc][1]+75);
    			break;
    		}
    		break;
    	case Constants.MAIN:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-330,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-330,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-247,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 4:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]-247,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.SECRET:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+410,
    					VIEWConstants.CardsCoordinates[loc][1]-10);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+410,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+497,
    					VIEWConstants.CardsCoordinates[loc][1]-10);
    			break;
    		case 4:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+497,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.RANCH:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+162,
    					VIEWConstants.CardsCoordinates[loc][1]+136);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player -1],VIEWConstants.CardsCoordinates[loc][0]+235,
    					VIEWConstants.CardsCoordinates[loc][1]+50);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+235,
    					VIEWConstants.CardsCoordinates[loc][1]+136);
    			break;
    		}
    		break;
    	case Constants.BANK:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+292,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+292,
    					VIEWConstants.CardsCoordinates[loc][1]+85);
    			break;
    		}
    		break;
    	case Constants.CHURCH:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+237,
    					VIEWConstants.CardsCoordinates[loc][1]);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+237,
    					VIEWConstants.CardsCoordinates[loc][1]+80);
    			break;
    		}
    		break;
    	case Constants.HOTEL:
    		switch(pos) {
    		case 1:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+77,
    					VIEWConstants.CardsCoordinates[loc][1]-226);
    			break;
    		case 2:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+77,
    					VIEWConstants.CardsCoordinates[loc][1]-140);
    			break;
    		case 3:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+143,
    					VIEWConstants.CardsCoordinates[loc][1]-267);
    			break;
    		case 4:
    			setLabelBounds(labelPlayer[player-1],VIEWConstants.CardsCoordinates[loc][0]+143,
    					VIEWConstants.CardsCoordinates[loc][1]-180);
    			break;
    		}
    		break;
    	}
    }
    
    public void placePlayerOffRole(int loc,int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(labelPlayer[playerNum-1],
    				VIEWConstants.CardsCoordinates[loc][0],
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	case 2:
    		setLabelBounds(labelPlayer[playerNum-1],
    				VIEWConstants.CardsCoordinates[loc][0]+50,
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	case 3:
    		setLabelBounds(labelPlayer[playerNum-1],
    				VIEWConstants.CardsCoordinates[loc][0]+100,
					VIEWConstants.CardsCoordinates[loc][1]+125);
    		break;
    	}
    }
    
    public void placePlayerTrailers(int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(labelPlayer[playerNum-1],1000,300);
    		break;
    	case 2:
    		setLabelBounds(labelPlayer[playerNum-1],1050,300);
    		break;
    	case 3:
    		setLabelBounds(labelPlayer[playerNum-1],1100,300);
    		break;
    	}	
    }
    
    public void placePlayerCasting(int playerNum) {
    	switch(playerNum) {
    	case 1:
    		setLabelBounds(labelPlayer[playerNum-1],50,500);
    		break;
    	case 2:
    		setLabelBounds(labelPlayer[playerNum-1],100,500);
    		break;
    	case 3:
    		setLabelBounds(labelPlayer[playerNum-1],150,500);
    		break;
    	}
    }

    public void displayActivePlayer(int playerNum) {
		switch(playerNum) {
			case 1:
				activePlayer.setIcon(labelPlayer[0].getIcon());
				
				break;
			case 2:
				activePlayer.setIcon(labelPlayer[1].getIcon());

				break;
			case 3:
				activePlayer.setIcon(labelPlayer[2].getIcon());

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
		player1.setBounds(iconGameBoard.getIconWidth() + 350, 30, 200, 200);
		player1.setBorder(border1);
		player1.setHorizontalAlignment(JLabel.CENTER);
		player1.setVerticalAlignment(JLabel.CENTER);
		player1.setVisible(false);

		// Player 2 Infobox
		player2 = new JLabel();
		player2.setText("Player 2");
		player2.setOpaque(true);
		player2.setBackground(Color.black);
		player2.setForeground(Color.red);
		Border border2 = BorderFactory.createLineBorder(Color.RED, 5);
		player2.setBounds(iconGameBoard.getIconWidth() + 350, 280, 200, 200);
		player2.setBorder(border2);
		player2.setHorizontalAlignment(JLabel.CENTER);
		player2.setVerticalAlignment(JLabel.CENTER);
		player2.setVisible(false);

		// Player 3 Infobox
		player3 = new JLabel();
		player3.setText("Player 3");
		player3.setOpaque(true);
		player3.setBackground(Color.black);
		player3.setForeground(Color.green);
		Border border3 = BorderFactory.createLineBorder(Color.GREEN, 5);
		player3.setBounds(iconGameBoard.getIconWidth() + 350, 530, 200, 200);
		player3.setBorder(border3);
		player3.setHorizontalAlignment(JLabel.CENTER);
		player3.setVerticalAlignment(JLabel.CENTER);
		player3.setVisible(false);

		// Gameplay text
		gameplay = new JLabel();
		gameplay.setText("Gameplay");
		gameplay.setOpaque(true);
		gameplay.setBackground(Color.white);
		gameplay.setBounds(iconGameBoard.getIconWidth() + 50, 780, 500, 200);
		gameplay.setHorizontalAlignment(JLabel.CENTER);
		gameplay.setVerticalAlignment(JLabel.CENTER);

		//create new Font
		Font font = new Font("Courier", Font.BOLD,12);

		//set font for JLabel
		gameplay.setFont(font);

    }

    // Set the gameplay text
    public void setGameplayText(String text) {
		gameplay.setText(text);
	}



    // Enable player info boxes
	public void enablePlayerInfo(int players) {

    	if (players == 2) {
    		player1.setVisible(true);
    		player2.setVisible(true);
		}
    	else if (players == 3) {
    		player1.setVisible(true);
    		player2.setVisible(true);
    		player3.setVisible(true);
		}
	}

	// Update player info boxes
	public void updatePlayerInfo(int playernum, String info) {

    	switch (playernum) {
			case 1:
				player1.setText(info);
				break;
			case 2:
				player2.setText(info);
				break;
			case 3:
				player3.setText(info);
				break;
		}
	}

    private void setupCardsLabel() {
    	for(int i = 2; i <= 11; i++) {
    		labelCard[i] = new JLabel();
    	}

    }

    public void removeSceneCard(int locnum) {
		labelCard[locnum].setEnabled(false);
	}
    
    public void placeSceneCard(int location,int sceneNum) {
        ImageIcon cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[sceneNum]);
        labelCard[location].setIcon(cardIcon);
        setLabelBounds(labelCard[location],
        		VIEWConstants.CardsCoordinates[location][0],
        		VIEWConstants.CardsCoordinates[location][1]);
        labelCard[location].setVisible(false);
    }

    public void enableCard(){
    	for(int i =2; i < labelCard.length;i++){
    		labelCard[i].setEnabled(true);
		}
	}
    public void flipSceneCard(int location) {
    	labelCard[location].setVisible(true);
    }
    
    private void setupPlayerLabel() {
    	// Player 1 - Blue
    	labelPlayer[0] = new JLabel();
    	ImageIcon playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[0*6]);
        labelPlayer[0].setIcon(playerDiceIcon);


        // Player 2 - Red
        labelPlayer[1] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[1*6]);
        labelPlayer[1].setIcon(playerDiceIcon);


		// Player 3 - Green
		labelPlayer[2] = new JLabel();
		playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[2*6]);
		labelPlayer[2].setIcon(playerDiceIcon);

		// Active player
		activePlayer = new JLabel();
		playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[0]);
		activePlayer.setIcon(playerDiceIcon);
		activePlayer.setBounds(1320,30, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
    }
    
    public void upgradePlayer(int player,int rank) {
    	ImageIcon playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[6*(player-1)+rank-1]);
    	labelPlayer[player-1].setIcon(playerDiceIcon);;
    }

    // Setup the shotcounter labels
    private void setupShotLabel() {
        for(int i = 0; i < shotcounters.length;i++) {
        	for (int j = 0; j < shotcounters[i].length; j++) {
				shotcounters[i][j] = new JLabel();
				ImageIcon shotIcon = new ImageIcon(VIEWConstants.SHOTCOUNTER_IMAGE);
				shotcounters[i][j].setIcon(shotIcon);
				shotcounters[i][j].setBounds(VIEWConstants.ShotCounterCoordinates[i][j][0],VIEWConstants.ShotCounterCoordinates[i][j][1]
						,shotIcon.getIconWidth(),shotIcon.getIconHeight());
				shotcounters[i][j].setVisible(false);
			}
        }
    }
    
    public void turnOnShotCounters() {
    	for(int i = 0; i < shotcounters.length; i ++) {
			for (int j = 0; j < shotcounters[i].length; j++) {
				shotcounters[i][j].setVisible(true);
			}
		}
	}

	public void removeShotCounters(int loc, int counters) {
    	shotcounters[loc-2][counters-1].setVisible(false);
	}
    
    private void setupMenuLabel() {
        labelMenu = new JLabel(MENU_LABEL_TEXT);
        labelMenu.setBounds(iconGameBoard.getIconWidth() + 40, 0, 100, 20);
    }
    private void initializeButtons() {
        setupActButton();
        setupRehearseButton();
        setupMoveButton();
        setupTakeRoleButton();
        setupUpgradeButton();
        setupLocationDropdown();
        setupTakeRoleDropdown();
        setupUpgradeDropdown();
        setupPaymentDropdown();
        setupEndButton() ;
    }

    



    private void setupActButton() {
        buttonAct = new JButton(ACT_BUTTON_TEXT);
        buttonAct.setBackground(Color.white);
        buttonAct.setBounds(iconGameBoard.getIconWidth() + 10, 30, 100, 20);
        buttonAct.addMouseListener(new ActButtonListener(controller_ref));
    }
    private void setupRehearseButton() {
        buttonRehearse = new JButton(REHEARSE_BUTTON_TEXT);
        buttonRehearse.setBackground(Color.white);
        buttonRehearse.setBounds(iconGameBoard.getIconWidth() + 10, 60, 100, 20);
        buttonRehearse.addMouseListener(new RehearseButtonListener(controller_ref));
    }
    private void setupMoveButton() {
        buttonMove = new JButton(MOVE_BUTTON_TEXT);
        buttonMove.setBackground(Color.white);
        buttonMove.setBounds(iconGameBoard.getIconWidth() + 10, 90, 100, 20);
        buttonMove.addMouseListener(new MoveButtonListener(controller_ref));
        
    }
    private void setupLocationDropdown() {
        String s1[] = {"Trailers","Casting Office","Jail","Train Station","General Store","Saloon",
                "Main Street","Secret Hideout","Ranch","Bank","Church","Hotel"};
        moveSelection = new JComboBox<String>(s1);
        moveSelection.setBounds(iconGameBoard.getIconWidth() + 130, 90, 150, 20);
        moveSelection.addItemListener(new LocationItemListener(controller_ref));
    }

    private void setupTakeRoleButton() {
        buttonTakeRole = new JButton(TAKEROLE_BUTTON_TEXT);
        buttonTakeRole.setBackground(Color.white);
        buttonTakeRole.setBounds(iconGameBoard.getIconWidth() + 10, 120, 100, 20);
        buttonTakeRole.addMouseListener(new TakeRoleButtonListener(controller_ref));
    }

    private void setupTakeRoleDropdown() {
        String s1[] = {"Main 1","Main 2","Main 3","Extra 1","Extra 2","Extra 3",
                "Extra 4"};
        roleSelection = new JComboBox<String>(s1);
        roleSelection.setBounds(iconGameBoard.getIconWidth() + 130, 120, 150, 20);
        roleSelection.addItemListener(new TakeRoleItemListener(controller_ref));
    }

    private void setupUpgradeButton() {
        buttonUpgrade = new JButton(UPGRADE_BUTTON_TEXT);
        buttonUpgrade.setBackground(Color.white);
        buttonUpgrade.setBounds(iconGameBoard.getIconWidth() + 10, 150, 100, 20);
        buttonUpgrade.addMouseListener(new UpgradeButtonListener(controller_ref));
    }

    private void setupUpgradeDropdown() {
        String s1[] = {"Rank 2","Rank 3","Rank 4","Rank 5","Rank 6"};
        upgradeSelection = new JComboBox<String>(s1);
        upgradeSelection.setBounds(iconGameBoard.getIconWidth() + 130, 150, 150, 20);
        upgradeSelection.addItemListener(new UpgradeItemListener(controller_ref));
    }

    private void setupPaymentDropdown() {
    	String s1[] = {"Dollar","Credit"};
        paymentSelection = new JComboBox<String>(s1);
        paymentSelection.setBounds(iconGameBoard.getIconWidth() + 130, 180, 150, 20);
        paymentSelection.addItemListener(new PaymentItemListener(controller_ref));
    }
    
    private void setupEndButton() {
        buttonEnd = new JButton(END_BUTTON_TEXT);
        buttonEnd.setBackground(Color.white);
        buttonEnd.setBounds(iconGameBoard.getIconWidth() + 10, 180, 100, 20);
        buttonEnd.addMouseListener(new EndButtonListener(controller_ref));
    }
    
    public JLabel getSceneLocation(int i) {
    	return labelCard[i];
    }
    
    public void placeScenes() {
    	for(int i = 2;i <= 11;i++) {
    		labelCard[i].setVisible(true);;
    	}
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
        paneDeadwood.add(buttonTakeRole, new Integer(2));
        paneDeadwood.add(buttonUpgrade, new Integer(2));
        paneDeadwood.add(buttonEnd,new Integer(2));

        paneDeadwood.add(moveSelection,3);
        paneDeadwood.add(upgradeSelection,3);
        paneDeadwood.add(roleSelection,3);
        paneDeadwood.add(paymentSelection,3);

        // Add the shotcounters to the pane
        for(int i = 0; i < shotcounters.length;i++) {
			for (int j = 0; j < shotcounters[i].length; j++) {
				paneDeadwood.add(shotcounters[i][j], new Integer(3));
			}
        }

        paneDeadwood.add(player1, 3);
        paneDeadwood.add(player2, 3);
        paneDeadwood.add(player3, 3);
        paneDeadwood.add(gameplay, 3);

		paneDeadwood.add(activePlayer, 3);


    }
}
