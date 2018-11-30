package Controllers;

import Game.*;
import Game.Player.*;
import Game.Squares.Chance;

public class Game {
    private Dice die = new Dice(1, 6);
    private boolean play = true;
    private Player[] players;
    private GameBoard board;
    private GUIController gui;

    public Game(GameBoard gBoard, GUIController gui) {
        board = gBoard;
        this.gui = gui;
    }

    /**
     * Creating amount of players and balance options for those
     *
     * @param input
     * @return
     */
    public Player[] setPlayers(int input) {
        players = new Player[input];
        int balance;

        switch (input) {
            case 2:
                balance = 20;
                break;
            case 3:
                balance = 18;
                break;
            case 4:
                balance = 16;
                break;
            default:
                balance = 0;
        }

        /**
         * Creating names for players
         *
         * @return
         */
        for (int i = 0; i < players.length; i++) {
            String name = gui.makeText("Venligst indtast dit navn");
            players[i] = new Player(name, balance);
        }
        return players;
    }

    /**
     * Rolls the die and moves the player
     *
     * @param player
     */
    public void playTurn(Player player) {
        die.roll();
        board.movePlayer(player, die.getFaceValue(0));
    }

    /**
     * Resolving what happens on squares
     * Updating players balance
     *
     * @param player
     */
    public void playTurn2(Player player) {
        if (!(board.getSquares()[player.getLocation()] instanceof Chance)) {
            board.getSquares()[player.getLocation()].landOn(player);
            gui.showMessage(player.getName() + board.getSquares()[player.getLocation()].getSqMessage());
        } else {
            Chance landedOn = (Chance) board.getSquares()[player.getLocation()];
            landedOn.landOn(player);
            gui.showMessage(player.getName() + landedOn.getSqMessage());
            gui.showMessage(landedOn.getpulledCardText());
            landedOn.executeEffect(player);
        }
        gui.updatePlayerBalance(players);
    }

    /**
     * Ending the game when a players balance is or gets below zero
     *
     * @param players
     * @return
     */
    public boolean endGame(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getBalance().getPoints() <= 0) {
                play = false;
                return true;
            }
        }
        return false;
    }

    /**
     * Stating which player has highest balance
     *
     * @param players
     * @return
     */
    public Player winner(Player[] players) {
        int i = 0;
        while (i < players.length) {
            int win = 0;
            for (int j = 0; j < players.length; j++) {
                if (i != j && players[i].getBalance().getPoints() > players[j].getBalance().getPoints()) {
                    win++;
                }
            }
            if (win == players.length - 1) {
                break;
            } else i++;
        }
        return players[i];
    }

    /**
     * Getter for gameBoard
     *
     * @return
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Getter for Play
     *
     * @return
     */
    public boolean getPlay() {
        return play;
    }

    /**
     * Setter for Play
     *
     * @param play
     */
    public void setPlay(boolean play) {
        this.play = play;
    }

    /**
     * Getter for Die
     *
     * @return
     */
    public Dice getDie() {
        return die;
    }
}