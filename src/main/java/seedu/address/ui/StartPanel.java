package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class StartPanel extends UiPart<Region> {
    
    private static final String FXML = "StartPanel.fxml";
    
    @FXML
    private TextFlow startMessage;
    private Label headerMessage;
    private Label commandMessage;

    /**
     * Constructor for the start panel
     */
    public StartPanel() {
        super(FXML);
        headerMessage = new Label("Welcome to Green Tea!\n");
        commandMessage = new Label("Here are some commands you can try:\n"
                + "new deck\n"
                + "remove deck \n"
                + "select deck \n");
        startMessage.setTextAlignment(TextAlignment.CENTER);
        startMessage.getChildren().addAll(headerMessage, commandMessage);
    }
}
