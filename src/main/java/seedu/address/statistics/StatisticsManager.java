package seedu.address.statistics;

import java.time.LocalDateTime;
import java.util.List;

public class StatisticsManager {

    private final Statistics statistics;

    //  if statistics file exists

    /**
     * @param statistics
     */
    public StatisticsManager(Statistics statistics) {
        this.statistics = statistics;
        statistics.registerAppLogin();
    }


    /**
     * if first time opening the app
     */
    public StatisticsManager() {
        this.statistics = new Statistics();
        this.statistics.registerAppLogin();
    }

    public void doCleanup() {
        statistics.registerAppLogout();
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public String getLastLoginString() {
        LocalDateTime lastLogin = getLastLogin();
        System.out.println("statistics: " + this.statistics);
        return lastLogin == null ? "-" : lastLogin.toString();
    }

    public LocalDateTime getLastLogin() {
        List<Event> eventLog = statistics.getEventLog();

        if (eventLog.size() == 0) {
            return null;
        }

        int idx = eventLog.size() - 2;
        // get the second most recent login event
        while (idx >= 0 && eventLog.get(idx).getEventType() != EventType.LOGIN) {
            idx--;
        }
        return idx == -1 ? null : eventLog.get(idx).getLocalDateTime();
    }
}
