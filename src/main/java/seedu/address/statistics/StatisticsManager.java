package seedu.address.statistics;

public class StatisticsManager {

    Statistics statistics;

    //  if statistics file exists
    public StatisticsManager(Statistics statistics) {
        this.statistics = statistics;
        statistics.registerAppLogin();
    }

    //  if first time opening the app
    public StatisticsManager() {
        Statistics statistics = new Statistics();
        statistics.registerAppLogin();
    }

    public void doCleanup() {
        statistics.registerAppLogout();
    }
}
