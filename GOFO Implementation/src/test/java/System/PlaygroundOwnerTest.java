package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 *
 * @author Rafael-Sabugari
 */
public class PlaygroundOwnerTest {
    
    @Test 
    public void testSetAndGetBalance(){
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        eWallet ball = new eWallet();
        ball.setBalance(100);
        playgroundOwner.setBalance(ball);
        
        assertEquals(100, playgroundOwner.getMyBalance());
    }
    
    @Test 
    public void testAddPlayground(){
        Playground playground = new Playground();
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.addPlayground(playground);
        
        assertEquals(1, playgroundOwner.listOfPlayground.size());
    }
    
    @Test 
    public void testExistPlayground(){
        Playground playground = new Playground();
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        
        assertEquals(false, playgroundOwner.existPlayground("Test"));
        
        playground.setName("Test");
        playgroundOwner.addPlayground(playground);

        assertEquals(true, playgroundOwner.existPlayground("Test"));
    }
            
    @Test 
    public void testUpdatePlaygroundName(){
        Playground playground = new Playground();
        playground.setName("PlayGround");
     
        String simulatedInputOption = "1\nPlayGroundEdited";
        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.addPlayground(playground);
        
        playgroundOwner.updatePlaygroundName("PlayGround");
        assertEquals("PlayGroundEdited", playground.getName());
    }     
    
    @Test
    public void testDisplayRecieveMsg() {
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.displayRecieveMsg();
    }

    @Test
    public void testGetListofPlayground() {
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.getListofPlayground();
    }

    @Test
    public void testAddRecieveMsg() {
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.addRecieveMsg("Message");
    }

    @Test
    public void testPayMoney() {
        String simulatedInputOption = "20";
        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);

        Playground playground = new Playground();
        playground.setPrice();
        playground.setName("Playground");

        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        playgroundOwner.addPlayground(playground);
        playgroundOwner.setBalance(wallet);

        assertEquals(60, playgroundOwner.payMoney("Playground", 3));
        assertEquals(40, playgroundOwner.getMyBalance());
    }
   
}
