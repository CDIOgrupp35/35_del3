package Game.Squares;
import Game.ChanceDeck;
import Game.Player.Player;

public class Chance extends Square {

    private ChanceDeck deck;

    public Chance(int sqNum, String sqName, ChanceDeck deck){
        super(sqNum,sqName);
        this.deck = deck;
    }

    public void landOn(Player player){
        deck.drawCard().executeEffect(player);
    }
}
