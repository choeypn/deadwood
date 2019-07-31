package CONTROLLER.src;
import VIEW.src.*;
import MODEL.src.*;

public class Controller {

	private NumPlayerBox playerBox;
    private GUI ui;
    private Model game;
    private Controller c;
    private int chosenLocation;

    public Controller() {

    }

    public GUI getUi() {
        return ui;
    }

    public Model getGame() {
        return game;
    }
    
    public NumPlayerBox getPlayerBox() {
    	return playerBox;
    }

    public void setGame(Model game) {
        this.game = game;
    }

    public void setUi(GUI ui) {
        this.ui = ui;
    }

    public void setPlayerBox(NumPlayerBox pb) {
    	this.playerBox = pb;
    }
    public void setC(Controller c) {
        this.c = c;
    }

    public Controller getC() {
        return c;
    }
    
    
    public void setChosenLocation(int location) {
    	this.chosenLocation = location;
    }
    
    public int getChosenLocation() {
    	return chosenLocation;
    }


    public void notifyStartDay(int[] sceneNum) {

        // Update shot counters
        ui.turnOnShotCounters();

        // Setup scene cards
        for(int i = 2; i <= 11; i++) {
        	ui.placeSceneCard(i, sceneNum[i-2]);
        }
        // Move all the players to trailers
        for(int i = 0; i <= game.getPlayers().size();i++) {
        	ui.placePlayerTrailers(i);
        }
     

    }
    
    
}