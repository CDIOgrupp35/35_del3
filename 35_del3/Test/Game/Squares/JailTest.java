package Game.Squares;

import Game.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailTest {

    Jail jailTest = new Jail(1,"Amazing Name",2);
    Player amazingTestPlayer = new Player("Player1",20);

    @Test
    void landOn() {
        jailTest.landOn(amazingTestPlayer);
        assertTrue(jailTest.getSqMessage().equals(", du er landet på Amazing Name. Ryk hen til FÆNGSEL. Når du starter din næste tur skal du betale 1M for at blive løsladt igen"));
        assertTrue(amazingTestPlayer.getLocation() == 6);
    }
}