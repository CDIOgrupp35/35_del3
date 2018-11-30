package Game;
import Game.Player.Player;
import Game.Squares.*;

public class GameBoard {

    /**
     * Creating string for names of squares and stating price
     *
     */
    private Square[] squares = new Square[24];
    private String[] pNames = new String[]{"Burgerbaren", "Pizzaria","Slikbutikken","Iskiosken","Museet", "Bibloteket",
                                            "Skaterparken", "Svømmingpoolen", "Spillehallen", "Biografen", "Legetøjsbutikken",
                                            "Dyrehandlen", "Bowlinghallen", "Zoologisk Have", "Vandlandet", "Strandpromenaden"};
    private int[] pPrice = new int[]{1,1,1,1,2,2,2,2,3,3,3,3,4,4,5,5};
    private ChanceDeck cDeck = new ChanceDeck();

    /**
     * Setting up squares and shuffling c.Deck
     *
     */
    public GameBoard(){
        setUpSquares();
        cDeck.shuffleCards();
    }

    /**
     * Method to assign squares information
     *
     */
    private void setUpSquares(){
        int count = 0;
        for(int i = 0; i < squares.length; i++){
            if(i == 0){
                squares[i] = new UneventfulSq(i, "START");
            }else if (i == 3 || i == 9 || i == 15 || i == 21){
                squares[i] = new Chance(i, "CHANCE", cDeck);
            }else if (i == 18){
                squares[i] = new Jail(i,"FÆNGSEL", 1);
            }else if(i == 12){
                squares[i] = new UneventfulSq(i, "GRATIS PARKERING");
            }else if (i == 6){
                squares[i] = new UneventfulSq(i, "PÅ BESØG");
            }else{
                squares[i] = new Property(i, pNames[count], pPrice[count]);
                count ++;
            }
        }
    }

    /**
     * Method for giving player M2 for passing or landing on start
     *
     * @param player
     * @param pastStart
     */
    public void passStart(Player player, int pastStart){
        player.setLocation(0+pastStart);
        if(!squares[0].getLandedOn()) {
            squares[player.getLocation()].setSqMessage(squares[player.getLocation()].getSqMessage() + " Du er landet på eller har passeret start. Modtag 2M");
        squares[0].setLandedOn(true);
        }
        player.getBalance().addPoints(2);
    }

    /**
     * Getter and setter for location
     *
     * @param player
     * @param roll
     */
    public void movePlayer(Player player, int roll) {
        player.setLocation(player.getLocation() + roll);
        if (player.getLocation() >= squares.length)
            passStart(player, player.getLocation() - squares.length);
    }

    /**
     * Getter for squares
     *
     * @return
     */
    public Square[] getSquares(){return squares;}
}