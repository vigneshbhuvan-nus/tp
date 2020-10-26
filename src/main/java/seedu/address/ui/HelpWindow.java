package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL =
            "https://github.com/AY2021S1-CS2103T-T09-4/tp/blob/master/docs/UserGuide.md\n\n";

    public static final String DECK_COMMANDS = "==============================="
                                             + "DECK COMMANDS"
                                             + "==============================\n\n";

    public static final String NEW_DECK_COMMAND = "Creating a new deck: new\n"
                                                + "Format: new <NAME OF NEW DECK> e.g. new Korean\n\n";

    public static final String REMOVE_DECK_COMMAND = "Removing an existing deck: remove\n"
                                                   + "Format: remove <DECK_INDEX> e.g. remove 2\n\n";

    public static final String SELECT_DECK_COMMAND = "Selecting an existing deck: select\n"
                                                   + "Format: select <DECK_INDEX> e.g. select 1\n\n";

    public static final String ENTRY_COMMANDS = "==============================="
                                               + "ENTRY COMMANDS"
                                               + "==============================\n\n"
                                               + "**Remember to select a deck before using an Entry command**\n\n";

    public static final String ADD_COMMAND = "Adding a new entry: add\n"
                                            + "Format: add w/<WORD> t/<TRANSLATION> e.g. add w/hola t/hello\n\n";

    public static final String LIST_COMMAND = "Listing all entries: list\n"
                                            + "Format: list e.g. list\n\n";

    public static final String EDIT_COMMAND = "Editing an entry: edit\n"
                                            + "Format: edit <INDEX> w/<WORD> t/<TRANSLATION> || "
                                            + "edit <INDEX> w/<WORD> || "
                                            + "edit <INDEX> t/<TRANSLATION> "
                                            + "e.g. edit 1 w/hello t/こんにちは || "
                                            + "edit 1 w/hello || "
                                            + "edit 1 t/こんにちは\n\n";

    public static final String DELETE_COMMAND = "Deleting an entry: delete\n"
                                            + "Format: delete <INDEX> e.g. delete 5\n\n";

    public static final String CLEAR_COMMAND = "Clearing all entries: clear\n"
                                            + "Format: clear\n\n";

    public static final String MISC_COMMAND = "==============================="
                                            + "MISC COMMANDS"
                                            + "==============================\n\n";

    public static final String EXIT_COMMAND = "Exiting the program: exit\n"
                                            + "Format: exit\n\n";

    public static final String COMMAND_LIST = DECK_COMMANDS
                                            + NEW_DECK_COMMAND + REMOVE_DECK_COMMAND + SELECT_DECK_COMMAND
                                            + ENTRY_COMMANDS
                                            + ADD_COMMAND + LIST_COMMAND + EDIT_COMMAND
                                            + DELETE_COMMAND + CLEAR_COMMAND
                                            + MISC_COMMAND
                                            + EXIT_COMMAND;

    public static final String HELP_MESSAGE = "Please refer to the user guide at this link for more information: "
                                            + USERGUIDE_URL + COMMAND_LIST;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        helpMessage.setFont(new Font("Arial", 16));
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
