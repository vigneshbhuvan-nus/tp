package seedu.address.ui.panels;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxis.DefaultFormatter;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.logic.Logic;
import seedu.address.model.deck.Deck;
import seedu.address.model.play.scoring.QuizAttempt;
import seedu.address.statistics.StatisticsManager;
import seedu.address.ui.UiPart;

public class StatisticsPanel extends UiPart<Region> {

    private static final String FXML = "StatisticsPanel.fxml";

    @FXML
    private Label lastLoginLabel;
    @FXML
    private LineChart<String, Number> statisticsLineChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    private String chartTitle;

    private static class DataPoint {

        private double scoreInPercentage;
        private LocalDateTime takenAt;

        DataPoint(LocalDateTime takenAt, double scoreInPercentage) {
            this.scoreInPercentage = scoreInPercentage;
            this.takenAt = takenAt;
        }

        public double getScoreInPercentage() {
            return scoreInPercentage;
        }

        public LocalDateTime getTakenAt() {
            return takenAt;
        }

        public String getTakenAtString() {
            return takenAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd\nHH:mm:ss"));
        }

        @Override
        public String toString() {
            return "DataPoint{" + "scoreInPercentage="
                + scoreInPercentage + ", takenAt=" + takenAt + '}';

        }
    }

    /**
     * Constructor for statistics panel
     */
    public StatisticsPanel(Logic logic, int indexOfSelectedDeck) {
        super(FXML);

        // System.out.println("deck selected = " + indexOfSelectedDeck);

        ObservableList<Deck> originalDecks = logic.getFilteredDeckList();
        // decide which deck to get, or get all of them if indexOfSelectedDeck==-1
        List<Deck> decks = IntStream.range(0, originalDecks.size())
            .filter(idx -> indexOfSelectedDeck == -1 || idx == indexOfSelectedDeck)
            .mapToObj(originalDecks::get).collect(Collectors.toList());

        if (indexOfSelectedDeck == -1 || decks.size() == 0) {
            chartTitle = "Recent performance over all decks.";
        } else {
            chartTitle = "Recent performance over deck " + decks.get(0).getDeckName();
        }

        StatisticsManager statisticsManager = logic.getStatisticsManager();

        initialize();
        plotDataPoints(getDeckPlottingPoints(decks));

        String lastLoginString = statisticsManager.getLastLoginString();

        lastLoginLabel.setText(String.format("Last Login: %s", lastLoginString));
    }

    private void initialize() {
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickLabelFormatter(new DefaultFormatter(yAxis, null, "%"));

        statisticsLineChart.setTitle(chartTitle);
    }

    private void plotDataPoints(List<DataPoint> dataPoints) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("");
        for (DataPoint dataPoint : dataPoints) {
            series.getData()
                .add(new XYChart.Data<>(dataPoint.getTakenAtString(),
                    dataPoint.getScoreInPercentage()));
        }
        statisticsLineChart.getData().add(series);
    }

    /**
     * Helper function to compute the statistics for plotting/displaying
     */
    private List<DataPoint> getDeckPlottingPoints(List<Deck> decks) {
        // List<List<QuizAttempt>> listsToMerge = new ArrayList<>();
        //
        // for (Deck deck : decks) {
        // listsToMerge.add(deck.getQuizAttempts());
        // }

        List<DataPoint> ret = new ArrayList<>();

        Queue<QuizAttempt> pq = new PriorityQueue<>(Comparator.comparing(QuizAttempt::getTakenAt));

        for (Deck deck : decks) {
            for (QuizAttempt qa : deck.getQuizAttempts()) {
                pq.offer(qa);
            }
        }

        while (!pq.isEmpty()) {
            QuizAttempt attempt = pq.poll();
            LocalDateTime takenAt = attempt.getTakenAt();
            double scoreInPercentage = attempt.getScore().getScoreInPercentage();
            ret.add(new DataPoint(takenAt, scoreInPercentage));
        }

        return ret;

        // return mergeSortedListsOfAttempts(listsToMerge);
    }

    /**
     * Helper function to merge the sorted (by date taken) list of quiz attempts
     *
     * @param listsToMerge
     */
    public static List<QuizAttempt> mergeSortedListsAndRetrieveFirstK(
        List<List<QuizAttempt>> listsToMerge, int k) {
        PriorityQueue<QuizAttempt> pq = new PriorityQueue<>(k,
            Comparator.comparing(QuizAttempt::getTakenAt).reversed());
        int numLists = listsToMerge.size();
        int[] listPtrs = new int[numLists]; // tracks current pos in each list

        // get sizes and make the initial pq
        for (int i = 0; i < numLists; ++i) {
            listPtrs[i] = listsToMerge.get(i).size() - 1;
            // System.out.println("---- " + listsToMerge.get(i).get(listPtrs[i]).getTakenAtAndScoreInPercentage());
            pq.add(listsToMerge.get(i).get(listPtrs[i]));
            --listPtrs[i];
        }

        int curList = 0;
        List<QuizAttempt> ret = new ArrayList<>();
        while (true) {
            ret.add(pq.poll());
            if(ret.size() == k) break;

            // TODO: update comment below
            // here, we're trying to find the first list where we still have valid elements to consider
            // by checking if listPtr[idx] (current pos in that list) < listSize[idx] (size of that list)
            int offset = 0;
            while (offset < numLists && listPtrs[(curList + offset) % numLists] < 0
            ) {
                ++offset;
            }
            if (offset == numLists) {
                // we're at the end of every list - no more valid elements to consider
                // this implies that k > sum of list sizes
                break;
            }
            curList += offset;

            pq.add(listsToMerge.get(curList%numLists).get(listPtrs[(curList++)%numLists]--));
        }

        return ret;
    }
}
