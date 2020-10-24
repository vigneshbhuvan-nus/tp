package seedu.address.statistics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Object that captures the app usage statistics of a given user. These could range from time spent
 * on the app to individual quiz performance.
 */
public class Statistics {

    int timesOpened;
    List<Event> eventLog;

    public Statistics(int timesOpened, List<Event> eventLog) {
        this.timesOpened = timesOpened;
        this.eventLog = eventLog;
    }

    public Statistics() {
        timesOpened = 0;
        eventLog = new ArrayList<>();
    }

    public void registerAppLogin() {
        eventLog.add(new Event(EventType.LOGIN));
        timesOpened++;
    }

    public void registerAppLogout() {
        eventLog.add(new Event(EventType.LOGOUT));
    }
}
