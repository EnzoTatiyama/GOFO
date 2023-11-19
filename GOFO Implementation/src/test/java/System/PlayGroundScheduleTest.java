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
   
}
