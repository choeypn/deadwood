package VIEW.src;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import CONTROLLER.src.*;
import MODEL.src.Constants;

public class GUI extends JFrame {
    private JLabel labelGameBoard;
    private JLabel[] labelCard = new JLabel[40];
    private JLabel[] labelPlayer = new JLabel[3];
    private JLabel labelMenu;
    private JLabel[] shotcounters = new JLabel[3];
    private JButton buttonAct;
    private JButton buttonRehearse;
    private JButton buttonMove;
    private JLayeredPane paneDeadwood;
    private ImageIcon iconGameBoard;

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
    
    public void placePlayerOffRole(JLabel player,int loc,int numPlayer) {
    	switch(numPlayer) {
    	case 1:
    		setLabelBounds(player,VIEWConstants.CardsCoordinates[loc][0],
					VIEWConstants.CardsCoordinates[loc][1]+170);
    		break;
    	case 2:
    		break;
    	case 3:
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
    	labelPlayer[0] = new JLabel();
    	ImageIcon playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[3]);
        labelPlayer[0].setIcon(playerDiceIcon);
        //labelPlayer[0].setBounds(114, 227, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        placePlayerRole(labelPlayer[0],Constants.GENERAL,1,1);
        
        
        labelPlayer[1] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[15]);
        labelPlayer[1].setIcon(playerDiceIcon);
        //labelPlayer[1].setBounds(114, 327, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        placePlayerExtra(labelPlayer[1],Constants.HOTEL,4);
        
        
        labelPlayer[2] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[6]);
        labelPlayer[2].setIcon(playerDiceIcon);
        labelPlayer[2].setBounds(114, 127, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        placePlayerOffRole(labelPlayer[2],Constants.TRAIN,1);
        
        //labelPlayer.setBounds(114,227,46,46);
    }
    
    private void setupShotLabel() {
        for(int i = 0; i < shotcounters.length;i++) {
        	shotcounters[i] = new JLabel();
            ImageIcon shotIcon = new ImageIcon("src/shot.png");
            shotcounters[i].setIcon(shotIcon);
            shotcounters[i].setBounds(100+i*100,100+i*100,shotIcon.getIconWidth(),shotIcon.getIconHeight());
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
        
        for(int i = 0; i < shotcounters.length;i++) {
        	paneDeadwood.add(shotcounters[i],new Integer(3));
        }
        
    }
}
