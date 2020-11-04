package seedu.address.model.util;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckName;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleDataUtilTest {
    
    private AddressBook addressBookTest = new AddressBook();
    
    private Deck JapaneseSampleDeckTest() {
        Deck deck = new Deck(new DeckName("Japanese"));
        deck.addEntry(new Entry (new Word("Apple"), new Translation("りんご")));
        deck.addEntry(new Entry (new Word("Bridge"), new Translation("橋")));
        deck.addEntry(new Entry (new Word("Cat"), new Translation("猫")));
        return deck;
    }
    
    private Deck SpanishSampleDeckTest() {
        Deck deck = new Deck (new DeckName("Spanish"));
        deck.addEntry(new Entry (new Word("Summer"), new Translation("verano")));
        deck.addEntry(new Entry(new Word("Winter"), new Translation("invierno")));
        deck.addEntry(new Entry(new Word("Spring"), new Translation("primavera")));
        return deck;
    }
    
    @Test
    public void getSampleAddressBook_sameFieldsAddressBook_success() {
        addressBookTest.addDeck(JapaneseSampleDeckTest());
        addressBookTest.addDeck(SpanishSampleDeckTest());
        assertEquals(addressBookTest, SampleDataUtil.getSampleAddressBook());
    }
}
