package seedu.address.testutil.entry;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

/**
 * A utility class to help with building Entry objects.
 */
public class EntryBuilder {

    public static final String DEFAULT_WORD = "Alice Pauline";
    public static final String DEFAULT_TRANSLATION = "alice@gmail.com";
    private Word word;
    private Translation translation;

    /**
     * Creates a {@code EntryBuilder} with the default details.
     */
    public EntryBuilder() {
        word = new Word(DEFAULT_WORD);
        translation = new Translation(DEFAULT_TRANSLATION);
    }

    /**
     * Initializes the EntryBuilder with the data of {@code entryToCopy}.
     */
    public EntryBuilder(Entry entryToCopy) {
        word = entryToCopy.getWord();
        translation = entryToCopy.getTranslation();
    }

    /**
     * Sets the {@code Word} of the {@code Entry} that we are building.
     */
    public EntryBuilder withWord(String word) {
        this.word = new Word(word);
        return this;
    }

    /**
     * Sets the {@code Translation} of the {@code Entry} that we are building.
     */
    public EntryBuilder withTranslation(String translation) {
        this.translation = new Translation(translation);
        return this;
    }

    public Entry build() {
        return new Entry(word, translation);
    }

}
