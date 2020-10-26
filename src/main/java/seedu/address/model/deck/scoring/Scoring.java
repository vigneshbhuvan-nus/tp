package seedu.address.model.deck.scoring;

public interface Scoring {
    public abstract double computeScore(String answer, String guess);
}
