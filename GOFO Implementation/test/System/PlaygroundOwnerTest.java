package System;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author enzotatiyama
 */
public class PlaygroundOwnerTest {
    
    private PlaygroundOwner playgroundOwner;
    private Scanner mockScanner;
    
    @BeforeEach
    public void setUp() {
        playgroundOwner = new PlaygroundOwner();
        mockScanner = mock(Scanner.class);
        playgroundOwner.input = mockScanner;
    }
    
    @Test
    public void testSetAndGetBalance() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        playgroundOwner.setBalance(wallet);
        assertEquals(100, playgroundOwner.getMyBalance());
    }

    @Test
    public void testAddAndExistPlayground() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        playgroundOwner.setBalance(wallet);
        assertEquals(100, playgroundOwner.getMyBalance());
    }

    @Test
    public void testExistPlayground() {
        Playground playground = new Playground();
        playground.setName("TestPlayground");
        playgroundOwner.addPlayground(playground);

        assertTrue(playgroundOwner.existPlayground("TestPlayground"));
        assertFalse(playgroundOwner.existPlayground("NonExistentPlayground"));
    }

    @Test
    public void testUpdatePlaygroundName() {
        Playground playground = new Playground();
        playground.setName("OldName");
        playgroundOwner.addPlayground(playground);

        when(mockScanner.nextLine()).thenReturn("1\nNewName\n");

        playgroundOwner.updatePlaygroundName("OldName");

        assertEquals("NewName", playground.getName());
    }

    @Test
    public void testUpdatePlaygroundStatus() {
        Playground playground = new Playground();
        playground.setName("TestPlayground");
        playgroundOwner.addPlayground(playground);

        when(mockScanner.nextLine()).thenReturn("TestPlayground\n");

        playgroundOwner.updatePlaygroundStatus("TestPlayground", "Time", "Day");
    }

    @Test
    public void testPayMoney() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        playgroundOwner.setBalance(wallet);

        Playground playground = new Playground();
        playground.setName("TestPlayground");
        when(mockScanner.nextLine()).thenReturn("10");
        playground.setPrice();
        playgroundOwner.addPlayground(playground);

        int payment = playgroundOwner.payMoney("TestPlayground", 3);

        assertEquals(30, payment);
        assertEquals(70, playgroundOwner.getMyBalance());
    }

    @Test
    public void testAddRecieveMsg() {
        playgroundOwner.addRecieveMsg("Test Message");
        assertEquals("Test Message", playgroundOwner.recieveMsg.get(0));
    }

}
