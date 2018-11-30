package Game.Squares;
import Game.Player.Player;

public class Jail extends Square {

    private int fine;

    /**
     * Method for inheritance
     *
     * @param sqNum
     * @param sqName
     * @param fine
     */
    public Jail(int sqNum, String sqName, int fine){
        super(sqNum,sqName);
        this.fine = fine;
    }

    /**
     * Method for showing sqMessage when ending in jail
     *
     * @param player
     */
    public void landOn(Player player){
        if (!landedOn) {
            setSqMessage(super.getSqMessage() + ". Ryk hen til FÆNGSEL. Når du starter din næste tur skal du betale 1M for at blive løsladt igen");
            landedOn = true;
        }
        player.setLocation(6);
    }
}