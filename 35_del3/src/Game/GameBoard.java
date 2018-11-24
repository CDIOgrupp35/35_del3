package Game;
import Game.Squares.*;

public class GameBoard {

    private Square[] squares = new Square[24];
    private String[] pNames = new String[]{"Burgerbaren", "Pizzaria","Slikbutikken","Iskiosken","Museet", "Bibloteket",
                                            "Skaterparken", "Svømmingpoolen", "Spillehallen", "Biografen", "Legetøjsbutikken",
                                            "Dyrehandlen", "Bowlinghallen", "Zoologisk Have", "Vandlandet", "Strandpromenaden"};
    private int[] pPrice = new int[]{1,1,1,1,2,2,2,2,3,3,3,3,4,4,5,5};

    public GameBoard(){
        int count = 0;
        for(int i = 0; i < squares.length; i++){
            if(i == 0){
                squares[i] = new UneventfulSq(i, "START");
            }else if (i == 3 || i == 9 || i == 15 || i == 21){
                squares[i] = new Chance(i, "CHANCE"); //TODO modify after Chance class have been implemented
            }else if (i == 6){
                squares[i] = new UneventfulSq(i, "PÅ BESØG");
            }else if(i == 12){
                squares[i] = new UneventfulSq(i, "GRATIS PARKERING");
            }else if (i == 18){
                squares[i] = new Jail(i,"FÆNGSEL", 1);
            }else{
                squares[i] = new Property(i, pNames[count], pPrice[count]);
                count ++;
            }
        }
    }

    public Square getSquare(int numer){
        return squares[numer];
    }

    public Square[] getSquares(){return squares;}
}
