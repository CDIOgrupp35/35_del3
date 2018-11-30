package Controllers;

import Stub.GameStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    GameStub testGame = new GameStub();

    @Test
    void playTurn() {
        testGame.playTurn(1);
        assertTrue(testGame.getPlayerLocaion(1) == 6);
    }

    @Test
    void playTurn2() {
        testGame.playTurn2();
        assertTrue(testGame.isSomethingHappened());
        assertTrue(testGame.getPlayerBalance(0) == 15);
    }

    @Test
    void endGame() {
        testGame.setPlayerBalance(0,0);
        assertTrue(testGame.endGame());

        testGame.setPlayerBalance(0,2);

        assertTrue(!(testGame.endGame()));
    }

    @Test
    void winner() {
        testGame.setPlayerBalance(0,15);
        testGame.setPlayerBalance(1,10);

        assertTrue(testGame.winner().equals("test2"));
    }
}