package MODEL.src;

import java.util.ArrayList;

public class Model {

    private Board gameboard;
    ArrayList<Player> players;
    GameMaster gm;
    Player active_player;
    Die die = Die.getD();

    // Construct the model
    public Model() {
    }

    public void initModel(int num) {
        // Create number of players from the input
        players = new ArrayList<Player>();
        for(int i = 1;i <= num;i++) {
            players.add(new Player(i));
        }

        // Initialize the board - standard tile configuration
        gameboard = new Board();

        // Create a gamemaster, initialize total days to 3
        GameMaster gm = new GameMaster(3, gameboard, players);
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
}
