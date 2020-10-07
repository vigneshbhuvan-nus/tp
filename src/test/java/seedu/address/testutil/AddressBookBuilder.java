package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.deck.Deck;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withEntry("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Deck} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withDeck(Deck deck) {
        addressBook.addDeck(deck);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
