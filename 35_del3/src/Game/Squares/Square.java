package Game.Squares;
import Game.Player.Player;

public abstract class Square {
    protected int sqNum;
    protected String sqName;
    protected int price;
    protected String sqMessage;

    protected Square(int sqNum, String sqName){
        this.sqNum = sqNum;
        this.sqName = sqName;
        price = 0;
    }
    public Square(){}

    public void landOn(Player player){
        sqMessage = player.getName() + ", du er landet på " + sqName + " ";
    }

    public String getSqName(){return sqName;}

    public int getPrice() {
        return price;
    }

    public String getSqMessage(){ return sqMessage;}

    public void setSqMessage(String newMessage){
        sqMessage = newMessage;
    }
}
