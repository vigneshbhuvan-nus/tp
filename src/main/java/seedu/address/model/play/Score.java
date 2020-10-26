package seedu.address.model.play;

public class Score {
    double maxScore;
    double yourScore;
    public static final String MESSAGE_CONSTRAINTS = "Score cannot be negative";

    public Score(double maxScore, double yourScore) {
        this.maxScore = maxScore;
        this.yourScore = yourScore;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public double getYourScore() {
        return yourScore;
    }

    public static boolean isValidScore(double score) {
        if (score < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Score{" +
            "maxScore=" + maxScore +
            ", yourScore=" + yourScore +
            '}';
    }
}
