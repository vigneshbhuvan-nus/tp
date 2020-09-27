package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class WordTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Word(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Word(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Word.isValidName(null));

        // invalid name
        assertFalse(Word.isValidName("")); // empty string
        assertFalse(Word.isValidName(" ")); // spaces only
        assertFalse(Word.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Word.isValidName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Word.isValidName("peter jack")); // alphabets only
        assertTrue(Word.isValidName("12345")); // numbers only
        assertTrue(Word.isValidName("peter the 2nd")); // alphanumeric characters
        assertTrue(Word.isValidName("Capital Tan")); // with capital letters
        assertTrue(Word.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
    }
}
