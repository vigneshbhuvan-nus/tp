package seedu.address.model.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_JAPANESE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_SPANISH;
import static seedu.address.testutil.deck.TypicalDecks.JAPANESE_DECK;
import static seedu.address.testutil.deck.TypicalDecks.SPANISH_DECK;

import org.junit.jupiter.api.Test;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;
import seedu.address.testutil.deck.DeckBuilder;

public class DeckTest {

    private Deck deckTest = new Deck(new DeckName("Test"));
    private Entry validEntry = new Entry(new Word("Hello"), new Translation("Hola"));

    @Test
    public void isSameDeck() {
        // same object -> returns true
        assertTrue(JAPANESE_DECK.isSameDeck(JAPANESE_DECK));

        // null -> returns false
        assertFalse(JAPANESE_DECK.isSameDeck(null));

        // different deck name -> returns false
        Deck editedJapaneseDeck = new DeckBuilder(JAPANESE_DECK).withDeckName(VALID_WORD_JAPANESE).build();
        assertFalse(JAPANESE_DECK.isSameDeck(editedJapaneseDeck));

        // same deck name -> returns true
        Deck editedSpanishDeck = new DeckBuilder(SPANISH_DECK).build();
        assertTrue(SPANISH_DECK.isSameDeck(editedSpanishDeck));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Deck japaneseCopy = new DeckBuilder(JAPANESE_DECK).build();
        assertTrue(JAPANESE_DECK.equals(japaneseCopy));

        // same object -> returns true
        assertTrue(JAPANESE_DECK.equals(JAPANESE_DECK));

        // null -> returns false
        assertFalse(JAPANESE_DECK.equals(null));

        // different type -> returns false
        assertFalse(JAPANESE_DECK.equals(5));

        // different deck -> returns false
        assertFalse(JAPANESE_DECK.equals(SPANISH_DECK));

        // different deck name -> returns false
        Deck editedJapanese = new DeckBuilder(JAPANESE_DECK).withDeckName(VALID_WORD_SPANISH).build();
        assertFalse(JAPANESE_DECK.equals(editedJapanese));
    }


    @Test
    public void setEntries() {
        UniqueEntryList list = new UniqueEntryList();
        list.add(validEntry);
        deckTest.setEntries(list);
        assertEquals(list, deckTest.getEntries());
    }

    @Test
    public void hasEntry() {
        deckTest.addEntry(validEntry);
        assertTrue(deckTest.hasEntry(validEntry));
    }

}
