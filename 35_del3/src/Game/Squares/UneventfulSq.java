package Game.Squares;
import Game.Player.Player;

public class UneventfulSq extends Square {

    /**
     * No effect on UneventfulSq
     *
     * @param sqNum
     * @param sqName
     */
    public UneventfulSq(int sqNum, String sqName){
        super(sqNum, sqName);
    }

    /**
     * Player turn starts or ends
     *
     * @param player
     */
    public void landOn(Player player){
        if (!(sqName.equalsIgnoreCase("Start")) && !landedOn) {
            setSqMessage(getSqMessage() +  ". Din tur er slut.");
            landedOn = true;
        }
    }
}