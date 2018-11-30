package Game.Squares;
import Game.Player.Player;

public class UneventfulSq extends Square {

    public UneventfulSq(int sqNum, String sqName){
        super(sqNum, sqName);
    }

    public void landOn(Player player){
        if (!(sqName.equalsIgnoreCase("Start")) && !landedOn) {
            setSqMessage(getSqMessage() +  ". Din tur er slut.");
            landedOn = true;
        }
    }
}