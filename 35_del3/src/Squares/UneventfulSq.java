package Squares;


public class UneventfulSq extends Square {

    public UneventfulSq(int sqNum, String sqName){
        super(sqNum, sqName);
    }

    public void landOn(Player player){
        System.out.println("Take a break");
    }


}
