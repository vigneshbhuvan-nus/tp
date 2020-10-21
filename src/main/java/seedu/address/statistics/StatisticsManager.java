package seedu.address.statistics;

public class StatisticsManager {

    Statistics statistics;

    public StatisticsManager(Statistics statistics) {
        this.statistics = statistics;
        statistics.incrementTimesOpened();
    }

    public StatisticsManager() {
        Statistics statistics = new Statistics();
        statistics.incrementTimesOpened();
    }

    public void
}
