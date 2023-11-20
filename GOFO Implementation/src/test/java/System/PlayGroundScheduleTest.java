package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class PlayGroundScheduleTest {

   @Test
   public void testGetInstance() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       assertEquals(PlayGroundSchedule.class, playGroundSchedule.getClass());
   }

   @Test
   public void testSetPrice() {
       String input = "20";
       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.setPrice();
       assertEquals(20, playGroundSchedule.getTimeSlotPerHour());
   }

   @Test
   public void testSetschedule() {
       String input = "1\n7";
       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.setschedule();
       assertEquals(1, playGroundSchedule.getBegin());
       assertEquals(7, playGroundSchedule.getEnd());
   }

   @Test
   public void testBookSlot() {
       String input = "1\n7";
       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.setschedule();
       playGroundSchedule.bookSlot("Player 1", "sunday", "monday");
       playGroundSchedule.updateSlot("monday", "sunday", "Player 2");
   }

   @Test
   public void testGetDayIndex() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       assertEquals(1, playGroundSchedule.getDayIndex("sunday"));
       assertEquals(2, playGroundSchedule.getDayIndex("monday"));
       assertEquals(3, playGroundSchedule.getDayIndex("tuesday"));
       assertEquals(4, playGroundSchedule.getDayIndex("wendesday"));
       assertEquals(5, playGroundSchedule.getDayIndex("thursday"));
       assertEquals(6, playGroundSchedule.getDayIndex("friday"));
       assertEquals(7, playGroundSchedule.getDayIndex("saturday"));
       assertEquals(-1, playGroundSchedule.getDayIndex("error"));
   }
   
   @Test
   public void testDisplayFreeSlots() {
       PlayGroundSchedule playGroundSchedule = new PlayGroundSchedule();
       playGroundSchedule.displayFreeSlots();
   }
}
