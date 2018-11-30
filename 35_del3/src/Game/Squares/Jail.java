package Game.Squares;
import Game.Player.Player;

public class Jail extends Square {

    private int fine;

    public Jail(int sqNum, String sqName, int fine){
        super(sqNum,sqName);
        this.fine = fine;
    }

    //TODO M1 bliver ikke betalt ved næste tur efter fængsel
    public void landOn(Player player){
        super.landOn(player);
        sqMessage = sqMessage + ". Ryk hen til FÆNGSEL. Når du starter din næste tur skal du betale 1M for at blive løsladt igen";
        player.setLocation(6);
    }
}