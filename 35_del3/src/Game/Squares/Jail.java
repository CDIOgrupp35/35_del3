package Game.Squares;
import Game.Player.Player;

public class Jail extends Square {

    private int fine;

    public Jail(int sqNum, String sqName, int fine){
        super(sqNum,sqName);
        this.fine = fine;
    }

    public void landOn(Player player){
        super.landOn(player);
        setSqMessage(super.getSqMessage() + ". Ryk hen til FÆNGSEL. Når du starter din næste tur skal du betale 1M for at blive løsladt igen");
        player.setLocation(6);
    }
}
