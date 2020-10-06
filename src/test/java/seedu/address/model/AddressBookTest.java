package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEntries.ALICE;
import static seedu.address.testutil.TypicalEntries.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.exceptions.DuplicateEntryException;
import seedu.address.testutil.EntryBuilder;

public class AddressBookTest {

    private final AddressBook addressBook = new AddressBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getEntryList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AddressBook newData = getTypicalAddressBook();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    @Test
    public void resetData_withDuplicateEntries_throwsDuplicateEntryException() {
        // Two entries with the same identity fields
        Entry editedAlice = new EntryBuilder(ALICE).build();
        List<Entry> newEntries = Arrays.asList(ALICE, editedAlice);
        AddressBookStub newData = new AddressBookStub(newEntries);

        assertThrows(DuplicateEntryException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasEntry_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasEntry(null));
    }

    @Test
    public void hasEntry_entryNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasEntry(ALICE));
    }

    @Test
    public void hasEntry_entryInAddressBook_returnsTrue() {
        addressBook.addEntry(ALICE);
        assertTrue(addressBook.hasEntry(ALICE));
    }

    @Test
    public void hasEntry_entryWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addEntry(ALICE);
        Entry editedAlice = new EntryBuilder(ALICE).build();
        assertTrue(addressBook.hasEntry(editedAlice));
    }

    @Test
    public void getEntryList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getEntryList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose entries list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Entry> entries = FXCollections.observableArrayList();
        private final ObservableList<Deck> decks = FXCollections.observableArrayList();

        AddressBookStub(Collection<Entry> entries) {
            this.entries.setAll(entries);
        }

        @Override
        public ObservableList<Entry> getEntryList() {
            return entries;
        }

        @Override
        public ObservableList<Deck> getDeckList() {
            return decks;
        }
    }

}
