package Game;

import Game.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardTest {

    Player testPlayer1 = new Player("TestPlayer1",20);

    ChanceCard chanceCardTest = new ChanceCard("TestCard","AmazingTest",4);

    @Test
    void executeEffect() {
        chanceCardTest.setCardEffect(1);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getLocation() == 0);
        assertTrue(testPlayer1.getBalance().getPoints() == 22);

        chanceCardTest.setCardEffect(2);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getLocation() == 5);

        testPlayer1.setLocation(22);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getLocation() == 4);

        chanceCardTest.setCardEffect(3);
        testPlayer1.getBalance().setPoints(10);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getBalance().getPoints() == 8);

        chanceCardTest.setCardEffect(4);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getLocation() == 23);

        chanceCardTest.setCardEffect(5);
        testPlayer1.getBalance().setPoints(10);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getBalance().getPoints() == 12);

        chanceCardTest.setCardEffect(6);
        chanceCardTest.executeEffect(testPlayer1);

        assertTrue(testPlayer1.getLocation() == 6);

    }
}