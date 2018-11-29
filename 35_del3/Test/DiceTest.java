//import Game.Dice;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;


//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

class DiceTest {


//    private Dice testDice = new Dice(2, 6);
//
//    /** test if the roll() method generates TWO random numbers between 1 and 6, repeated 500 times to make sure
//    @<expectedResult> all tests return true
//    @<actualResult> all tests returned true */
//    @RepeatedTest(500)
//    void testRoll() {
//        testDice.roll();
//
//
//        assertTrue(testDice.getFaceValue(1) < 6 && testDice.getFaceValue(1) > 1);
//        assertTrue(testDice.getFaceValue(0) < 6 && testDice.getFaceValue(0) > 1);
//
//    }
//    /** test if the rolls are "fair", using the same criteria as the assignment handed in this past monday.
//     * Only testing getFacevalue1 since it is identical to getFaceValue2
//    60000 rolls, 4% margin of error.
//    This test the same as our group's answer of the earlier assignment this week.
//    @<expectedResult> all rolls are spread evenly and fairly within a 4% margin of error.
//    @<actualResult> successful spread of values. */
//    @Test
//    void testFairness() {
//        int ones, twos, threes, fours, fives, sixes;
//        ones = twos = threes = fours = fives = sixes = 0;
//
//        int lowerBound = 9600;
//        int upperBound = 10400;
//
//        for(int i = 0; i < 60000; i++) {
//            testDice.roll();
//
//            int rollResult = testDice.getFaceValue(0);
//
//            int rollResult = testDice.getFaceValue1();
//
//
//            switch(rollResult) {
//                case 1:
//                    ones++;
//                    break;
//                case 2:
//                    twos++;
//                    break;
//                case 3:
//                    threes++;
//                    break;
//                case 4:
//                    fours++;
//                    break;
//                case 5:
//                    fives++;
//                    break;
//                case 6:
//                    sixes++;
//                    break;
//                default:
//                    fail();
//                    break;
//            }
//        }
//        assertTrue((ones >= lowerBound) && (ones <= upperBound));
//        assertTrue((twos >= lowerBound) && (twos <= upperBound));
//        assertTrue((threes >= lowerBound) && (threes <= upperBound));
//        assertTrue((fours >= lowerBound) && (fours <= upperBound));
//        assertTrue((fives >= lowerBound) && (fives <= upperBound));
//        assertTrue((sixes >= lowerBound) && (sixes <= upperBound));
//
//    }
//
//    /** Testingg the addition of the Game.Dice.Sum method with set-values
//    @<expectedResult> test returns true, addition of two integers
//    @<actualResult> test returned true, successful addition of two integers */
//    @Test
//    void testSum() {
//
//        testDice.setFaceValue(0, 1);
//        testDice.setFaceValue(1, 1);
//
//        try {
//            assertEquals(2, testDice.sum());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        testDice.setFaceValue(0, 6);
//        testDice.setFaceValue(1, 6);
//        try {
//            assertEquals(12, testDice.sum());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        testDice.setFaceValue(0, 1073741823);
//        testDice.setFaceValue(1, 1073741824);
//        try {
//            assertEquals(2147483647, testDice.sum());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}