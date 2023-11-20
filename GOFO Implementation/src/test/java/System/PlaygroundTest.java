package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 *
 * @author Rafael-Sabugari
 */

public class PlaygroundTest {
    
    @Test
    public void testSetAndGetCancellationPeriod(){
        Playground playground = new Playground();
       
        playground.setCancellationPeriod(2);
        assertEquals(2, playground.getCancellationPeriod());
    }
    
    @Test
    public void testBookingTheSlotAndSetGetStatusPlayground(){
        String simulatedInputOption = "test\nnot available\navailable";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Playground playground = new Playground();
        playground.setStatus();
        playground.bookingTheSlot("Test","20","20");
        playground.setStatus();
        playground.bookingTheSlot("Test","20","20");
       
        assertEquals("available", playground.getStatus());
    }
                     
    @Test
    public void testCancelBooking(){
        Playground playground = new Playground();
        playground.cancelBooking("20","20");
    }
    
    @Test
    public void testFreeSlots(){
        Playground playground = new Playground();
        playground.freeSlots();
    }
    
    @Test
    public void testSetBookingAndGetSlotsBeginEnd(){
        String simulatedInputOption = "1\n1";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Playground playground = new Playground();
        playground.setBooking();
        
        assertEquals(1, playground.getSlotsBegin());
        assertEquals(1, playground.getSlotsEnd());
    }
    
    @Test
    public void testSetAndGetOwner(){
        Playground playground = new Playground();
        playground.setOwner("Test");
        
        assertEquals("Test", playground.getOwner());
    }
    
    @Test
    public void testSetAndGetName(){
        Playground playground = new Playground();
        playground.setName("Test");
        
        assertEquals("Test", playground.getName());
    }
    
    @Test
    public void testSetAndGetLocation(){
        String simulatedInputOption = "Test";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Playground playground = new Playground();
        playground.setLocation();
        
        assertEquals("Test", playground.getLocation());
    }
    
    @Test
    public void testSetAndGetPrice(){
        String simulatedInputOption = "1";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Playground playground = new Playground();
        playground.setPrice();
        
        assertEquals(1, playground.getPrice());
    }
}
