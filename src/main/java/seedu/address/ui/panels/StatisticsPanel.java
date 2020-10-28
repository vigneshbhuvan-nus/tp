package seedu.address.ui.panels;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javax.xml.crypto.Data;
import seedu.address.logic.Logic;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.scoring.QuizAttempt;
import seedu.address.statistics.Statistics;
import seedu.address.statistics.StatisticsManager;
import seedu.address.ui.UiPart;
import seedu.address.ui.deck.DeckListPanel;

public class StatisticsPanel extends UiPart<Region> {

    private static final String FXML = "StatisticsPanel.fxml";

    @FXML
    private Label lastLoginLabel;
    @FXML
    private LineChart<String, Number> statisticsLineChart;

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

        @Override
        public String toString() {
            return "DataPoint{" + "scoreInPercentage="
                + scoreInPercentage + ", takenAt=" + takenAt + '}';

        }
    }

    String chartTitle;

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

        if (indexOfSelectedDeck == -1) {
            chartTitle = "Recent performance over all decks.";
        } else {
            chartTitle = "Recent performance over deck " + decks.get(0).getDeckName();
        }

        StatisticsManager statisticsManager = logic.getStatisticsManager();

        plotDataPoints(getDeckPlottingPoints(decks));

        String lastLoginString = statisticsManager.getLastLoginString();

        lastLoginLabel.setText(String.format("Last Login: %s", lastLoginString));
    }

    private void plotDataPoints(List<DataPoint> dataPoints) {
        statisticsLineChart.setTitle(chartTitle);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("");
        for (DataPoint dataPoint : dataPoints) {
            series.getData()
                .add(new XYChart.Data<>(dataPoint.getTakenAt().toString(),
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
     */
    private List<DataPoint> mergeSortedListsOfAttempts(List<List<QuizAttempt>> listsToMerge) {
        List<DataPoint> listFromMerging = new ArrayList<>();
        int numberOfLists = listsToMerge.size();
        int[] lengths = new int[numberOfLists];
        int[] positions = new int[numberOfLists];
        for (int i = 0; i < numberOfLists; ++i) {
            lengths[i] = listsToMerge.get(i).size();
        }

        Queue<QuizAttempt> pq = new PriorityQueue<>(Comparator.comparing(QuizAttempt::getTakenAt));

        for (int i = 0; i < numberOfLists; ++i) {
            if (positions[i] < lengths[i]) {
                pq.offer(listsToMerge.get(i).get(0));
                positions[i]++;
            }
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            QuizAttempt attempt = pq.poll();
            LocalDateTime takenAt = attempt.getTakenAt();
            double scoreInPercentage = attempt.getScore().getScoreInPercentage();
            listFromMerging.add(new DataPoint(takenAt, scoreInPercentage));

            if (positions[idx] < lengths[idx]) {
                // process the idx-th list
                pq.offer(listsToMerge.get(idx).get(positions[idx]));
                positions[idx]++;
            }

            idx++;
        }

        return listFromMerging;
    }
}
