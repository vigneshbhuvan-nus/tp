package seedu.address.statistics;

import java.time.LocalDateTime;

public class Event {

    EventType eventType;
    LocalDateTime localDateTime;

    public Event(EventType eventType, LocalDateTime localDateTime) {
        this.eventType = eventType;
        this.localDateTime = localDateTime;
    }

    public Event(EventType eventType) {
        this.eventType = eventType;
        this.localDateTime = LocalDateTime.now();
    }
}
