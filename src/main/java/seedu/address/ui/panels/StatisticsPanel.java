package seedu.address.ui.panels;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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

    private final int currentIndex;

    @FXML
    private Label lastLoginLabel;
    @FXML
    private LineChart<Number, Number> statisticsLineChart;

    private static class DataPoint {

        double scoreInPercentage;
        LocalDateTime takenAt;

        DataPoint(LocalDateTime takenAt, double scoreInPercentage) {
            this.scoreInPercentage = scoreInPercentage;
            this.takenAt = takenAt;
        }
    }

    /**
     * Constructor for statistics panel
     */
    public StatisticsPanel(Logic logic, int currentIndex) {
        super(FXML);
        this.currentIndex = currentIndex;

        ObservableList<Deck> decks = logic.getFilteredDeckList();
        StatisticsManager statisticsManager = logic.getStatisticsManager();

        plotDataPoints(getDeckPlottingPoints(decks));

        String lastLoginString = statisticsManager.getLastLoginString();

        lastLoginLabel.setText(String.format("Last Login: %s", lastLoginString));
    }

    private void plotDataPoints(List<DataPoint> dataPoints) {
        statisticsLineChart.setTitle("Average Quiz Performance");

//        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
//        series1.setName("Series 1");
//        series1.getData().add(new XYChart.Data<>(1, 20));
//        series1.getData().add(new XYChart.Data<>(2, 100));
//        series1.getData().add(new XYChart.Data<>(3, 80));
//        series1.getData().add(new XYChart.Data<>(4, 180));
//        series1.getData().add(new XYChart.Data<>(5, 20));
//        series1.getData().add(new XYChart.Data<>(6, -10));
//        statisticsLineChart.getData().add(series1);

//        XYChart.Series series = new XYChart.Series();
//        for(DataPoint dataPoint : dataPoints) {
//            series.getData().add(new XYChart.Data(1,2));
//        }
//
//        statisticsLineChart.getData().add(series);
    }

    /**
     * Helper function to compute the statistics for plotting/displaying
     */
    private List<DataPoint> getDeckPlottingPoints(ObservableList<Deck> decks) {
        List<List<QuizAttempt>> listsToMerge = new ArrayList<>();

        for (Deck deck : decks) {
            listsToMerge.add(deck.getQuizAttempts());
        }

        return mergeSortedListsOfAttempts(listsToMerge);
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
