package seedu.address.ui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Region;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.play.Leitner;

public class QuizPanel extends UiPart<Region> {
    private static final String FXML = "QuizPanel.fxml";

    private int totalNumberOfQuestions;
    private int numberOfQuestionsLeft;
    private ArrayList<Entry> shuffledEntries;

    @FXML
    private Label question;
    
    @FXML
    private Label totalQuestions;
    
    @FXML
    private Label questionsAnswered;
    
    @FXML
    private Label questionsLeft;
    
    @FXML
    private Label answerList;
    
    @FXML
    private ProgressBar progressBar;


    /**
     * Constructor for quiz panel
     */
    public QuizPanel (Leitner leitner, int currentIndex) {
        super(FXML);
        initializeValues (leitner, currentIndex);
        setText (leitner, currentIndex);
        setProgressBar(currentIndex);
    }

    private void initializeValues(Leitner leitner, int currentIndex) {
        totalNumberOfQuestions = leitner.getMax();
        numberOfQuestionsLeft = totalNumberOfQuestions - currentIndex;
        shuffledEntries = leitner.getEntries();
    }
    
    private void setText (Leitner leitner, int currentIndex) {
        question.setText(shuffledEntries.get(currentIndex).getTranslation().toString());
        totalQuestions.setText("Total Questions: " + Integer.toString(totalNumberOfQuestions));
        questionsAnswered.setText("Questions Answered: " + Integer.toString(currentIndex));
        questionsLeft.setText("Questions to go: " + Integer.toString(numberOfQuestionsLeft));
        answerList.setText(setAnswerList(currentIndex));
    }
    
    private String setAnswerList (int currentIndex) {
        String answerList = "";
        for (int i = 0; i < currentIndex; i++) {
            Entry previousEntry = shuffledEntries.get(i);
            if (i == 0) {
                answerList += ("Previous Answers:\n");
            }
            answerList += previousEntry.getTranslation().toString();
            answerList += ("   Answer: " + previousEntry.getWord().toString() + "\n");
        }
        return answerList;
    }
    
    private void setProgressBar (int currentIndex) {
        double progress = (double) currentIndex / totalNumberOfQuestions;
        progressBar.setProgress(progress);
    }
}
