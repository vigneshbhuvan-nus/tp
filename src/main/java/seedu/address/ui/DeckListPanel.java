package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deck.Deck;

import java.util.logging.Logger;

/**
 * Panel containing the list of entries.
 */
public class DeckListPanel extends UiPart<Region> {
    private static final String FXML = "EntryListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(DeckListPanel.class);

    @FXML
    private ListView<Deck> entryListView;

    @FXML
    private ListView<Deck> entryListViewTwo;

    /**
     * Creates a {@code EntryListPanel} with the given {@code ObservableList}.
     */
    public DeckListPanel(ObservableList<Deck> entryList) {
        super(FXML);
        entryListView.setItems(entryList);
        entryListView.setCellFactory(listView -> new EntryListViewCell());
    }

    public DeckListPanel(ObservableList<Deck> entryList, String type) {
        super(FXML);
        entryListView.setItems(entryList); //refers to class below
        entryListView.setCellFactory(listView -> new EntryListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Entry} using a {@code EntryCard}.
     */
    class EntryListViewCell extends ListCell<Deck> {
        @Override
        protected void updateItem(Deck entry, boolean empty) {
            super.updateItem(entry, empty);

            if (empty || entry == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntryCard(entry, getIndex() + 1).getRoot());
            }
        }
    }

}
