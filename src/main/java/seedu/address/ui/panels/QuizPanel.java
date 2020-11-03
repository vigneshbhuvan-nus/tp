package seedu.address.ui.panels;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Region;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.play.Leitner;
import seedu.address.ui.UiPart;

public class QuizPanel extends UiPart<Region> {

    private static final String FXML = "QuizPanel.fxml";

    private final int currentIndex;
    private int totalQuestionNumber;
    private int questionsLeftNumber;
    private ArrayList<Entry> shuffledEntries;
    private ArrayList<String> givenAnswers;

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
    public QuizPanel(Leitner leitner, int currentIndex) {
        super(FXML);
        this.currentIndex = currentIndex;

        initializeEntries(leitner);
        setText();
        setProgressBar();
    }

    private void initializeEntries(Leitner leitner) {
        totalQuestionNumber = leitner.getEntries().size();
        questionsLeftNumber = totalQuestionNumber - currentIndex;
        shuffledEntries = leitner.getEntries();
        givenAnswers = leitner.getGuesses();
    }

    private void setText() {
        question.setText(shuffledEntries.get(currentIndex).getTranslation().toString());
        totalQuestions.setText("Total Questions: " + totalQuestionNumber);
        questionsAnswered.setText("Questions Answered: " + currentIndex);
        questionsLeft.setText("Questions to go: " + questionsLeftNumber);
        answerList.setText(setAnswerList());
    }

    private String setAnswerList() {
        int lastFive = 0;
        StringBuilder sb = new StringBuilder();
        if (currentIndex - 5 > lastFive) {
            lastFive = currentIndex - 5;
        }
        if (currentIndex >= 1) {
            sb.append("Previous 5 Answers:\n\n");
        }
        for (int i = lastFive; i < currentIndex; i++) {
            Entry previousEntry = shuffledEntries.get(i);
            sb.append("Question: ").append(previousEntry.getTranslation().toString()).append("\n");
            sb.append("Answer: ").append(previousEntry.getWord().toString()).append("\n");
            sb.append("Your answer: ").append(givenAnswers.get(i)).append("\n");
        }
        return sb.toString();
    }

    private void setProgressBar() {
        double progress = (double) currentIndex / totalQuestionNumber;
        progressBar.setProgress(progress);
    }
}
