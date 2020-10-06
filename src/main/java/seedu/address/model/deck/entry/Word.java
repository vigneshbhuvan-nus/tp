package seedu.address.model.deck.entry;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Entry's word in the word bank.
 * Guarantees: immutable; is valid as declared in {@link #isValidWord(String)}
 */
public class Word {

    public static final String MESSAGE_CONSTRAINTS =
            "Words should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    public final String word;

    /**
     * Constructs a {@code Word}.
     *
     * @param word A valid word.
     */
    public Word(String word) {
        requireNonNull(word);
        checkArgument(isValidWord(word), MESSAGE_CONSTRAINTS);
        this.word = word;
    }

    /**
     * Returns true if a given string is a valid word.
     */
    public static boolean isValidWord(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Word // instanceof handles nulls
                && word.equals(((Word) other).word)); // state check
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

}
