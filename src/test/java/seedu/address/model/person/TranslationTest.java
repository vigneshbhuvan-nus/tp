package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TranslationTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Translation(null));
    }

    @Test
    public void constructor_invalidTranslation_throwsIllegalArgumentException() {
        String invalidTranslation = "";
        assertThrows(IllegalArgumentException.class, () -> new Translation(invalidTranslation));
    }

    @Test
    public void isValidTranslation() {
        // null translation
        assertThrows(NullPointerException.class, () -> Translation.isValidTranslation(null));

        // blank translation
        assertFalse(Translation.isValidTranslation("")); // empty string
        assertFalse(Translation.isValidTranslation(" ")); // spaces only

        // missing parts
        assertFalse(Translation.isValidTranslation("@example.com")); // missing local part
        assertFalse(Translation.isValidTranslation("peterjackexample.com")); // missing '@' symbol
        assertFalse(Translation.isValidTranslation("peterjack@")); // missing domain name
        // invalid parts
        assertFalse(Translation.isValidTranslation("peterjack@-")); // invalid domain name
        assertFalse(Translation.isValidTranslation("peterjack@exam_ple.com")); // underscore in domain name
        assertFalse(Translation.isValidTranslation("peter jack@example.com")); // spaces in local part
        assertFalse(Translation.isValidTranslation("peterjack@exam ple.com")); // spaces in domain name
        assertFalse(Translation.isValidTranslation(" peterjack@example.com")); // leading space
        assertFalse(Translation.isValidTranslation("peterjack@example.com ")); // trailing space
        assertFalse(Translation.isValidTranslation("peterjack@@example.com")); // double '@' symbol
        assertFalse(Translation.isValidTranslation("peter@jack@example.com")); // '@' symbol in local part
        assertFalse(Translation.isValidTranslation("peterjack@example@com")); // '@' symbol in domain name
        assertFalse(Translation.isValidTranslation("peterjack@.example.com")); // domain name starts with a period
        assertFalse(Translation.isValidTranslation("peterjack@example.com.")); // domain name ends with a period
        assertFalse(Translation.isValidTranslation("peterjack@-example.com")); // domain name starts with a hyphen
        assertFalse(Translation.isValidTranslation("peterjack@example.com-")); // domain name ends with a hyphen

        // valid translation
        assertTrue(Translation.isValidTranslation("PeterJack_1190@example.com"));
        assertTrue(Translation.isValidTranslation("a@bc")); // minimal
        assertTrue(Translation.isValidTranslation("test@localhost")); // alphabets only
        assertTrue(Translation.isValidTranslation("!#$%&'*+/=?`{|}~^.-@example.org"));
        // special characters local part
        assertTrue(Translation.isValidTranslation("123@145")); // numeric local part and domain name
        assertTrue(Translation.isValidTranslation("a1+be!@example1.com"));
        // mixture of alphanumeric and special characters
        assertTrue(Translation.isValidTranslation("peter_jack@very-very-very-long-example.com")); // long domain name
        assertTrue(Translation.isValidTranslation("if.you.dream.it_you.can.do.it@example.com")); // long local part
    }
}
