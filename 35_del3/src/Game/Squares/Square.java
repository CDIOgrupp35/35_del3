package Game.Squares;
import Game.Player.Player;

public abstract class Square {
    protected int sqNum;
    protected String sqName;
    protected int price;
    protected String sqMessage;
    protected boolean landedOn = false;

    protected Square(int sqNum, String sqName){
        this.sqNum = sqNum;
        this.sqName = sqName;
        sqMessage = ", du er landet på " + sqName;
        price = 0;
    }

    public void landOn(Player player){
    }

    public String getSqName(){return sqName;}

    public int getPrice() {
        return price;
    }

    public String getSqMessage(){ return sqMessage;}

    public void setSqMessage(String newMessage){
        sqMessage = newMessage;
    }

    public boolean getLandedOn(){return landedOn;}

    public void setLandedOn(boolean on){landedOn = on;}
}