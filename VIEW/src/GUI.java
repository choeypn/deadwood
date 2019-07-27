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
    }
    private void setupGameBoardLabel() {
        labelGameBoard = new JLabel();
        iconGameBoard = new ImageIcon(VIEWConstants.GAME_BOARD_IMAGE);
        labelGameBoard.setIcon(iconGameBoard);
        labelGameBoard.setBounds(0, 0, iconGameBoard.getIconWidth(), 
iconGameBoard.getIconHeight());
        setSize(592, 506);
// Set the size of the GUI
    }
    private void setupCardsLabel() {
        labelCard[Constants.TRAIN] = new JLabel();
        ImageIcon cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[0]);
        labelCard[Constants.TRAIN].setIcon(cardIcon);
        labelCard[Constants.TRAIN].setBounds(20, 65, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.TRAIN].setOpaque(true);
        
        labelCard[Constants.SECRET] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[15]);
        labelCard[Constants.SECRET].setIcon(cardIcon);
        labelCard[Constants.SECRET].setBounds(27, 732, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.SECRET].setOpaque(true);


        labelCard[Constants.JAIL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[22]);
        labelCard[Constants.JAIL].setIcon(cardIcon);
        labelCard[Constants.JAIL].setBounds(282, 28, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.JAIL].setOpaque(true);
        
        labelCard[Constants.GENERAL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[34]);
        labelCard[Constants.GENERAL].setIcon(cardIcon);
        labelCard[Constants.GENERAL].setBounds(371, 281, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.GENERAL].setOpaque(true);
    
        labelCard[Constants.RANCH] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[34]);
        labelCard[Constants.RANCH].setIcon(cardIcon);
        labelCard[Constants.RANCH].setBounds(254, 476, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.RANCH].setOpaque(true);
    
        labelCard[Constants.SALOON] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[39]);
        labelCard[Constants.SALOON].setIcon(cardIcon);
        labelCard[Constants.SALOON].setBounds(631, 281, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.SALOON].setOpaque(true);
        
        labelCard[Constants.BANK] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[1]);
        labelCard[Constants.BANK].setIcon(cardIcon);
        labelCard[Constants.BANK].setBounds(622, 473, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.BANK].setOpaque(true);
        
        labelCard[Constants.CHURCH] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[9]);
        labelCard[Constants.CHURCH].setIcon(cardIcon);
        labelCard[Constants.CHURCH].setBounds(622, 733, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.CHURCH].setOpaque(true);
        
        labelCard[Constants.MAIN] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[17]);
        labelCard[Constants.MAIN].setIcon(cardIcon);
        labelCard[Constants.MAIN].setBounds(970, 28, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.MAIN].setOpaque(true);
        
        labelCard[Constants.HOTEL] = new JLabel();
        cardIcon = new ImageIcon(VIEWConstants.CARDS_IMAGE[26]);
        labelCard[Constants.HOTEL].setIcon(cardIcon);
        labelCard[Constants.HOTEL].setBounds(970, 740, cardIcon.getIconWidth() + 2, cardIcon.getIconHeight());
        labelCard[Constants.HOTEL].setOpaque(true);
        
    }
    
    private void setupPlayerLabel() {
    	labelPlayer[0] = new JLabel();
    	ImageIcon playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[3]);
        labelPlayer[0].setIcon(playerDiceIcon);
        labelPlayer[0].setBounds(114, 227, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        
        labelPlayer[1] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[15]);
        labelPlayer[1].setIcon(playerDiceIcon);
        labelPlayer[1].setBounds(114, 327, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        
        labelPlayer[2] = new JLabel();
        playerDiceIcon = new ImageIcon(VIEWConstants.DICE_IMAGE[6]);
        labelPlayer[2].setIcon(playerDiceIcon);
        labelPlayer[2].setBounds(114, 127, playerDiceIcon.getIconWidth(), playerDiceIcon.getIconHeight());
        
        
        //labelPlayer.setBounds(114,227,46,46);
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
    }
}
