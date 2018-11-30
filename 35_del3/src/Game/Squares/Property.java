package Game.Squares;

import Game.Player.Player;

public class Property extends Square {
    private int price;
    private boolean vacant;
    private Player owner;

    /**Constructor, creates an instance of the class: Property.
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

    /**Method applying changes to a players' balance depending on the vacancy of the property.
     *
     * @param player
     */
    public void landOn(Player player){
        super.landOn(player);
        player.getBalance().subPoints(price);
        if(!vacant){
            setSqMessage(getSqMessage() + "og skal betale husleje til " + owner.getName());

            owner.getBalance().addPoints(price);
        }
        else{
            setSqMessage(getSqMessage() + ", som er ledigt og køber derfor dette");
            setOwner(player);
            toggleVacant();
        }
    }

    @Override
    public String getSqMessage(){ return sqMessage;}

    /**Method swapping the boolean value of vacant.
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

    public void setOwner(Player owner){this.owner = owner;}

    public Player getOwner() {
        return owner;
    }

    public int getPrice() {return price;}
}