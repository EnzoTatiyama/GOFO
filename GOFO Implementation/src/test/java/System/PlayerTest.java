package System;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    
    @Test
    public void testGetInstance() {
        Player player = new Player();
        assertEquals(Player.class, player.getClass());
    }
    
    @Test
    public void testSetAndGetBalance() {
        Player player = new Player();
        player.setBalance(500);
        assertEquals(500, player.getBalance());
    }

    @Test
    public void testBookSlots() {
        Player player = new Player();
        player.setBalance(1000);
        player.bookingSlots("10:00", "Playground A");
    }

    @Test
    public void testCancelBooking() {
        Player player = new Player();
        player.setBalance(1000);
        player.bookingSlots("12:00", "Playground B");
        player.CancelBooking("Playground B", "12:00");
    }
}
