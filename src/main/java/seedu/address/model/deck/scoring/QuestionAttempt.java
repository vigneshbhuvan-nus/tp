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

    public QuestionAttempt(String answer, String guess, double score) {
        this.answer = answer;
        this.guess = guess;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getAnswer() { return answer;}

    public String getGuess() { return guess;}
}
