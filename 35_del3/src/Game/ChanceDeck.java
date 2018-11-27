package Game;

import java.util.Random;

public class ChanceDeck {

    // Creates array
    private ChanceCard[] deck;


    // Assign objects to array
    public ChanceDeck() {
        deck = new ChanceCard[20];
        assignCards();
    }


    // method to assign chance cards information
    private void assignCards() {
        for (int i = 0; i < deck.length; i++) {
            if (i >= 0 && i < 3) {
                deck[i] = new ChanceCard("Start", "Ryk frem til start og modtag 2 point", 1);
            } else if (i >= 3 && i < 6) {
                deck[i] = new ChanceCard("Ryk frem!", "Ryk 5 felter frem!", 2);
            } else if (i >= 6 && i < 10) {
                deck[i] = new ChanceCard("Udgift", "Du har spist for meget slik! Betal 2 point", 3);
            } else if (i >= 10 && i < 12) {
                deck[i] = new ChanceCard("Ryk frem!", "Ryk frem til strandpromnaden", 4);
            } else if (i >= 12 && i < 16) {
                deck[i] = new ChanceCard("Udbetaling af lommepenge", "Du har lavet alle dine lektier, modtag 2 point", 5);
            } else if (i >= 16 && i < 20) {
                deck[i] = new ChanceCard("Ryk frem!", "Du skal prøve dit nye skateboard, ryk frem til skateparken", 6);
            }

        }

    }


    // method that pulls a chance card from top of deck
    public ChanceCard drawCard() {
        ChanceCard pulled = deck[0];
        for (int i = 0; i < deck.length-1; i++) {
            deck[i] = deck[i + 1];

        }
        deck[19] = pulled;
        return pulled;
    }

    //Method that shuffles the deck of change cards
    public void shuffleCards() {

        ChanceCard[] shuffled = new ChanceCard[deck.length];

        Random random = new Random();



        for(int i = 0; i<deck.length;i++){
            boolean cardPlaced = false;

            while(!cardPlaced){
                int index = random.nextInt(20);

                if(shuffled [index] == null){
                    shuffled[index] = deck[i];
                    cardPlaced = true;


                }
                deck = shuffled;
            }


    }
}

}
