package Game;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class DiceTest {

    private Dice diceTest = new Dice(1,6);
    private Dice diceTest2 = new Dice(2,10);


    /**
     * Testing the roll-method is generating numbers in the interval minRoll and maxRoll.
     */
    @RepeatedTest(500)
    void rollSidesTest() {
        int[] diceArray = diceTest.roll();

        int minRoll = 1;
        int maxRoll = diceTest.sides;

        for (int i = 0; i < diceArray.length; i++) {
            assertTrue(diceArray[i] >= minRoll && diceArray[i] <= maxRoll);
        }
    }

    /**
     * Testing that the return of roll-method, diceArray, is of size equal to number of dices.
     */
    @Test
    void rollTest() {
        int[] diceArray = diceTest2.roll();

        int noDice = 2; //In diceTest2, the int noDice is set to 2.

        assertTrue(diceArray.length == noDice);
    }

    /**
     * Testing that the sum-method correctly adds up the values of the diceArray.
     */
    @Test
    void sumTest() throws Exception {
        int[] diceArray = diceTest2.roll();

        diceArray[0] = 5;
        diceArray[1] = 6;

        diceTest2.sum(diceArray);

        assertEquals(diceTest2.sum(), 11);


    }

    /**
     * Testing that the roll-method is fair.
     */
}