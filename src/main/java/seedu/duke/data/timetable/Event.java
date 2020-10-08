package seedu.duke.data.timetable;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents an Event. Contains all the information of an Event.
 */
public class Event {
    private String title;
    // Can be combined into LocalDateTime
    private LocalDate date;
    private LocalTime time;
    private Boolean isToRemind;
    private Boolean isRecurring;

    /**
     * Creates an Event object with its title, date and time provided.
     *
     * @param title of the event.
     * @param date of the event.
     * @param time of the event.
     */
    public Event(String title, LocalDate date, LocalTime time) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.isToRemind = false;
        this.isRecurring = false;
    }

    /**
     * Creates an Event object with its title, date, time, isToRemind and isRecurring provided.
     *
     * @param title of the event.
     * @param date of the event.
     * @param time of the event.
     * @param isToRemind status of the event.
     * @param isRecurring status of the event.
     */
    public Event(String title, LocalDate date, LocalTime time, Boolean isToRemind, Boolean isRecurring) {
        this(title, date, time);
        this.isToRemind = isToRemind;
        this.isRecurring = isRecurring;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Boolean getToRemind() {
        return isToRemind;
    }

    public void setToRemind(Boolean toRemind) {
        isToRemind = toRemind;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public void setRecurring(Boolean recurring) {
        isRecurring = recurring;
    }
}