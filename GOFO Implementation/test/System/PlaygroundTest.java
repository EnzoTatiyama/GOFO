package System;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author enzotatiyama
 */
public class PlaygroundTest {
    
    private Playground playground;
    private Scanner mockScanner;
    
    @BeforeEach
    public void setUp() {
        playground = new Playground();
        mockScanner = mock(Scanner.class);
        playground.input = mockScanner;
    }

    @Test
    public void testGetInstance() {
        assertEquals(Playground.class, playground.getClass());
    }

    @Test
    public void testSetAndGetCancellationPeriod() {
        int cancellationPeriod = 7;
        playground.setCancellationPeriod(cancellationPeriod);
        assertEquals(cancellationPeriod, playground.getCancellationPeriod());
    }

    @Test
    public void testBookingTheSlot() {
        when(mockScanner.nextLine()).thenReturn("available");
        playground.setStatus();

        String player = "Player";
        String time = "10:00 AM";
        String day = "Monday";
        
        playground.bookingTheSlot(player, time, day);
    }

    @Test
    public void testCancelBooking() {
        playground.cancelBooking("Monday", "10:00 AM");
    }

    @Test
    public void testSetAndGetOwner() {
        String owner = "OwnerName";
        playground.setOwner(owner);
        assertEquals(owner, playground.getOwner());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Name";
        playground.setName(name);
        assertEquals(name, playground.getName());
    }

    @Test
    public void testSetAndGetLocation() {
        when(mockScanner.nextLine()).thenReturn("Parque 123");
        playground.setLocation();
        assertEquals("Parque 123", playground.getLocation());
    }

    @Test
    public void testSetAndGetPrice() {
        when(mockScanner.nextLine()).thenReturn("25");
        playground.setPrice();
        assertEquals("Parque 123", playground.getPrice());
    }
}
