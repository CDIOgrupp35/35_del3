package GameLogic;
import Controllers.*;
import Player.*;

public class GameRules {
    Game game = new Game();
    GameBoard gameboard = new GameBoard();
    public void passStart(Player player, int pastStart){
        player.setLocation(0+pastStart);
        player.getBalance().addPoints(2);
    }

    public void movePlayer(Player player, int roll){
        player.setLocation(player.getLocation() + roll);
        if(player.getLocation()> gameboard.getSquares().length)
            passStart(player, player.getLocation() - gameboard.getSquares().length);
    }

    public boolean endGame(Player[] players){
        for (int i = 0; i <players.length; i++){
            if(players[i].getBalance().getPoints() <= 0)
                return true;
        }
        return false;

    }


}
