package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.UniqueEntryList;

import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckName;


/**
 * Jackson-friendly version of {@link Deck}.
 */
class JsonAdaptedDeck {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Entry's %s field is missing!";
    private final String deckName;
    private final ObservableList<Entry> internalList;

    /**
     * Constructs a {@code JsonAdaptedDeck} with the given entry details.
     *
     */
    @JsonCreator
    public JsonAdaptedDeck(@JsonProperty("deckname") String deckName,
                           @JsonProperty("internallist") ObservableList<Entry> internalList) {
        this.deckName = deckName;
        this.internalList = internalList;
    }

    /**
     * Converts a given {@code Deck} into this class for Jackson use.
     */
    public JsonAdaptedDeck(Deck deck) {
        this.deckName = deck.getDeckName().deckName;
        this.internalList = deck.getEntries().asUnmodifiableObservableList();
    }

    /**
     * Converts this Jackson-friendly adapted entry object into the model's {@code Entry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted entry.
     */
    public Deck toModelType() throws IllegalValueException {

        if (deckName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, DeckName.class.getSimpleName()));
        }
        if (!DeckName.isValidDeckName(deckName)) {
            throw new IllegalValueException(DeckName.MESSAGE_CONSTRAINTS);
        }
        final DeckName modelDeckName = new DeckName(deckName);
        if (internalList == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    UniqueEntryList.class.getSimpleName()));
        }
        final UniqueEntryList modelEntries = new UniqueEntryList();
        modelEntries.setEntries(internalList);
        final Deck deck = new Deck(modelDeckName);
        deck.setEntries(modelEntries);
        return deck;
    }

}
