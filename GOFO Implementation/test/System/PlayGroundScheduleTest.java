package System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayGroundScheduleTest {

    private PlayGroundSchedule schedule;

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
        schedule.setSchedule(); 
        assertEquals(9, schedule.getBegin());
        assertEquals(12, schedule.getEnd());
    }

    @Test
    public void testBookAndDisplaySlots() {
        schedule.setSchedule(); 
        schedule.bookSlot("Player A", "10", "Monday");
        schedule.bookSlot("Player B", "11", "Tuesday");
    }

    @Test
    public void testUpdateSlot() {
        schedule.setSchedule();
        schedule.bookSlot("Player A", "14", "Wednesday");
        schedule.updateSlot("Wednesday", "14", "Player B");
    }
}
