package Game.Player;

public class Player {
    private Balance balance;
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

    /**
     * Getter for location
     *
     * @return
     */
    public int getLocation() {
        return location;
    }

    /**
     * Setter for location
     *
     * @param location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Getter for balance
     *
     * @return
     */
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