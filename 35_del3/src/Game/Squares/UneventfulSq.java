package Game.Squares;
import Game.Player.Player;

public class UneventfulSq extends Square {

    public UneventfulSq(int sqNum, String sqName){
        super(sqNum, sqName);
    }

    public void landOn(Player player){
        super.landOn(player);
        if (!(sqName.equalsIgnoreCase("Start"))) {
            setSqMessage(getSqMessage() +  ". Din tur er slut.");
        }
    }
}
