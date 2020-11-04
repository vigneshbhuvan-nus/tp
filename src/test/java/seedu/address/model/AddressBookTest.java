package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.deck.TypicalDecks.JAPANESE_DECK;
import static seedu.address.testutil.deck.TypicalDecks.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javafx.beans.Observable;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.UniqueDeckList;
import seedu.address.model.deck.exceptions.DuplicateDeckException;
import seedu.address.testutil.deck.DeckBuilder;

public class AddressBookTest {

    private final AddressBook addressBook = new AddressBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getDeckList());
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
    public void resetData_withDuplicateDecks_throwsDuplicateDeckException() {
        // Two decks with the same identity fields
        Deck editedJapaneseDeck = new DeckBuilder(JAPANESE_DECK).build();
        List<Deck> newDecks = Arrays.asList(JAPANESE_DECK, editedJapaneseDeck);
        AddressBookStub newData = new AddressBookStub(newDecks);

        assertThrows(DuplicateDeckException.class, () -> addressBook.resetData(newData));
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
    public void removeDeck_emptyAddressBook_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getDeckList().remove(0));
    }
    
    @Test
    public void removeDeck_entryInAddressBook_success() {
        ObservableList deckListCopy = addressBook.getDeckList();
        Deck validDeck = new DeckBuilder().build();
        addressBook.addDeck(validDeck);
        addressBook.removeDeck(validDeck);
        assertEquals(deckListCopy, addressBook.getDeckList());
    }

    @Test
    public void hasDeck_deckWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addDeck(JAPANESE_DECK);
        Deck editedJapaneseDeck = new DeckBuilder(JAPANESE_DECK).build();
        assertTrue(addressBook.hasDeck(editedJapaneseDeck));
    }
    
    @Test
    public void toString_emptyAddressBook_returnsZeroDecks() {
        String expectedString = addressBook.getObservedEntries().asUnmodifiableObservableList().size() + " decks";
        assertEquals(expectedString, addressBook.toString());
    }


    /**
     * A stub ReadOnlyAddressBook whose entries list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Deck> decks = FXCollections.observableArrayList();

        AddressBookStub(Collection<Deck> decks) {
            this.decks.setAll(decks);
        }

        @Override
        public ObservableList<Deck> getDeckList() {
            return decks;
        }
    }
}
