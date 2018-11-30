package Stub;

import Game.Player.Player;

public class GameStub {

    private String[] players;
    private int[] playerLocation;
    private int[] playerBalance;
    private boolean play = true;
    private boolean somethingHappened = false;

    public  GameStub() {
        setPlayers();
    }

    private String[] setPlayers() {
        players = new String[3];
        playerLocation = new int[3];
        playerBalance = new int[3];
        for (int i = 0; i < players.length; i++) {
            players[i] = "test" + i;
            playerLocation[i] = 0;
            playerBalance[i] = 20;
        }
        return players;
    }

    public void playTurn(int i) {
        playerLocation[i] += 6;
    }

    public void playTurn2() {
        somethingHappened = true;
        playerBalance[0] -= 5;
    }

    public int getPlayerBalance(int i) {
        return playerBalance[i];
    }

    public boolean isSomethingHappened() {
        return somethingHappened;
    }

    public boolean endGame() {
        for (int i = 0; i < players.length; i++) {
            if (playerBalance[i] <= 0) {
                play = false;
                return true;

            }
        }
        return false;
    }

    public String winner() {
        int i = 0;
        while(i < players.length) {
            int win = 0;
            for (int j = 0; j < players.length; j++) {
                if (i != j && playerBalance[i] > playerBalance[j]) {
                    win++;
                }
            }
            if (win == players.length-1) {
                break;
            } else i++;
        }
        return players[i];
    }

    public void setPlayerBalance(int i, int j) {
        this.playerBalance[i] = j;
    }

    public int getPlayerLocaion(int i) {
        return this.playerLocation[i];
    }
}
