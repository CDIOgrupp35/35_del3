package Squares;

public class Jail extends Square {

    private int fine;

    public Jail(int sqNum, String sqName, int fine){
        super(sqNum,sqName);
        this.fine = fine;
    }

    public void landOn(Player player){
        player.setLocation(jail);
        //TODO implementer ingen penge hvis man passerer start?
    }

    public void bailJail(Player player){
        player.balance.subPoints(fine);
    }
}
