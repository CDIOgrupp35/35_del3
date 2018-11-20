package Squares;
import Player.Player;

public abstract class Square {
    protected int sqNum;
    protected String sqName;

    protected Square(int sqNum, String sqName){
        this.sqNum = sqNum;
        this.sqName = sqName;
    }

    protected void landOn(Player player){

    }
}
