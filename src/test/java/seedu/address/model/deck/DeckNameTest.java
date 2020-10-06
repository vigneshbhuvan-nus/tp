package seedu.address.model.deck;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DeckNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeckName(null));
    }

    @Test
    public void constructor_invalidDeckName_throwsIllegalArgumentException() {
        String invalidDeck = "";
        assertThrows(IllegalArgumentException.class, () -> new DeckName(invalidDeck));
    }

    @Test
    public void isValidDeckName() {
        // null deck name
        assertThrows(NullPointerException.class, () -> DeckName.isValidDeckName(null));

        // invalid deck name
        assertFalse(DeckName.isValidDeckName("")); // empty string
        assertFalse(DeckName.isValidDeckName(" ")); // spaces only

        // valid deck name
        assertTrue(DeckName.isValidDeckName("French")); // allows alphabets
        assertTrue(DeckName.isValidDeckName("Español")); // allows special characters
        assertTrue(DeckName.isValidDeckName("日本語")); // allows special characters
        assertTrue(DeckName.isValidDeckName("Korean 1")); // allows numbers
        assertTrue(DeckName.isValidDeckName("Japanese Intermediate 2 Lesson 5")); // long names
    }
}
