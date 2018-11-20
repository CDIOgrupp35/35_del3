package Squares;

public class Start extends Square {

    private int reward;

    public Start(int sqNum, String sqName, int reward){
        super(sqNum, sqName);
        this.reward = reward;
    }

    public void landOn(Player player){
        player.balance.addPoints(reward);
        //TODO Hvad med når man passerer start? fængsel?
    }
}
