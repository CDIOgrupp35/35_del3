package Game;
import Game.Player.*;

public class ChanceCard {
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
                player.setLocation(0);
                player.getBalance().addPoints(2);
                break;
            case 2:
                if(player.getLocation() + 5 < 23)
                    player.setLocation(player.getLocation()+5);
                else
                    player.setLocation(player.getLocation()+ 5 - 23);
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
        }
    }

    public String getCardText() {
        return CardText;
    }
}