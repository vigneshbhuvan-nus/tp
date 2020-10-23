package seedu.address.ui.panels;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.address.ui.UiPart;

import javax.swing.plaf.synth.Region;

public class ScorePanel extends UiPart<Region> {
    
    private static final String FXML = "ScorePanel.fxml";

    @FXML
    private Label scoreMessage;
    
    @FXML
    private Label finalScore;
    
    @FXML
    private Label encouragementMessage;
    
    public ScorePanel (int score, int maxScore) {
        super(FXML);
        
        scoreMessage.setText("Here is your score: ");
        finalScore.setText(Integer.toString(score) + " out of " + Integer.toString(maxScore));
        encouragementMessage.setText(getEncouragementMessage(score, maxScore));
    }
    
    private String getEncouragementMessage(int score, int maxScore) {
        return null;
    }
}
