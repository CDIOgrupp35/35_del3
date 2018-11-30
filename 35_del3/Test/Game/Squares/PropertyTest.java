package Game.Squares;

import Game.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    Property propertyTest = new Property(1,"Amazing Name",5);
    Player amazingTestPlayer = new Player("Player1",20);

    @Test
    void landOnTest() {
        propertyTest.landOn(amazingTestPlayer);

        assertTrue(propertyTest.getSqMessage().equals(", du er landet på Amazing Name, som er ledigt og køber derfor dette"));
        assertTrue(amazingTestPlayer.getBalance().getPoints() == 15);
        assertTrue(propertyTest.getOwner() == amazingTestPlayer);

    }
}