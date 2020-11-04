package seedu.address.model.play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD;

public class ScoreTest {
    
    private Score score = new Score(INDEX_THIRD.getZeroBased(), INDEX_SECOND.getZeroBased());
    
    @Test
    public void getMaxScoreTest() {
        assertEquals(score.getMaxScore(), INDEX_THIRD.getZeroBased());
    }
    
    @Test
    public void getYourScoreTest() {
        assertEquals(score.getYourScore(), INDEX_SECOND.getZeroBased());
    }
    
    @Test
    public void getScoreInPercentageTest() {
        double expectedPercentage = ((double) INDEX_SECOND.getZeroBased()/ INDEX_THIRD.getZeroBased()) * 100;
        assertEquals(expectedPercentage, score.getScoreInPercentage());
    }
    
    @Test
    public void toStringTest() {
        String expectedString = "Score{maxScore=" + (double) INDEX_THIRD.getZeroBased() + ", yourScore="
                + (double) INDEX_SECOND.getZeroBased() + "}";
        assertEquals(expectedString, score.toString());
    }
}
