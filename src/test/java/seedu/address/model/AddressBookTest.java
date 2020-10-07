package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.deck.TypicalDecks.JAPANESE_DECK;
import static seedu.address.testutil.entry.TypicalEntries.JAPANESE_1;
import static seedu.address.testutil.entry.TypicalEntries.getTypicalAddressBook;

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
import seedu.address.testutil.deck.DeckBuilder;
import seedu.address.testutil.entry.EntryBuilder;

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
        Entry editedAlice = new EntryBuilder(JAPANESE_1).build();
        List<Entry> newEntries = Arrays.asList(JAPANESE_1, editedAlice);
        AddressBookStub newData = new AddressBookStub(newEntries);

        assertThrows(DuplicateEntryException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasEntry_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasEntry(null));
    }

    @Test
    public void hasEntry_entryNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasEntry(JAPANESE_1));
    }

    @Test
    public void hasEntry_entryInAddressBook_returnsTrue() {
        addressBook.addEntry(JAPANESE_1);
        assertTrue(addressBook.hasEntry(JAPANESE_1));
    }

    @Test
    public void hasEntry_entryWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addEntry(JAPANESE_1);
        Entry editedAlice = new EntryBuilder(JAPANESE_1).build();
        assertTrue(addressBook.hasEntry(editedAlice));
    }

    @Test
    public void hasDeck_nullDeck_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasDeck(null));
    }

    @Test
    public void hasDeck_deckNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasDeck(JAPANESE_DECK));
    }

    @Test
    public void hasDeck_deckInAddressBook_returnsTrue() {
        addressBook.addDeck(JAPANESE_DECK);
        assertTrue(addressBook.hasDeck(JAPANESE_DECK));
    }

    @Test
    public void hasDeck_deckWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addDeck(JAPANESE_DECK);
        Deck editedJapaneseDeck = new DeckBuilder(JAPANESE_DECK).build();
        assertTrue(addressBook.hasDeck(editedJapaneseDeck));
    }

    @Test
    public void getEntryList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getEntryList().remove(0));
    }

    @Test
    public void getDeckList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getDeckList().remove(0));
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
