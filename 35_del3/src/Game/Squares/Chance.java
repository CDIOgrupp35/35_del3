package Game.Squares;
import Game.ChanceCard;
import Game.ChanceDeck;
import Game.Player.Player;

public class Chance extends Square {

    private ChanceDeck deck;
    private String pulledCardText;
    private ChanceCard pulledCard;

    /**
     * Creating chanceDeck
     *
     * @param sqNum
     * @param sqName
     * @param deck
     */
    public Chance(int sqNum, String sqName, ChanceDeck deck){
        super(sqNum,sqName);
        this.deck = deck;
    }

    /**
     * Creating output (sqMessage) for when landing on chance
     *
     * @param player
     */
    public void landOn(Player player){
        setSqMessage(super.getSqMessage() + ". Tryk \'OK\' eller enter for at trække et Chancekort");
        pulledCard = deck.drawCard();
        pulledCardText = pulledCard.getCardText();
    }

    /**
     * Returning pulledCardText
     *
     * @return
     */
    public String getpulledCardText() {
        return pulledCardText;
    }

    /**
     * Executing chanceCard effect
     *
     * @param player
     */
    public void executeEffect(Player player) {
        pulledCard.executeEffect(player);
    }
}