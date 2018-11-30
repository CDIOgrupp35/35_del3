package Game;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class DiceTest {

    private Dice diceTest1 = new Dice(1, 6);
    private Dice diceTest2 = new Dice(2, 10);


    /**
     * Testing the roll-method is generating numbers in the interval minRoll and maxRoll.
     */
    @RepeatedTest(500)
    void rollSidesTest() {
        diceTest1.roll();

        int minRoll = 1;
        int maxRoll = diceTest1.getSides();


        try {
            assertTrue(diceTest1.sum() >= minRoll && diceTest1.sum() <= maxRoll);
        } catch (Exception e) {
            e.printStackTrace();
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

        diceTest2.setFaceValue(0, 5);
        diceTest2.setFaceValue(1, 6);

        assertEquals(diceTest2.sum(), 11);

    }

    /**
     * Testing that the roll-method is fair, with a 4% margin of error and 60000 rolls.
     */
    @Test
    void testFairness() {
        int ones, twos, threes, fours, fives, sixes;
        ones = twos = threes = fours = fives = sixes = 0;

        int lowerBound = 9600;
        int upperBound = 10400;

        for (int i = 0; i < 60000; i++) {
            diceTest1.roll();

            int rollResult = diceTest1.getFaceValue(0); //rollResult is faceValue of diceArray index 0, since diceTest1 only has 1 dice.

            switch(rollResult) {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
                case 4:
                    fours++;
                    break;
                case 5:
                    fives++;
                    break;
                case 6:
                    sixes++;
                    break;
                default:
                    fail();
                    break;
            }

        }

        assertTrue((ones >= lowerBound) && (ones <= upperBound));
        assertTrue((twos >= lowerBound) && (twos <= upperBound));
        assertTrue((threes >= lowerBound) && (threes <= upperBound));
        assertTrue((fours >= lowerBound) && (fours <= upperBound));
        assertTrue((fives >= lowerBound) && (fives <= upperBound));
        assertTrue((sixes >= lowerBound) && (sixes <= upperBound));

    }
}