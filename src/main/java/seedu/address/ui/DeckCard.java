package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.entry.Entry;

/**
 * An UI component that displays information of a {@code Entry}.
 */
public class DeckCard extends UiPart<Region> {

    private static final String FXML = "EntryListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Deck entry;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label email;

    /**
     * Creates a {@code EntryCode} with the given {@code Entry} and index to display.
     */
    public DeckCard(Deck entry, int displayedIndex) {
        super(FXML);
        this.entry = entry;
        id.setText(displayedIndex + ". ");
        name.setText(entry.getDeckName().toString());
        email.setText("Entries:");
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeckCard)) {
            return false;
        }

        // state check
        DeckCard card = (DeckCard) other;
        return id.getText().equals(card.id.getText())
                && entry.equals(card.entry);
    }
}
