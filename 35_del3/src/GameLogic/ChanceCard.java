package GameLogic;
import Player.*;
import Controllers.*;

public class ChanceCard {
    Player player;
    GameBoard gameboard;
    GameRules gRule;
    String cardName;
    String CardText;
    int cardEffect;

    ChanceCard(String cardName, String cardText, int cardEffect){
        this.cardName = cardName;
        this.CardText = cardText;
        this.cardEffect = cardEffect;
    }

    public void executeEffect(Player player){
        switch (cardEffect) {
            case 1:
                gRule.passStart(player, 0);
                break;
            case 2:
                gRule.movePlayer(player, 5);
                break;
            case 3:
                player.getBalance().subPoints(2);
                break;
            case 4:
                player.setLocation(23);//TODO Skal sende til Strandpromenaden
                break;
            case 5:
                player.getBalance().addPoints(2);
                break;
            case 6:
                player.setLocation(6);
                gameboard.getSquares()[6].landOn(player);
        }
    }
}
