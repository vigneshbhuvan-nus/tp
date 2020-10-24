package seedu.address.model.play;

public class Score {
    int maxScore;
    int yourScore;

    public Score(int maxScore, int yourScore) {
        this.maxScore = 0;
        this.yourScore = 0;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getYourScore() {
        return yourScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setYourScore(int yourScore) {
        this.yourScore = yourScore;
    }

    public void incrementYourScore() {
        this.yourScore++;
    }

    @Override
    public String toString() {
        return "Score{" +
            "maxScore=" + maxScore +
            ", yourScore=" + yourScore +
            '}';
    }
}
