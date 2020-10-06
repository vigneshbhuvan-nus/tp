package seedu.address.model.deck;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class DeckName {

    public static final String MESSAGE_CONSTRAINTS = "Name cannot be blank";
    public static final String VALIDATION_REGEX = "^(?!\\s*$).+";
    private final String name;

    /**
     * Constructs an {@code DeckName}.
     *
     * @param name A valid name.
     */
    public DeckName(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), MESSAGE_CONSTRAINTS);
        this.name = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeckName // instanceof handles nulls
                && name.equals(((DeckName) other).name)); // state check
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
