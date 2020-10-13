package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckName;
import seedu.address.model.deck.entry.UniqueEntryList;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


/**
 * Jackson-friendly version of {@link Deck}.
 */
class JsonAdaptedDeck {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Entry's %s field is missing!";
    private final String deckName;
    private final List<JsonAdaptedEntry> internalList = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedDeck} with the given entry details.
     */
    @JsonCreator
    public JsonAdaptedDeck(@JsonProperty("deckname") String deckName,
                           @JsonProperty("internallist") List<JsonAdaptedEntry> internalList) {
        this.deckName = deckName;

        if(internalList != null) {
            this.internalList.addAll(internalList);
        }
    }

    /**
     * Converts a given {@code Deck} into this class for Jackson use.
     */
    public JsonAdaptedDeck(Deck source) {
        deckName = source.getDeckName().deckName;
        internalList.addAll(source.getEntryList().stream()
                .map(JsonAdaptedEntry::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted entry object into the model's {@code Entry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted entry.
     */
    public Deck toModelType() throws IllegalValueException {
        final UniqueEntryList modelInternalList = new UniqueEntryList();

        for (JsonAdaptedEntry entry : internalList) {
            modelInternalList.add(entry.toModelType());
        }

        if (deckName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DeckName.class.getSimpleName()));
        }
        if (!DeckName.isValidDeckName(deckName)) {
            throw new IllegalValueException(DeckName.MESSAGE_CONSTRAINTS);
        }
        final DeckName modelDeckName = new DeckName(deckName);

        final Deck deck = new Deck(modelDeckName);
        deck.setEntries(modelInternalList);
        return deck;
    }
}
