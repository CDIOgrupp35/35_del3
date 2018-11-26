package Game.Squares;
import Game.Player.Player;

public class Jail extends Square {

    private int fine;

    public Jail(int sqNum, String sqName, int fine){
        super(sqNum,sqName);
        this.fine = fine;
    }

    public void landOn(Player player){
        player.setLocation(6);
    }
}
