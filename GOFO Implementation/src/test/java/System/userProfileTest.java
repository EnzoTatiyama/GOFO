package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author enzotatiyama
 */
public class userProfileTest {
    
    @Test
    public void testGetInstance() {
        userProfile user = new userProfile();
        assertEquals(userProfile.class, user.getClass());
    }
    
    @Test
    public void testSetUserData() {
        userProfile user = new userProfile();

        user.setFName("John");
        user.setLName("Doe");
        user.setID(123);
        user.setEmail("john.doe@example.com");
        user.setPassword("secretpassword");
        user.setPhone(123456789);
        user.setLocation("City");
        user.setRule("user");

        assertEquals("John Doe", user.getFullName());
        assertEquals(123, user.getID());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("secretpassword", user.getPassword());
        assertEquals(123456789, user.getPhone());
        assertEquals("user", user.getRule());
    }
}
