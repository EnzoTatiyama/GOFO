package System;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayGroundScheduleTest {

   @Test
   public void testGetInstance() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       assertEquals(PlayGroundSchedule.class, playGroundSchedule.getClass());
   }
   
   @Test
   public void testSetAndGetPrice() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.setScanner(new Scanner("20"));
       playGroundSchedule.setPrice(); 
       assertEquals(20, playGroundSchedule.getTimeSlotPerHour());
   }
}
