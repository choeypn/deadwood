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
			System.out.println("You have already worked this turn");
			return;
		}

		//Check if the player just took the role
		if(active_player.getTookRole() == true) {
			System.out.println("You just took a role in this turn");
			return;
		}

		// Try to rehearse, catch if the player is not allowed to rehearse
		try {
			active_player.playerRehearse();
			System.out.println("1 practice chip added");
		}
		catch (RehearsalException e){
			System.out.println("You cannot rehearse \n");
		}
		return;
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
    
    public void ModelPlayerUpgrade(Player currentPlayer,int rank,char type) {
    	active_player = currentPlayer;
		//check if the player is at Casting Office
		if(active_player.getLocation() instanceof CastingOffice == false) {
			System.out.println("You are currently not at Casting Office");
			return;
		}
		//check if the player already upgraded in his turn 
		if(active_player.getUpgraded() == true) {
			System.out.println("You already upgraded this round");
			return;
		}
		//Display upgrade information
		System.out.println("The cost to upgrade is shown below:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Pay dollars OR credits to upgrade");
		System.out.println("Rank 2 : Dollars  4, Credits  5");
		System.out.println("Rank 3 : Dollars 10, Credits 10");
		System.out.println("Rank 4 : Dollars 18, Credits 15");
		System.out.println("Rank 5 : Dollars 28, Credits 20");
		System.out.println("Rank 6 : Dollars 40, Credits 25");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("Enter #d for rank with Dollar payment method");
		System.out.println("Enter #c for rank with Crredit payment method");
		//verify and upgrade player's rank 
		try {
			gm.upgradePlayer(active_player,type,rank);
			observer.notifyPlayerUpgraded(active_player.getRank());
		}
		catch(UpgradeException e) {
			System.out.println("Rank upgrade failed, new rank unassignned");
		}
		catch(NumberFormatException e) {
			System.out.println("Input is not an integer");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bound");
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("Invalid input");
		}	
    }
    
    public void ModelPlayerAct(Player currentPlayer) {
    	active_player = currentPlayer;
		// Check if the player has a role
		if (active_player.getRole() == null) {
			System.out.println("You have no role, you can not act");
			return;
		}
		// If the player has already worked or rehearsed, they cannot act
		if(active_player.getWorked()) {
			System.out.println("You have already worked - can not act");
			return;
		}
		// Catch the movement case
		if(active_player.getMoved() == true) {
			System.out.println("You can not act this turn");
			return;
		}
		//Check if the player just took the role
		if(active_player.getTookRole() == true) {
			System.out.println("You just took a role in this turn");
			return;
		}
		// Act!
		boolean	success = active_player.playerAct(die);
		boolean main_role = active_player.getRole().getMain();
		Currency payout;
		// Success
		if (success) {
			System.out.println("Acting succeeded!!!");
			// If on a main role
			if (main_role) {
				System.out.println("You received 2 credits!");
				payout = new Currency(0, 2);
			} // If on off card role
			else {
				System.out.println("You received 1 dollar and 1 credit!");
				payout = new Currency(1, 1);
			}
			//remove one shot counter when succeeded
			observer.notifyActingSuccess((Set)(active_player.getLocation()));
			gm.removeShotCounter((Set)active_player.getLocation());


			// If the last shot counter was removed, we use the GM for wrapping
			if(!((Set)active_player.getLocation()).getActive()) {
				System.out.println("Scene "+
						((Set)active_player.getLocation()).getScene().getName()+" finished!");
				System.out.println("It's a wrap!!");
				gm.wrapSet(((Set)active_player.getLocation()));

				observer.notifySceneWrap(((Set)active_player.getLocation()).getlocNum());
			}
		}

		// Failure
		else {
			System.out.println("Acting failed!!!");
			// If on a main role
			if (main_role) {
			System.out.println("You received nothing!");
			payout = new Currency(0, 0);
			} // If on off card role
			else {
				System.out.println("You received 1 dollar!");
				payout = new Currency(1, 0);
			}
		}
		// Player payout
		gm.payPlayer(active_player, payout);
		active_player.setWorked(true);
    }	
}
