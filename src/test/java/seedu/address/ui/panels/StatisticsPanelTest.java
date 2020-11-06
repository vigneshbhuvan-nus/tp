package seedu.address.ui.panels;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.RadialGradientPaint;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.model.play.Score;
import seedu.address.model.play.scoring.QuizAttempt;

class StatisticsPanelTest {

    List<List<QuizAttempt>> listsToMerge;
    List<QuizAttempt> correctMostRecent, myMostRecent;

    @BeforeEach
    void setUp() {
        final int MAX_TOTAL_SCORE = 100, MIN_TOTAL_SCORE = 10;
        final int ATTEMPTS = 500;
        final int MAX_LISTS = 100, MIN_LISTS = 10;

        var zoneId = ZoneId.systemDefault();

        final long START_DATE = LocalDateTime.of(2020, 5, 1, 0, 0).atZone(ZoneId.systemDefault())
            .toEpochSecond();
        final long END_DATE = LocalDateTime.of(2020, 12, 1, 0, 0).atZone(ZoneId.systemDefault())
            .toEpochSecond();

        listsToMerge = new ArrayList<>();

        Random rand = new Random();

        int numberOfLists = rand.nextInt(MAX_LISTS - MIN_LISTS + 1) + MIN_LISTS;

        // generate random number of buckets
        for (int i = 0; i < numberOfLists; ++i) {
            listsToMerge.add(new ArrayList<>());
        }

        // generate many random quiz attempts
        // each with randomized scores (between 1 and 100) and takenAts
        // and place each quiz attempt in a random bucket
        for (int i = 0; i < ATTEMPTS; ++i) {
            QuizAttempt quizAttempt = new QuizAttempt();
            double totalScore =
                rand.nextInt((MAX_TOTAL_SCORE - MIN_TOTAL_SCORE) + 1) + MIN_TOTAL_SCORE;
            double yourScore = rand.nextDouble() * totalScore;
            Score score = new Score(totalScore, yourScore);
            quizAttempt.setScore(score);
            LocalDateTime takenAt = LocalDateTime
                .ofInstant(Instant.ofEpochSecond(ThreadLocalRandom.current().nextLong(
                    START_DATE,
                    END_DATE
                )), ZoneId.systemDefault());
            quizAttempt.setTakenAt(takenAt);
            // System.out.println(quizAttempt.getTakenAtAndScoreInPercentage());
            int listIdx = rand.nextInt(numberOfLists);
            listsToMerge.get(listIdx).add(quizAttempt);
        }

//        for(int i=0;i<numberOfLists;++i){
//            System.out.println(listsToMerge.get(i).size());
//        }

        List<QuizAttempt> temp = new ArrayList<>();
        for (var list : listsToMerge) {
            temp.addAll(list);
        }
        temp.sort(Comparator.comparing(QuizAttempt::getTakenAt));
        Collections.reverse(temp);
        correctMostRecent = temp.subList(0, 10); // this is our correct 10 most recent elements
    }

    boolean compareListsOfQuizAttempts(List<QuizAttempt> list1, List<QuizAttempt> list2) {
        int m = list1.size(), n = list2.size();
        if (m != n) {
            return false;
        }

        for (int i = 0; i < m; ++i) {
            if (list1.get(i).getTakenAtAndScoreInPercentage() != list2.get(i)
                .getTakenAtAndScoreInPercentage()) {
                return false;
            }
        }

        return true;
    }

    @Test
    void testMergeKSorted_shouldGiveCorrectResult() {

    }


    @AfterEach
    void tearDown() {
    }
}