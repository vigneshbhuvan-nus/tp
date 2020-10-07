package seedu.address.testutil.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.deck.Deck;

public class TypicalDecks {
    public static final Deck JAPANESE_DECK = new DeckBuilder().withDeckName("Japanese").build();
    public static final Deck SPANISH_DECK = new DeckBuilder().withDeckName("Spanish").build();
    public static final Deck KOREAN_DECK = new DeckBuilder().withDeckName("Korean").build();
    public static final Deck FRENCH_DECK = new DeckBuilder().withDeckName("French").build();
    public static final Deck GERMAN_DECK = new DeckBuilder().withDeckName("German").build();

    private TypicalDecks() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical decks.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Deck deck : getTypicalDecks()) {
            ab.addDeck(deck);
        }
        return ab;
    }

    public static List<Deck> getTypicalDecks() {
        return new ArrayList<>(Arrays.asList(JAPANESE_DECK, SPANISH_DECK, KOREAN_DECK));
    }
}
