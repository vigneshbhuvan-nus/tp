package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;

public class StartPanel extends UiPart<Region> {
    
    private static final String FXML = "StartPanel.fxml";
    
    @FXML
    private Label startMessage;
    private Label headerMessage;
    private Label commandMessage;

    /**
     * Constructor for the start panel
     */
    public StartPanel() {
        super(FXML);
        headerMessage = new Label("Welcome to Green Tea!");
        commandMessage = new Label("Here are some commands you can try:\n"
                + "new deck\n"
                + "remove deck \n"
                + "select deck \n");
        startMessage.setTextAlignment(TextAlignment.CENTER);
        startMessage.getChildrenUnmodifiable().addAll(headerMessage, commandMessage);
    }
}
