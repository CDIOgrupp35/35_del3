package Controllers;
import Player.*;

public class Game {
    private Dice masterDice = new Dice(1,6);
    private int winCon = 3000;
    private boolean play = true;

    public Game() {
    }

    /**
     * Passes the turn to the next player
     *
     * @param playerOne The player whose turn is next.
     * @param playerTwo The player whose turn is over.
     */
    public void turnSwitch(Player playerOne, Player playerTwo) {
        playerOne.setTurn(true);
        playerTwo.setTurn(false);
    }

    /**
     * The main turn method
     * <p>
     *     A method that plays the main game and prints out the proper strings
     * </p>
     *
     * @param playerOne The player whose turn it is.
     * @param playerTwo The player whose turn it isn't.
     * @param diceRoll The sum of the eyes of the roll.
     */
    public void playTurn(Player playerOne, Player playerTwo, int diceRoll) {


        System.out.println(playerOne.getName() + jText.get("balance") + playerOne.balance.getPoints());
        System.out.println(playerTwo.getName() + jText.get("balance") + playerTwo.balance.getPoints());
        if (diceRoll != 10) turnSwitch(playerTwo, playerOne);

    }

    /**
     * Checks if any player has won the game
     *
     * @param player1 A player in the game.
     * @param player2 A player in the game.
     */
    public void winGame(Player player1, Player player2) {
        if (player1.getBalance().getPoints() >= winCon) {
            play = false;
            System.out.println(player1.getName() + jText.get("win"));
        } else if (player1.getBalance().getPoints() >= winCon) {
            play = false;
            System.out.println(player2.getName() + jText.get("win"));
        }
    }

    /**
     * A method that prints whose turn it currently is.
     *
     * @param player1 A player in the game.
     * @param player2 A player in the game.
     */
    public void showTurn(Player player1, Player player2) {
        if (play) {
            if (player1.getIsTurn()) {
                System.out.println("\n " + player1.getName() + jText.get("turn"));
            } else if (player2.getIsTurn()) {
                System.out.println("\n " + player2.getName() + jText.get("turn"));
            }

        }
    }

    /**
     * A method that is getting called to control the game running.
     * <p>
     *     This method uses the other methods in the Controllers.Game() class to play the turn, print out whose turn it is and
     *     check if the win condition is met.
     * </p>
     *
     * @param input A player input to activate the roll.
     * @param player1 A player in the game.
     * @param player2 A player in the game.
     */
    public void playing(int input, Player player1, Player player2) {
            if (input == 1) {
                if (player1.getIsTurn()) {
                    masterDice.roll();
                    playTurn(player1, player2, masterDice.sum());
                }
                else {
                    masterDice.roll();
                    playTurn(player2, player1, masterDice.sum());
                }

                showTurn(player1, player2);
                winGame(player1, player2);

            }
        }
    public boolean getPlay(){return play;}
}