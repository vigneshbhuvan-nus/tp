package seedu.address.model.deck;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class DeckName {

    public static final String MESSAGE_CONSTRAINTS = "Deck name cannot be blank";
    public static final String VALIDATION_REGEX = "^(?!\\s*$).+";
    public final String deckName;

    /**
     * Constructs an {@code DeckName}.
     *
     * @param deckName A valid deck name.
     */
    public DeckName(String deckName) {
        requireNonNull(deckName);
        checkArgument(isValidDeckName(deckName), MESSAGE_CONSTRAINTS);
        this.deckName = deckName;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidDeckName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getDeckName() {
        return deckName;
    }

    @Override
    public String toString() {
        return deckName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeckName // instanceof handles nulls
                && deckName.equals(((DeckName) other).deckName)); // state check
    }

    @Override
    public int hashCode() {
        return deckName.hashCode();
    }

}
