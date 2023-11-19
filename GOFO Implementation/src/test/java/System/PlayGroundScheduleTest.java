package System;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayGroundScheduleTest {

   private final InputStream originalSystemIn = System.in;

   @Test
   public void testGetInstance() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       assertEquals(PlayGroundSchedule.class, playGroundSchedule.getClass());
   }

   @Test
   public void testSetPrice() {
       String input = '20';
       System.setIn(new ByteArrayInputStream(input.getBytes()));

       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.setPrice();

       System.setIn(System.in);
       assertEquals(PlayGroundSchedule.class, playGroundSchedule.getClass());
   }
   
}
