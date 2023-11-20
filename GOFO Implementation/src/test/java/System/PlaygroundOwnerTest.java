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
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        
        assertEquals(false, playgroundOwner.existPlayground("Test"));
        
        playground.setName("Test");
        playgroundOwner.addPlayground(playground);

        assertEquals(true, playgroundOwner.existPlayground("Test"));
    }        
}
