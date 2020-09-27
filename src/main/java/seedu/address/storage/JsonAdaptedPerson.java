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

    private final String name;
    private final String email;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name,
            @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Converts a given {@code Entry} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Entry source) {
        name = source.getName().fullName;
        email = source.getEmail().value;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Entry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Entry toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Word.class.getSimpleName()));
        }
        if (!Word.isValidName(name)) {
            throw new IllegalValueException(Word.MESSAGE_CONSTRAINTS);
        }
        final Word modelName = new Word(name);
        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Translation.class.getSimpleName()));
        }
        if (!Translation.isValidEmail(email)) {
            throw new IllegalValueException(Translation.MESSAGE_CONSTRAINTS);
        }
        final Translation modelEmail = new Translation(email);
        return new Entry(modelName, modelEmail);
    }

}
