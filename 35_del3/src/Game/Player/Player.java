package Game.Player;

public class Player {
    /**
     *
     */
    private Balance balance;
    //private GameBoard gameBoard = new GameBoard();
    private boolean isTurn; // TODO should be removed and turn will be run by for loop now
    private String playerName;
    private int location;

    /** Constructor, creates a instance of the class: balance.
     *
     * @param playerName The name of the player.*/
    public Player(String playerName, int startBalance){
        this.playerName = playerName;
        this.balance = new Balance(startBalance);
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    /** Boolean for what player has the turn *
     *
     * @return the internal isTurn boolean
     */
    public boolean getIsTurn(){
        return isTurn;
    }

    /** Boolean for setting the turn to a player */
    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public Balance getBalance(){return balance;}

    /**
     * A string containing the player's name
     *
     * @return The player's name.
     */
    public String getName() {
        return playerName;
    }

}
