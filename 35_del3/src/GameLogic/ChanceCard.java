package GameLogic;
import Player.*;

public class ChanceCard {
    Player player;
    GameRules gRule;
    String cardName;
    String CardText;
    int cardEffect;

    ChanceCard(String cardName, String cardText, int cardEffect){
        this.cardName = cardName;
        this.CardText = cardText;
        this.cardEffect = cardEffect;
    }

    public void setCardEffect(Player player){
        switch (cardEffect) {
            case 1:
                gRule.passStart(player, 0);
                break;
            case 2:
                gRule.movePlayer(player, 5);
                break;
            case 3:
                player.getBalance().subPoints(2);
        }
    }
}
