package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedEntry.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Translation;
import seedu.address.model.person.Word;

public class JsonAdaptedEntryTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_EMAIL = "example.com";

    private static final String VALID_NAME = BENSON.getWord().toString();
    private static final String VALID_EMAIL = BENSON.getTranslation().toString();

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedEntry person = new JsonAdaptedEntry(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedEntry person =
                new JsonAdaptedEntry(INVALID_NAME, VALID_EMAIL);
        String expectedMessage = Word.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedEntry person = new JsonAdaptedEntry(null, VALID_EMAIL);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Word.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedEntry person =
                new JsonAdaptedEntry(VALID_NAME, INVALID_EMAIL);
        String expectedMessage = Translation.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedEntry person = new JsonAdaptedEntry(VALID_NAME, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Translation.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
}
