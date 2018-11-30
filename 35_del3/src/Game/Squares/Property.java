package Game.Squares;

import Game.Player.Player;

public class Property extends Square {
    private int price;
    private boolean vacant;
    private Player owner;
    private boolean landedOn = false;
    private String oGSqMessage;

    /**
     * Constructor, creates an instance of the class: Property.
     *
     * @param sqNum
     * @param sqName
     * @param price
     */
    public Property(int sqNum, String sqName, int price){
        super(sqNum, sqName);
        vacant = true;
        this.price = price;
    }

    /**
     * Method applying changes to a players' balance depending on the vacancy of the property.
     *
     * @param player
     */
    public void landOn(Player player){
        player.getBalance().subPoints(price);
        if(!vacant){
            if (!landedOn) {
                setSqMessage(oGSqMessage + " og skal betale husleje til " + owner.getName());
                landedOn = true;
            }
            owner.getBalance().addPoints(price);
        }
        else{
           oGSqMessage = super.getSqMessage();
            setSqMessage(super.getSqMessage() + ", som er ledigt og køber derfor dette");


            setOwner(player);
            toggleVacant();
        }
    }

    /**
     * Method swapping the boolean value of vacant.
     *
     */
    public void toggleVacant(){
        if(vacant){
            vacant = false;
        }
        else{
            vacant = true;
        }
    }

    /**
     * Setter for owner
     *
     * @param owner
     */
    public void setOwner(Player owner){this.owner = owner;}

    /**
     * Getter for owner
     *
     * @return
     */
    public Player getOwner(){return this.owner;}

    /**
     * Getter for price
     *
     * @return
     */
    public int getPrice() {return price;}

}