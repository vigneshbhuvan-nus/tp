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
    public void constructor_invalidEmail_throwsIllegalArgumentException() {
        String invalidEmail = "";
        assertThrows(IllegalArgumentException.class, () -> new Translation(invalidEmail));
    }

    @Test
    public void isValidEmail() {
        // null email
        assertThrows(NullPointerException.class, () -> Translation.isValidEmail(null));

        // blank email
        assertFalse(Translation.isValidEmail("")); // empty string
        assertFalse(Translation.isValidEmail(" ")); // spaces only

        // missing parts
        assertFalse(Translation.isValidEmail("@example.com")); // missing local part
        assertFalse(Translation.isValidEmail("peterjackexample.com")); // missing '@' symbol
        assertFalse(Translation.isValidEmail("peterjack@")); // missing domain name
        // invalid parts
        assertFalse(Translation.isValidEmail("peterjack@-")); // invalid domain name
        assertFalse(Translation.isValidEmail("peterjack@exam_ple.com")); // underscore in domain name
        assertFalse(Translation.isValidEmail("peter jack@example.com")); // spaces in local part
        assertFalse(Translation.isValidEmail("peterjack@exam ple.com")); // spaces in domain name
        assertFalse(Translation.isValidEmail(" peterjack@example.com")); // leading space
        assertFalse(Translation.isValidEmail("peterjack@example.com ")); // trailing space
        assertFalse(Translation.isValidEmail("peterjack@@example.com")); // double '@' symbol
        assertFalse(Translation.isValidEmail("peter@jack@example.com")); // '@' symbol in local part
        assertFalse(Translation.isValidEmail("peterjack@example@com")); // '@' symbol in domain name
        assertFalse(Translation.isValidEmail("peterjack@.example.com")); // domain name starts with a period
        assertFalse(Translation.isValidEmail("peterjack@example.com.")); // domain name ends with a period
        assertFalse(Translation.isValidEmail("peterjack@-example.com")); // domain name starts with a hyphen
        assertFalse(Translation.isValidEmail("peterjack@example.com-")); // domain name ends with a hyphen

        // valid email
        assertTrue(Translation.isValidEmail("PeterJack_1190@example.com"));
        assertTrue(Translation.isValidEmail("a@bc")); // minimal
        assertTrue(Translation.isValidEmail("test@localhost")); // alphabets only
        assertTrue(Translation.isValidEmail("!#$%&'*+/=?`{|}~^.-@example.org")); // special characters local part
        assertTrue(Translation.isValidEmail("123@145")); // numeric local part and domain name
        assertTrue(Translation.isValidEmail("a1+be!@example1.com")); // mixture of alphanumeric and special characters
        assertTrue(Translation.isValidEmail("peter_jack@very-very-very-long-example.com")); // long domain name
        assertTrue(Translation.isValidEmail("if.you.dream.it_you.can.do.it@example.com")); // long local part
    }
}
