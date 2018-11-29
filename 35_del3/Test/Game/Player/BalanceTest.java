package Game.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    Balance balanceTest = new Balance(0);

    @Test
    void addPointsTest() {
        balanceTest.addPoints(5);

        assertEquals(balanceTest.getPoints(), 5);

    }

    @Test
    void subPointsTest() {

    }
}