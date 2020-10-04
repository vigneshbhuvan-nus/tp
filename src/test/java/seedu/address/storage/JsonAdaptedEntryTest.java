package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedEntry.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEntries.BENSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

public class JsonAdaptedEntryTest {
    private static final String INVALID_WORD = "R@chel";
    private static final String INVALID_TRANSLATION = "      ";

    private static final String VALID_WORD = BENSON.getWord().toString();
    private static final String VALID_TRANSLATION = BENSON.getTranslation().toString();

    @Test
    public void toModelType_validEntryDetails_returnsEntry() throws Exception {
        JsonAdaptedEntry entry = new JsonAdaptedEntry(BENSON);
        assertEquals(BENSON, entry.toModelType());
    }

    @Test
    public void toModelType_invalidWord_throwsIllegalValueException() {
        JsonAdaptedEntry entry =
                new JsonAdaptedEntry(INVALID_WORD, VALID_TRANSLATION);
        String expectedMessage = Word.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, entry::toModelType);
    }

    @Test
    public void toModelType_nullWord_throwsIllegalValueException() {
        JsonAdaptedEntry entry = new JsonAdaptedEntry(null, VALID_TRANSLATION);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Word.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, entry::toModelType);
    }

    @Test
    public void toModelType_invalidTranslation_throwsIllegalValueException() {
        JsonAdaptedEntry entry =
                new JsonAdaptedEntry(VALID_WORD, INVALID_TRANSLATION);
        String expectedMessage = Translation.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, entry::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedEntry entry = new JsonAdaptedEntry(VALID_WORD, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Translation.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, entry::toModelType);
    }
}
