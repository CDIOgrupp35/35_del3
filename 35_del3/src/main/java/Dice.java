
import com.sun.jdi.IntegerValue;

import java.util.Random;

public class Dice {
    private Random random = new Random();
    private int sides;
    private int diceAmount;
    private int diceArray[] = new int[diceAmount];

    /**
     * Constructs a Dice object
     *
     * @param noDice the number of dice you wish to have
     * @param noSide the number of sides you wish each dice to have
     */
    public Dice (int noDice, int noSide ) {
        sides = noSide;
        diceAmount = noDice;
    }

    /**
     * rolls dice
     *
     * @return an int[] array containing the face values of the dice.
     */
    public int[] roll() {
        for(int i = 0; i <= diceAmount; i++) {
            diceArray[i] = random.nextInt(sides) + 1;
        }
        return diceArray;
    }


    /**
     * loops through the diceArray array and sums all the values
     *
     * @return the sum of all values in diceArray
     * @throws Exception Sum is too large.
     */
    public int sum() throws Exception {
        int sum = 0;
        for(int i = 0; i < diceArray.length; i++) {
            sum += diceArray[i];
        }
        boolean positive = true;
        for (int i = 0; i < diceArray.length; i++) {
            if (diceArray[i] < 0) {
                positive = false;
            }
        }
        if(positive && sum < 0)  {
            throw new Exception("Error: the sum is too large");
        }
        return sum;
    }

    /**
     * sets the face of one of the dice
     *
     * @param index the index of the dice in diceArray that you wish to set
     * @param value the value that you wish to set it to
     */
    public void setFaceValue(int index, int value) {
        diceArray[index] = value;
    }

    /**
     * gets the value of one of the dice
     *
     * @param index the index of the dice in diceArray that you wish to get.
     * @return the value of the indexed dice.
     */
    public int getFaceValue(int index) {
        return this.diceArray[index];
=======
import java.util.Random;

public class Dice {
    private int faceValue1;
    private int faceValue2;
    private int _sum;
    private Random random = new Random();

    /**
     * Throws one die and generates a value between 1-6
     *
     * @return nothing, but changes internal values
     */
    public void roll() {
        this.faceValue1 = random.nextInt(6) + 1;
        this.faceValue2 = random.nextInt(6) + 1;

    }


    /** Sums the face value of two dice objects
     *
     *
     * @return The sum of the two internal faceValue integers
     */
    public int sum() {
        this._sum = this.faceValue1 + this.faceValue2;
        return this._sum;
    }

    public int setFaceValue1(int i) {
        return this.faceValue1 = i;
    }

    public int setFaceValue2(int i) {
        return this.faceValue2 = i;
    }

    public int getFaceValue1() {
        return this.faceValue1;
    }

    public int getFaceValue2() {
        return this.faceValue2;

    }

}










