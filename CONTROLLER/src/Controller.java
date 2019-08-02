package CONTROLLER.src;
import VIEW.src.*;
import MODEL.src.*;

public class Controller {

	private NumPlayerBox playerBox;
    private GUI ui;
    private Model game;
    private Controller c;
    private int chosenLocation;
    private int active_player;
    private String chosenRole;
    private int chosenRank;
    private char chosenPayment;
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
    
    public void setChosenRole(String s) {
    	this.chosenRole = s;
    }
    
    public String getChosenRole() {
    	return chosenRole;
    }
    
    public void setChosenRank(int i) {
    	this.chosenRank = i;
    }
    
    public int getChosenRank() {
    	return chosenRank;
    }
    
    
    public void setChosenLocation(int location) {
    	this.chosenLocation = location;
    }
    
    public int getChosenLocation() {
    	return chosenLocation;
    }
    
    public void setActivePlayer(int p) {
    	this.active_player = p;
    }
    
    public int getActivePlayer() {
    	return active_player;
    }
	public char getChosenPayment() {
		return chosenPayment;
	}

	public void setChosenPayment(char chosenPayment) {
		this.chosenPayment = chosenPayment;
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
    
    public void notifyFlipcard(int loc) {
    	ui.flipSceneCard(loc);
    }
    
    public void notifyPlayerMove() {
    	if(chosenLocation == 0) {
    		ui.placePlayerTrailers(active_player);
    	}
    	else if(chosenLocation == 1) {
    		ui.placePlayerCasting(active_player);
    	}
    	else {
    		ui.placePlayerOffRole(chosenLocation, 
    				active_player);
    	}
    }	
    
    public void notifyPlayerTookRole(boolean main) {
    	int cast = Character.getNumericValue(chosenRole.charAt(1));
    	if(main) {
    		ui.placePlayerRole(getActivePlayer(),
    				getGame().getActive_player().getLocation().getlocNum(),
    				cast+1,
    				((Set)getGame().getActive_player().getLocation()).getScene().getRoleSize());
    	}
    	else {
    		ui.placePlayerExtra(getActivePlayer(),
    				getGame().getActive_player().getLocation().getlocNum(),
    				cast+1);
    	}
    }

    public void notifyPlayerUpgraded(int rank) {
    	int currentRank = rank;
    	ui.upgradePlayer(active_player, currentRank);
    }

    public void notifyActingSuccess(Set l) {
        ui.removeShotCounters(l.getlocNum(), l.getShotcounters());
    }

    public void notifySceneWrap(int locnum) {
        ui.removeSceneCard(locnum);

        for (int i = 0; i < getGame().getPlayers().size(); i++) {
            getUi().updatePlayerInfo(getGame().getPlayers().get(i).getPlayer_num(), getGame().getPlayers().get(i).playerInfo());
        }

    }

    public void notifyEndDay(){
        for(int i =0; i < getGame().getPlayers().size();i++){
            ui.placePlayerTrailers(i+1);
            getUi().updatePlayerInfo(getGame().getPlayers().get(i).getPlayer_num(), getGame().getPlayers().get(i).playerInfo());
        }
        ui.enableCard();

    }

    public void notifyGameBox(String text) {
        ui.setGameplayText(text);
    }
}