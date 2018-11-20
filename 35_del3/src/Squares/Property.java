package Squares;

public class Property extends Square {
    private int price;
    private boolean vacant;
    private Player owner;

    public Property(int sqNum, String sqName, int price){
        super(sqNum, sqName);
        vaccant = true;
        this.price = price;
    }

    public void landOn(Player player){
        player.balance.subPoints(price);
        if(!vacant){
            owner.balance.addPoints(price);
        }
        else{
            setOwner(player);
            toggleVacant();
        }
    }

    public void toggleVacant(){
        if(vacant){
            vacant = false;
        }
        else{
            vacant = true;
        }
    }

    public boolean isVacant() {return vacant;}

    public void setOwner(Player owner){this.owner = owner;}

    public Player getOwner(){return this.owner;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}


}
