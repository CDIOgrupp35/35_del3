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
        super.landOn(player);
        sqMessage += ". Tryk \'OK\' eller enter for at trække et Chancekort";
        deck.drawCard().executeEffect(player);
    }
}
