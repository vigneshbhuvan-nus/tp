package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Entry;
import seedu.address.model.person.Translation;
import seedu.address.model.person.Word;

/**
 * Jackson-friendly version of {@link Entry}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Entry's %s field is missing!";

    private final String word;
    private final String translation;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name,
            @JsonProperty("email") String email) {
        this.word = name;
        this.translation = email;
    }

    /**
     * Converts a given {@code Entry} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Entry source) {
        word = source.getWord().word;
        translation = source.getTranslation().translation;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Entry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Entry toModelType() throws IllegalValueException {

        if (word == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Word.class.getSimpleName()));
        }
        if (!Word.isValidWord(word)) {
            throw new IllegalValueException(Word.MESSAGE_CONSTRAINTS);
        }
        final Word modelName = new Word(word);
        if (translation == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Translation.class.getSimpleName()));
        }
        if (!Translation.isValidTranslation(translation)) {
            throw new IllegalValueException(Translation.MESSAGE_CONSTRAINTS);
        }
        final Translation modelEmail = new Translation(translation);
        return new Entry(modelName, modelEmail);
    }

}
