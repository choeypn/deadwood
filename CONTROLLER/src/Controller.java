package CONTROLLER.src;
import VIEW.src.*;
import MODEL.src.*;

public class Controller {

	private NumPlayerBox playerBox;
    private GUI ui;
    private Model game;
    private Controller c;

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
}