package GameLogic;

import Player.Player;

public class GameRules {
    public void passStart(Player player, int pastStart){
        player.setLocation(0+pastStart);
        player.getBalance().addPoints(2);
    }
}
