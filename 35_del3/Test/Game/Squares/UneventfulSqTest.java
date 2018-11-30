package Game.Squares;

import Game.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UneventfulSqTest {

    UneventfulSq uneventfulSqTest = new UneventfulSq(1,"Amazing Name");
    Player amazingTestPlayer = new Player("Player1",20);

    @Test
    void landOnTest() {
        uneventfulSqTest.landOn(amazingTestPlayer);
        assertTrue(uneventfulSqTest.getSqMessage().equals(", du er landet på Amazing Name. Din tur er slut."));
    }
}