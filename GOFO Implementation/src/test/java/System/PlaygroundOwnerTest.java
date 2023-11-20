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
        String simulatedInputOption = "1\nPlayGroundEdited";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        Playground playground = new Playground();
        playground.setName("PlayGround");
        playgroundOwner.addPlayground(playground);
        playgroundOwner.updatePlaygroundName("PlayGround");
        assertEquals("PlayGroundEdited", playground.getName());

        simulatedInputOption = "2\nLocation1";
        in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        playgroundOwner.updatePlaygroundName(playground.getName());
        assertEquals("Location1", playground.getLocation());

        simulatedInputOption = "3\n20";
        in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        playgroundOwner.updatePlaygroundName(playground.getName());
        assertEquals(20, playground.getPrice());

        simulatedInputOption = "4\navailable";
        in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        playgroundOwner.updatePlaygroundName(playground.getName());
        assertEquals("available", playground.getStatus());

        simulatedInputOption = "5\n1\n7";
        in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        playgroundOwner.updatePlaygroundName(playground.getName());
    }     
    
   
}
