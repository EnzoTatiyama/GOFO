package System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import System.PlayGroundSchedule.*;
public class PlayGroundScheduleTest {

    public PlayGroundSchedule schedule;

    @BeforeEach
    public void setUp() {
        schedule = new PlayGroundSchedule();
    }

    @Test
    public void testSetAndGetPrice() {
        schedule.setPrice(); 
        assertEquals(50, schedule.getTimeSlotPerHour());
    }

    @Test
    public void testSetAndGetSchedule() {
        schedule.setschedule(); 
        assertEquals(9, schedule.getBegin());
        assertEquals(12, schedule.getEnd());
    }

    @Test
    public void testBookAndDisplaySlots() {
        schedule.setschedule(); 
        schedule.bookSlot("Player A", "10", "Monday");
        schedule.bookSlot("Player B", "11", "Tuesday");
    }

    @Test
    public void testUpdateSlot() {
        schedule.setschedule();
        schedule.bookSlot("Player A", "14", "Wednesday");
        schedule.updateSlot("Wednesday", "14", "Player B");
    }
}
