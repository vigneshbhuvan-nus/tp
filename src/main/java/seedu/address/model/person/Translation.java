package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Entry's translation in the word bank.
 * Guarantees: immutable; is valid as declared in {@link #isValidTranslation(String)}
 */
public class Translation {
    private static final String SPECIAL_CHARACTERS = "!#$%&'*+/=?`{|}~^.-";
    public static final String MESSAGE_CONSTRAINTS = "Emails should be of the format local-part@domain "
            + "and adhere to the following constraints:\n"
            + "1. The local-part should only contain alphanumeric characters and these special characters, excluding "
            + "the parentheses, (" + SPECIAL_CHARACTERS + ") .\n"
            + "2. This is followed by a '@' and then a domain name. "
            + "The domain name must:\n"
            + "    - be at least 2 characters long\n"
            + "    - start and end with alphanumeric characters\n"
            + "    - consist of alphanumeric characters, a period or a hyphen for the characters in between, if any.";
    // alphanumeric and special characters
    private static final String LOCAL_PART_REGEX = "^[\\w" + SPECIAL_CHARACTERS + "]+";
    private static final String DOMAIN_FIRST_CHARACTER_REGEX = "[^\\W_]"; // alphanumeric characters except underscore
    private static final String DOMAIN_MIDDLE_REGEX = "[a-zA-Z0-9.-]*"; // alphanumeric, period and hyphen
    private static final String DOMAIN_LAST_CHARACTER_REGEX = "[^\\W_]$";
    public static final String VALIDATION_REGEX = LOCAL_PART_REGEX + "@"
            + DOMAIN_FIRST_CHARACTER_REGEX + DOMAIN_MIDDLE_REGEX + DOMAIN_LAST_CHARACTER_REGEX;


    public final String translation;

    /**
     * Constructs an {@code Translation}.
     *
     * @param translation A valid translation.
     */
    public Translation(String translation) {
        requireNonNull(translation);
        checkArgument(isValidTranslation(translation), MESSAGE_CONSTRAINTS);
        this.translation = translation;
    }

    /**
     * Returns if a given string is a valid translation.
     */
    public static boolean isValidTranslation(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return translation;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Translation // instanceof handles nulls
                && translation.equals(((Translation) other).translation)); // state check
    }

    @Override
    public int hashCode() {
        return translation.hashCode();
    }

}
