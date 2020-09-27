package seedu.address.testutil;

import seedu.address.model.person.Entry;
import seedu.address.model.person.Translation;
import seedu.address.model.person.Word;

/**
 * A utility class to help with building Entry objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    private Word name;
    private Translation email;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Word(DEFAULT_NAME);
        email = new Translation(DEFAULT_EMAIL);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Entry personToCopy) {
        name = personToCopy.getName();
        email = personToCopy.getEmail();
    }

    /**
     * Sets the {@code Word} of the {@code Entry} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Word(name);
        return this;
    }

    /**
     * Sets the {@code Translation} of the {@code Entry} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Translation(email);
        return this;
    }

    public Entry build() {
        return new Entry(name, email);
    }

}
