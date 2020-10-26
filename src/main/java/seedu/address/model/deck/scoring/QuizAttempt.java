package seedu.address.model.deck.scoring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import seedu.address.model.play.Score;

public class QuizAttempt {

    private Score score;
    private int duration; // time in seconds
    private LocalDateTime takenAt;
    private List<QuestionAttempt> questionAttempts;
    private Scoring scoringMethod;

    /**
     *
     * @param scoringMethod
     */
    public QuizAttempt(Scoring scoringMethod) {
        this.duration = -1; // to denote quiz in progress
        this.takenAt = LocalDateTime.now();
        this.scoringMethod = scoringMethod;
        questionAttempts = new ArrayList<>();
    }

    public void answerQuestion(String answer, String guess) {
        questionAttempts.add(new QuestionAttempt(answer, guess, scoringMethod));
    }

    /**
     *
     * @param quizLength
     */
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

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getTakenAt() {
        return takenAt;
    }

    public List<QuestionAttempt> getQuestionAttempts() {
        return questionAttempts;
    }

    public Scoring getScoringMethod() {
        return scoringMethod;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTakenAt(LocalDateTime takenAt) {
        this.takenAt = takenAt;
    }

    public void setQuestionAttempts(List<QuestionAttempt> questionAttempts) {
        this.questionAttempts = questionAttempts;
    }
}

