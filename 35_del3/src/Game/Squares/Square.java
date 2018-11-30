package Game.Squares;
import Game.Player.Player;

public abstract class Square {
    protected int sqNum;
    protected String sqName;
    protected int price;
    protected String sqMessage;
    protected boolean landedOn = false;

    /**
     * Creating square numbers and names
     *
     * @param sqNum
     * @param sqName
     */
    protected Square(int sqNum, String sqName){
        this.sqNum = sqNum;
        this.sqName = sqName;
        sqMessage = ", du er landet på " + sqName;
        price = 0;
    }

    /**
     * player landing on square
     *
     * @param player
     */
    public void landOn(Player player){
    }

    /**
     * Getter for square Name
     *
     * @return
     */
    public String getSqName(){return sqName;}

    /**
     * Getter for Price
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter for SqMessage and then returning message
     *
     * @return
     */
    public String getSqMessage(){ return sqMessage;}

    /**
     * Setter for SqMessage
     *
     * @param newMessage
     */
    public void setSqMessage(String newMessage){
        sqMessage = newMessage;
    }

    /**
     * Getter for LandedOn
     *
     * @return
     */
    public boolean getLandedOn(){return landedOn;}

    /**
     * Setter for LandedOn
     *
     * @param on
     */
    public void setLandedOn(boolean on){landedOn = on;}
}