package Game.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    Balance balanceTest = new Balance(0);

    /**
     * Testing the addPoints method
     */
    @Test
    void addPointsTest() {
        balanceTest.addPoints(5);

        assertEquals(balanceTest.getPoints(), 5);

    }

    /**
     * Testing the subPoints method
     */
    @Test
    void subPointsTest() {
        balanceTest.setPoints(10);

        balanceTest.subPoints(5);

        assertEquals(balanceTest.getPoints(), 5);
    }
}