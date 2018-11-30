package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceDeckTest {

    ChanceDeck chanceDeckTest = new ChanceDeck();

    /**
     * Testing that the drawCard methods draws from the top of the deck.
     */
    @Test
    void drawCardTest() {

        assertTrue( chanceDeckTest.drawCard().getCardText() == "Ryk frem til start og modtag 2 point");

    }

    /**
     * Testing that the deck is shuffled.
     */
    @Test
    void shuffleCardsTest() {
        ChanceCard[] testDeck = chanceDeckTest.getDeck();
        chanceDeckTest.shuffleCards();

        assertFalse(chanceDeckTest.getDeck() == testDeck);
    }
}