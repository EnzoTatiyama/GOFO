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
        String simulatedInputOption = "TestOne\n1\nTestTwo\n2\nTest\n3\n20\n4\nnot available\n5\n1\n1";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        Playground playground = new Playground();
        playground.setName("TestOne");
        playgroundOwner.addPlayground(playground);
        playgroundOwner.updatePlaygroundName("Test");
        playgroundOwner.updatePlaygroundName("TestTwo");
        playgroundOwner.updatePlaygroundName("TestTwo");
    }     
    
   
}
