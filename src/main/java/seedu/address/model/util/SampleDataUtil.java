package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckName;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Entry[] getSampleEntriesJapanese() {
        return new Entry[] {
            new Entry(new Word("Apple"), new Translation("りんご")),
            new Entry(new Word("Bridge"), new Translation("橋")),
            new Entry(new Word("Cat"), new Translation("猫")),
        };
    }

    public static Entry[] getSampleEntriesSpanish() {
        return new Entry[] {
           new Entry(new Word("Summer"), new Translation("verano")),
           new Entry(new Word("Winter"), new Translation("invierno")),
           new Entry(new Word("Spring"), new Translation("primavera")),
        };
    }

    public static Deck getSampleJapaneseDeck() {
        Deck sampleJapaneseDeck = new Deck(new DeckName("Japanese"));
        for (Entry sampleJapaneseEntry : getSampleEntriesJapanese()) {
            sampleJapaneseDeck.addEntry(sampleJapaneseEntry);
        }
        return sampleJapaneseDeck;
    }

    public static Deck getSampleSpanishDeck() {
        Deck sampleSpanishDeck = new Deck(new DeckName("Spanish"));
        for (Entry sampleSpanishEntry: getSampleEntriesSpanish()) {
            sampleSpanishDeck.addEntry(sampleSpanishEntry);
        }
        return sampleSpanishDeck;
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        sampleAb.addDeck(getSampleJapaneseDeck());
        sampleAb.addDeck(getSampleSpanishDeck());
        return sampleAb;
    }
}
