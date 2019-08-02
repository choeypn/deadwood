package MODEL.src;

import java.util.ArrayList;
import CONTROLLER.src.*;
public class Model {

    private Board gameboard;
    ArrayList<Player> players;
    GameMaster gm;
    Player active_player;
    Die die = Die.getD();
    private Controller observer;

    // Construct the model
    public Model(Controller c) {
        this.observer = c;
    }

    public void initModel(int num) {
        // Create number of players from the input
        players = new ArrayList<Player>();
        for(int i = 1;i <= num;i++) {
            players.add(new Player(i));
            players.get(i-1).setObserver(observer);
        }

        // Initialize the board - standard tile configuration
        gameboard = new Board();
        gameboard.setObserver(observer);

        // Create a gamemaster, initialize total days to 3
        GameMaster gm = new GameMaster(3, gameboard, players);
        gm.setObserver(observer);
        this.gm = gm;
        active_player = players.get(0);
    }

    public void nextPlayer() {
    	active_player.setMoved(false);
    	active_player.setUpgraded(false);
    	players.remove(0);
    	players.add(active_player);
    	active_player = players.get(0);
    }

    // Getters
    public Board getGameboard() {
        return gameboard;
    }

    public Die getDie() {
        return die;
    }

    public Player getActive_player() {
        return active_player;
    }

    public GameMaster getGm() {
        return gm;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    // Setters
    public void setActive_player(Player active_player) {
        this.active_player = active_player;
    }

    public void setGameboard(Board gameboard) {
        this.gameboard = gameboard;
    }

    public void setGm(GameMaster gm) {
        this.gm = gm;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void ModelPlayerRehearse(Player currentPlayer) {
    	active_player = currentPlayer;
		if (active_player.getWorked() == true) {
			observer.notifyGameBox("You have already worked this turn");
			return;
		}

		//Check if the player just took the role
		if(active_player.getTookRole() == true) {
			observer.notifyGameBox("You just took a role in this turn");
			return;
		}

		// Try to rehearse, catch if the player is not allowed to rehearse
		try {
			active_player.playerRehearse();
			observer.notifyGameBox("1 practice chip added");
		}
		catch (RehearsalException e){
			observer.notifyGameBox("You cannot rehearse \n");
		}
		return;
	}

    public void ModelPlayerMove(Player currentPlayer,int location) {
    	active_player = currentPlayer;
    	if(active_player.getRole() != null) {
			observer.notifyGameBox("You are currently working in a role");
    		return;
    	}
    	// If the player has already moved, they cannot move again
    	if(active_player.getMoved()) {
			observer.notifyGameBox("You cannot move again this turn");
    		return;
    	}
    	// If the player has already worked, they cannot move again
    	if(active_player.getWorked()) {
			observer.notifyGameBox("You just finished working");
    		return;
    	}
    	// Movement location prompt
    	// If they try to move to the same location - maybe implement this later
    	// Try to move - catch if invalid movement
    	try {
    		int loc = location;
    		String previousLoc = active_player.getLocation().getName();
    		active_player.playerMove(gameboard.getLocation(loc));

    		//flip the scene card up if location player entered is a Set location
    		if(gameboard.getLocation(loc) instanceof Set) {
    			((Set)gameboard.getLocation(loc)).getScene().setFlipped(true);
				// Display current scene information
				String s = "";
				s += "<html>Here are the main roles : <br/> "+((Set)active_player.getLocation()).getScene().getRoleDetails()+"\n<br/>";
				s += "Here are the side roles : <br/> "+((Set)active_player.getLocation()).getExtraDetails()+"\n</html>";



				observer.notifyGameBox(s);
    			observer.notifyFlipcard(loc);
    		}
    		observer.notifyPlayerMove();
    	}
    	catch(MovementException e){
			observer.notifyGameBox("Invalid movement");
    	}
    	catch(NumberFormatException e) {

    	}
    	catch(ArrayIndexOutOfBoundsException e) {

    	}
    }
    public void ModelPlayerTakeRole(Player currentPlayer,int num,char type) {
    	active_player = currentPlayer;
		//If player already has a role, player cannot take another role
		if(active_player.getRole() != null) {
			observer.notifyGameBox("You cannot have more than one role");
			return;
		}						
		//Check if player is in a working Set location
		try {
			// If the scene is not active, we can't take a role there
			if (!((Set)active_player.getLocation()).getActive()) {
				observer.notifyGameBox("This scene has wrapped");
				return;
			}

		//verify and assign role to player
		active_player.playerTakeRole(type,num);
		active_player.setTookRole(true);
		observer.notifyPlayerTookRole(active_player.getRole().getMain());
		}
		catch(RoleException e) {
			observer.notifyGameBox("Invalid input, role not assigned");
		}
		catch(ClassCastException e) {
			observer.notifyGameBox("You are currently not in a Set location");
		}
		catch(StringIndexOutOfBoundsException e) {
			observer.notifyGameBox("Invalid input, role not assigned");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			observer.notifyGameBox("Invalid input, role not assigned");
		}
    }
    
    public void ModelPlayerUpgrade(Player currentPlayer,int rank,char type) {
    	active_player = currentPlayer;
		//check if the player is at Casting Office
		if(active_player.getLocation() instanceof CastingOffice == false) {
			observer.notifyGameBox("You are currently not at Casting Office");
			return;
		}
		//check if the player already upgraded in his turn 
		if(active_player.getUpgraded() == true) {
			observer.notifyGameBox("You already upgraded this round");
			return;
		}

		try {
			gm.upgradePlayer(active_player,type,rank);
			observer.notifyPlayerUpgraded(active_player.getRank());
		}
		catch(UpgradeException e) {
			observer.notifyGameBox("Rank upgrade failed, new rank unassignned");
		}
		catch(NumberFormatException e) {
		}
		catch(ArrayIndexOutOfBoundsException e) {
		}
		catch(StringIndexOutOfBoundsException e) {
			observer.notifyGameBox("Invalid input");
		}	
    }
    
    public void ModelPlayerAct(Player currentPlayer) {
    	active_player = currentPlayer;
		// Check if the player has a role
		if (active_player.getRole() == null) {
			observer.notifyGameBox("You have no role, you can not act");
			return;
		}
		// If the player has already worked or rehearsed, they cannot act
		if(active_player.getWorked()) {
			observer.notifyGameBox("You have already worked - can not act");
			return;
		}
		// Catch the movement case
		if(active_player.getMoved() == true) {
			observer.notifyGameBox("You can not act this turn");
			return;
		}
		//Check if the player just took the role
		if(active_player.getTookRole() == true) {
			observer.notifyGameBox("You just took a role in this turn");
			return;
		}
		// Act!
		boolean	success = active_player.playerAct(die);
		boolean main_role = active_player.getRole().getMain();
		Currency payout;
		// Success
		if (success) {
			// If on a main role
			if (main_role) {
				observer.notifyGameBox("Success - You received 2 credits!");
				payout = new Currency(0, 2);
			} // If on off card role
			else {
				observer.notifyGameBox("Success - You received 1 dollar and 1 credit!");
				payout = new Currency(1, 1);
			}
			//remove one shot counter when succeeded
			observer.notifyActingSuccess((Set)(active_player.getLocation()));
			gm.removeShotCounter((Set)active_player.getLocation());


			// If the last shot counter was removed, we use the GM for wrapping
			if(!((Set)active_player.getLocation()).getActive()) {

				gm.wrapSet(((Set)active_player.getLocation()));
				observer.notifySceneWrap(((Set)active_player.getLocation()).getlocNum());

				if(gm.checkActive() == 1) {
					gm.endDay();
					observer.notifyEndDay();
					if(gm.getGame_days() == 0){

						String gamebox = "<html>";
						int[] scores = gm.endGame();
						for(int i = 0; i < players.size(); i++) {
							//System.out.printf("Player %d - Score %d \n", players.get(i).getPlayer_num(), scores[i]);
							gamebox += "Player " + players.get(i).getPlayer_num() + " - Score " + scores[i] + " \n<br/>";
						}
						gamebox += "</html>";
						observer.notifyGameBox(gamebox);
					}
				}
			}
		}

		// Failure
		else {

			// If on a main role
			if (main_role) {
				observer.notifyGameBox("Failed - You received nothing!");
			payout = new Currency(0, 0);
			} // If on off card role
			else {
				observer.notifyGameBox("Failed - You received 1 dollar!");
				payout = new Currency(1, 0);
			}
		}
		// Player payout
		gm.payPlayer(active_player, payout);
		active_player.setWorked(true);
    }	
}
