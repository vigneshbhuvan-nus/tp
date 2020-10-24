package seedu.address.model.deck.scoring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import seedu.address.model.play.Score;

public class QuizAttempt {

    Score score;
    int duration; // time in seconds
    LocalDateTime takenAt;
    List<QuestionAttempt> questionAttempts;
    Scoring scoringMethod;

    public QuizAttempt(Scoring scoringMethod) {
        this.duration = -1; // to denote quiz in progress
        this.takenAt = LocalDateTime.now();
        this.scoringMethod = scoringMethod;
        questionAttempts = new ArrayList<>();
    }

    public void answerQuestion(String answer, String guess) {
        questionAttempts.add(new QuestionAttempt(answer, guess, scoringMethod));
    }

    public void endQuiz(int quizLength) {
        this.score = new Score(
                quizLength,
                questionAttempts.stream().mapToDouble(QuestionAttempt::getScore).sum()
                );
        this.duration = (int) this.takenAt.until(LocalDateTime.now(), ChronoUnit.SECONDS);
    }

    public Score getScore() {
        return score;
    }
}
