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
     * Loops through the diceArray and sums all of values
     *
     * @return the sum of all the values in diceArray
     */
    public int sum() {
        int sum = 0;
        for(int i = 0; i < diceArray.length; i++) {
            sum += diceArray[i];
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
    }

}










