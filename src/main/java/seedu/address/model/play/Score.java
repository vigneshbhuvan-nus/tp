package seedu.address.model.play;

public class Score {
    double maxScore;
    double yourScore;

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

    @Override
    public String toString() {
        return "Score{" +
            "maxScore=" + maxScore +
            ", yourScore=" + yourScore +
            '}';
    }
}
