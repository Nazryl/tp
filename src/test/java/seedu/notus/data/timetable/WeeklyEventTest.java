package seedu.notus.data.timetable;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@@author brandonywl
/**
 * Test Driver to test all functionality of WeeklyEvent Class.
 */
class WeeklyEventTest {
    private static final String TEST_TITLE = "CS2113 Tutorial";
    private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2020, 8, 27, 13,0);
    private static final boolean TEST_REMINDER = true;
    private static final ArrayList<Integer> TEST_TIME_PERIODS = new ArrayList<>(List.of(1,3));
    private static final ArrayList<String> TEST_TIME_UNITS
            = new ArrayList<>(List.of(Event.REMINDER_DAY, Event.REMINDER_DAY));
    private final WeeklyEvent event = new WeeklyEvent(TEST_TITLE, TEST_DATE_TIME,
            TEST_REMINDER, TEST_TIME_PERIODS, TEST_TIME_UNITS);

    /**
     * Tests if the time-step for WeeklyEvent is still correct (1 week).
     */
    @Test
    void timeStep_oneWeek_success() {
        LocalDate dateTime = LocalDate.now();
        assertEquals(dateTime.plusWeeks(1), event.timeStep(dateTime));
    }

    /**
     * Tests if the event reoccurs when it should.
     */
    @Test
    void toReoccur_twoTimeStepsOneDay_success() {
        LocalDate startDate = TEST_DATE_TIME.toLocalDate();
        LocalDate testDate = event.timeStep(startDate);
        LocalDate testFutureDate = event.timeStep(testDate);
        LocalDate testFutureWrongDate = testFutureDate.plusDays(1);
        assertTrue(event.toReoccur(testDate));
        assertTrue(event.toReoccur(testFutureDate));
        assertFalse(event.toReoccur(testFutureWrongDate));
    }

    /**
     * Tests if the event reoccurs 5 times in 4 weeks.
     */
    @Test
    void getRecurrences_fourWeeks_success() {
        LocalDate startDate = TEST_DATE_TIME.toLocalDate();
        LocalDate endDate = startDate.plusWeeks(4);
        assertEquals(5, (event.getRecurrences(startDate, endDate).size()));
    }
}