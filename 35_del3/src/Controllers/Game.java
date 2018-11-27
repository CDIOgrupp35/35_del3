package Controllers;
import java.util.Scanner;

import Game.*;
import Game.Player.*;

public class Game {
    private Dice die = new Dice(1,6);
    private boolean play = true;
    private Player[] players;
    private GameBoard board;
    private GUIController gui;

    public Game(GameBoard gBoard, GUIController gui) {
        board = gBoard;
        this.gui = gui;


    }

    public Player[] setPlayers(int input){
        Scanner scan = new Scanner(System.in); // TODO brug GUI
        players = new Player[input];
        int balance;

        switch (input){
            case 2: balance = 20; break;
            case 3: balance = 18; break;
            case 4: balance = 16; break;
            default: balance = 0;
        }

        for(int i = 0; i < players.length; i++){
            gui.showMessage("Venligst indtast dit navn");
            String name = scan.nextLine();
            players[i] = new Player(name,balance);
        }
        return players;
    }

    public void playTurn(Player player){
        gui.showMessage("Tryk enter, eller click 'OK' for at rulle med terningen");
        die.roll();
        board.movePlayer(player, die.getFaceValue(0));
        board.getSquares()[player.getLocation()].landOn(player);

    }

    public boolean endGame(Player[] players){
        for (int i = 0; i <players.length; i++){
            if(players[i].getBalance().getPoints() <= 0) {
                play = false;
                return true;
            }
        }
        return false;
    }

    public Player winner(Player[] players){
        int i = 0;
        while (i < players.length){
            int win = 0;
            for (int j = 0; j < players.length; j++){
                if (i!= j && players[i].getBalance().getPoints() > players[j].getBalance().getPoints()){ //TODO
                    win++;
                }
            }
            if (win == players.length-1){
                break;
            }
            else i++;
        }
        return players[i];
    }

    public GameBoard getBoard(){ return board;}

    public Player[] getPlayers() { return players;}

    public boolean getPlay(){return play;}

    public void setPlay(boolean play) {this.play = play;}

    public Dice getDie() {return die;}

    //    /**
//     * Passes the turn to the next player
//     *
//     * @param playerOne The player whose turn is next.
//     * @param playerTwo The player whose turn is over.
//     */
//    public void turnSwitch(Game.Player playerOne, Game.Player playerTwo) {
//        playerOne.setTurn(true);
//        playerTwo.setTurn(false);
//    }
//
//    /**
//     * The main turn method
//     * <p>
//     *     A method that plays the main game and prints out the proper strings
//     * </p>
//     *
//     * @param playerOne The player whose turn it is.
//     * @param playerTwo The player whose turn it isn't.
//     * @param diceRoll The sum of the eyes of the roll.
//     */
//    public void playTurn(Game.Player playerOne, Game.Player playerTwo, int diceRoll) {
//
//
//        System.out.println(playerOne.getName() + jText.get("balance") + playerOne.balance.getPoints());
//        System.out.println(playerTwo.getName() + jText.get("balance") + playerTwo.balance.getPoints());
//        if (diceRoll != 10) turnSwitch(playerTwo, playerOne);
//
//    }
//
//    /**
//     * Checks if any player has won the game
//     *
//     * @param player1 A player in the game.
//     * @param player2 A player in the game.
//     */
//    public void winGame(Game.Player player1, Game.Player player2) {
//        if (player1.getBalance().getPoints() >= winCon) {
//            play = false;
//            System.out.println(player1.getName() + jText.get("win"));
//        } else if (player1.getBalance().getPoints() >= winCon) {
//            play = false;
//            System.out.println(player2.getName() + jText.get("win"));
//        }
//    }
//
//    /**
//     * A method that prints whose turn it currently is.
//     *
//     * @param player1 A player in the game.
//     * @param player2 A player in the game.
//     */
//    public void showTurn(Game.Player player) {
//        if (play) {
//            gui_codebehind.GUI_BoardController.showMessage(player.getName() + "din tur"); //TODO fix this when gui is implemented
//
//        }
//    }
//
//    /**
//     * A method that is getting called to control the game running.
//     * <p>
//     *     This method uses the other methods in the Controllers.Game() class to play the turn, print out whose turn it is and
//     *     check if the win condition is met.
//     * </p>
//     *
//     * @param input A player input to activate the roll.
//     * @param player1 A player in the game.
//     * @param player2 A player in the game.
//     */
//    public void playing(int input, Game.Player player1, Game.Player player2) {
//            if (input == 1) {
//                if (player1.getIsTurn()) {
//                    masterDice.roll();
//                    playTurn(player1, player2, masterDice.sum());
//                }
//                else {
//                    masterDice.roll();
//                    playTurn(player2, player1, masterDice.sum());
//                }
//
//                showTurn(player1, player2);
//                winGame(player1, player2);
//
//            }
//        }
//    public boolean getPlay(){return play;}
}