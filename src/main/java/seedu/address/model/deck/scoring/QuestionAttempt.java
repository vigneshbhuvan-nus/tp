package seedu.address.model.deck.scoring;

public class QuestionAttempt {

    String answer;
    String guess;
    double score;

    public QuestionAttempt(String answer, String guess, Scoring scoringMethod) {
        this.answer = answer;
        this.guess = guess;
        score = scoringMethod.computeScore(answer, guess);
    }

    public double getScore() {
        return score;
    }
}
