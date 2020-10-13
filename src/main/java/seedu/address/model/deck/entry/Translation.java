package seedu.address.model.deck.entry;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Entry's translation in the word bank.
 * Guarantees: immutable; is valid as declared in {@link #isValidTranslation(String)}
 */
public class Translation {
    public static final String MESSAGE_CONSTRAINTS = "Translation cannot be blank";

    public static final String VALIDATION_REGEX = "^(?!\\s*$).+";


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

    public String getTranslation() {
        return translation;
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
