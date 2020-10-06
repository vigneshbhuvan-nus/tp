package seedu.address.testutil.deck;

import seedu.address.model.deck.Deck;

public class TypicalDecks {
    
    public static final Deck JAPANESE_DECK = new DeckBuilder().withDeckName("Japanese").build();
    public static final Deck SPANISH_DECK = new DeckBuilder().withDeckName("Spanish").build();

    private TypicalDecks() {} // prevents instantiation
}
