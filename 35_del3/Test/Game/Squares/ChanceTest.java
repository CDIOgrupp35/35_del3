package Game.Squares;

import Game.ChanceDeck;
import Game.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    ChanceDeck chanceDeckTest = new ChanceDeck();
    Chance chanceTest = new Chance(1,"Amazing Name", chanceDeckTest);
    Player amazingTestPlayer = new Player("Player1",20);

    @Test
    void landOn() {
        chanceTest.landOn(amazingTestPlayer);

        assertTrue(chanceTest.getSqMessage().equals(", du er landet på Amazing Name. Tryk \'OK\' eller enter for at trække et Chancekort"));
        assertNotNull(chanceTest.getpulledCardText());
    }
}