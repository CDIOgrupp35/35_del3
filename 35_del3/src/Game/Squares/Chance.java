package Game.Squares;
import Game.ChanceCard;
import Game.ChanceDeck;
import Game.Player.Player;

public class Chance extends Square {

    private ChanceDeck deck;
    private String pulledCardText;
    private ChanceCard pulledCard;

    public Chance(int sqNum, String sqName, ChanceDeck deck){
        super(sqNum,sqName);
        this.deck = deck;
    }

    public void landOn(Player player){
        super.landOn(player);
        sqMessage = sqMessage + ". Tryk \'OK\' eller enter for at trække et Chancekort";
        pulledCard = deck.drawCard();
        pulledCardText = pulledCard.getCardText();
    }

    public String getpulledCardText() {
        return pulledCardText;
    }

    public void executeEffect(Player player) {
        pulledCard.executeEffect(player);
    }
}