package seedu.address.ui.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.play.Leitner;
import seedu.address.ui.UiPart;

import java.util.ArrayList;

public class QuizPanel extends UiPart<Region> {
    private static final String FXML = "QuizPanel.fxml";
    
    private int totalNumberOfQuestions;
    private int numberOfQuestionsLeft;
    private ArrayList<Entry> shuffledEntries;
    
    @FXML
    private TextFlow quizMessage;
    private Label question;
    private Label totalQuestions;
    private Label questionsAnswered;
    private Label questionsLeft;
    private Label entriesList;

    /**
     * Constructor for quiz panel
     */
    public QuizPanel (Leitner leitner, int currentIndex) {
        super(FXML);
        initializeValues (leitner, currentIndex);
        
        question = new Label(shuffledEntries.get(currentIndex).getTranslation().toString());
        totalQuestions = new Label(Integer.toString(totalNumberOfQuestions));
        questionsAnswered = new Label (Integer.toString(currentIndex));
        questionsLeft = new Label (Integer.toString(numberOfQuestionsLeft));
        entriesList = new Label (shuffledEntries.get(0).toString());
        
        quizMessage.setTextAlignment(TextAlignment.CENTER);
        quizMessage.getChildren().addAll(question, totalQuestions, questionsAnswered, questionsLeft, entriesList);
    }
    
    private void initializeValues(Leitner leitner, int currentIndex) {
        totalNumberOfQuestions = leitner.getMax();
        numberOfQuestionsLeft = totalNumberOfQuestions - currentIndex;
        shuffledEntries = leitner.getEntries();
    }
}
