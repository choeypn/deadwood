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
    
    public void ModelPlayerMove(Player currentPlayer,int location) {
    	active_player = currentPlayer;
    	if(active_player.getRole() != null) {
    		System.out.println("You are currently working in a role");
    		return;
    	}
    	// If the player has already moved, they cannot move again
    	if(active_player.getMoved()) {
    		System.out.println("You cannot move again this turn");
    		return;
    	}
    	// If the player has already worked, they cannot move again
    	if(active_player.getWorked()) {
    		System.out.println("You just finished working");
    		return;
    	}
    	// Movement location prompt
    	System.out.println("Where would you like to move? (Enter a number 0-11)");
    	System.out.println(" 0 - Trailers \n"
    			+ " 1 - Casting Office \n"
    			+ " 2 - Jail \n"
    			+ " 3 - Train Station \n"
    			+ " 4 - General Store \n"
    			+ " 5 - Saloon \n"
    			+ " 6 - Main Street \n"
    			+ " 7 - Secret Hideout \n"
    			+ " 8 - Ranch \n"
    			+ " 9 - Bank \n"
    			+ "10 - Church \n"
    			+ "11 - Hotel");
    	// If they try to move to the same location - maybe implement this later
    	// Try to move - catch if invalid movement
    	try {
    		int loc = location;
    		String previousLoc = active_player.getLocation().getName();
    		active_player.playerMove(gameboard.getLocation(loc));
    		System.out.println("Player successfully moved from "+previousLoc+" to "
				+active_player.getLocation().getName());
    		//flip the scene card up if location player entered is a Set location
    		if(gameboard.getLocation(loc) instanceof Set) {
    			((Set)gameboard.getLocation(loc)).getScene().setFlipped(true);
    			observer.notifyFlipcard(loc);
    		}
    		observer.notifyPlayerMove();
    	}
    	catch(MovementException e){
    		System.out.println("Invalid movement");
    	}
    	catch(NumberFormatException e) {
    		System.out.println("Input is not an integer");
    	}
    	catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("Index out of bound");
    	}
    }
    public void ModelPlayerTakeRole(Player currentPlayer,int num,char type) {
    	active_player = currentPlayer;
		//If player already has a role, player cannot take another role
		if(active_player.getRole() != null) {
			System.out.println("You cannot have more than one role");
			return;
		}						
		//Check if player is in a working Set location
		try {
			// If the scene is not active, we can't take a role there
			if (!((Set)active_player.getLocation()).getActive()) {
				System.out.println("This scene has wrapped");
				return;
			}
		// Display current scene information
		System.out.printf("Active scene : %s, Budget : %d \n",
				((Set)active_player.getLocation()).getScene().getName(),
				((Set)active_player.getLocation()).getScene().getBudget());
		System.out.println("Player chose to take role");
		System.out.printf("Here are the main roles :  %s \n",
				((Set)active_player.getLocation()).getScene().getRoleDetails());
		System.out.printf("Here are the side roles :  %s \n",
				((Set)active_player.getLocation()).getExtraDetails());
		System.out.println("Enter x# for extra roles or m# for main roles");
		//verify and assign role to player 
		active_player.playerTakeRole(type,num);
		System.out.println("Role "+active_player.getRole().getName()+" assigned!");
		active_player.setTookRole(true);
		observer.notifyPlayerTookRole(active_player.getRole().getMain());
		}
		catch(RoleException e) {
			System.out.println("Invalid input, role not assigned");
		}
		catch(ClassCastException e) {
			System.out.println("You are currently not in a Set location");
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("Invalid input, role not assigned");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid input, role not assigned");
		}
    }
    
}
