package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.play.Leitner;

public class QuizPanel extends UiPart<Region> {
    private static final String FXML = "QuizPanel.fxml";
    
    @FXML
    private Label question;
    private Label totalQuestions;
    private Label questionsAnswered;
    private Label questionsLeft;
    
    public QuizPanel (Leitner leitner, int currentIndex) {
        super(FXML);
    }
}
