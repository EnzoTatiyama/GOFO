package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 *
 * @author Rafael-Sabugari
 */

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
    
    @Test 
    public void createTeam(){
        Player player = new Player();
        player.createTeam(player);
        assertEquals(1, player.team.size());
    }
    
    @Test
    public void testEditPlayerinfo() {
        String simulatedInputOption = "1\nFirst\n2\nName\n3\n1234\n4\nteste@gmail.com\n5\n82194743\n6\nteste\n7\n1234\n8\n1\nFirst";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);

        Player player = new Player();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        player.editPlayerinfo();
        
        assertEquals("First Name", player.getFullName());
        assertEquals("1234", player.getPassword());
        assertEquals("teste@gmail.com", player.getEmail());
        assertEquals(82194743, player.getPhone());
        assertEquals("teste", player.location);
        assertEquals(1234, player.getID());
    }
    
    @Test
    public void testGetMoney() {
        Player player = new Player();
        player.getMoney(5);
        assertEquals(5, player.getBalance());
    }
    
    @Test
    public void testSetAndGetInbox() {
        Player player = new Player();
        player.viewInbox();
        player.addInbox("5");
        player.viewInbox();
    }
    
}
