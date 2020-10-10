package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.deck.Deck;


/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_DECK = "Deck list contains duplicate entry(s).";

    private final List<JsonAdaptedDeck> decks = new ArrayList<>();
    /*private final List<JsonAdaptedEntry> entries = new ArrayList<>();*/

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given entries.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("decks") List<JsonAdaptedDeck> decks/*,
                                       @JsonProperty("entries") List<JsonAdaptedEntry> entries*/) {
        this.decks.addAll(decks);
        /*this.entries.addAll(entries);*/
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyAddressBook source) {
        decks.addAll(source.getDeckList().stream().map(JsonAdaptedDeck::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public AddressBook toModelType() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();

        for (JsonAdaptedDeck jsonAdaptedDeck: decks) {
            Deck deck = jsonAdaptedDeck.toModelType();
            if (addressBook.hasDeck(deck)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_DECK);
            }
            addressBook.addDeck(deck);
        }
        return addressBook;
    }
}
