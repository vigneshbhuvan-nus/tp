package seedu.address.ui.panels;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.RadialGradientPaint;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import seedu.address.model.play.Score;
import seedu.address.model.play.scoring.QuizAttempt;

class StatisticsPanelTest {

    List<List<QuizAttempt>> listsToMerge;

    @BeforeEach
    void setUp() {
        listsToMerge = new ArrayList<>();

        // generate 100 random quiz attempts
        // each with randomized scores (between 1 and 100) and takenAts
        final int MAX_TOTAL_SCORE = 100, MIN_TOTAL_SCORE = 10;

        var zoneId = ZoneId.systemDefault();
        ZoneOffset zoneOffset = (ZoneOffset) ZoneOffset.systemDefault();

        final long START_DATE = LocalDateTime.of(2020, 5, 1, 0, 0).toEpochSecond(zoneOffset);
        final long END_DATE = LocalDateTime.of(2020, 12, 1, 0, 0).toEpochSecond(zoneOffset);

        Random rand = new Random();
        for (int i = 0; i < 100; ++i) {
            QuizAttempt quizAttempt = new QuizAttempt();
            double totalScore =
                rand.nextInt((MAX_TOTAL_SCORE - MIN_TOTAL_SCORE) + 1) + MIN_TOTAL_SCORE;
            double yourScore = rand.nextDouble() * totalScore;
            Score score = new Score(totalScore, yourScore);
            quizAttempt.setScore(score);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(ThreadLocalRandom.current().nextLong(
                START_DATE,
                END_DATE
            )), zoneOffset);
            System.out.println(localDateTime.toString());
        }
    }

    @AfterEach
    void tearDown() {
    }
}