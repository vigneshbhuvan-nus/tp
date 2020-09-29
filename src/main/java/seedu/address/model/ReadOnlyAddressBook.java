package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.person.Entry;

/**
 * Unmodifiable view of a word bank
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the entries list.
     * This list will not contain any duplicate entries.
     */
    ObservableList<Entry> getEntryList();

}
