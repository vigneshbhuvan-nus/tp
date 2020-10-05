package seedu.address.model.deck;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.UniqueEntryList;

/**
 * Represents a deck of flashcards
 */
public class Deck {

    private final DeckName deckName;
    private UniqueEntryList cards;

    /**
     * Name must be present and not null
     * @param deckName name of the deck of cards
     */
    public Deck(DeckName deckName) {
        requireNonNull(deckName);
        this.deckName = deckName;
        this.cards = new UniqueEntryList();
    }

    public DeckName getDeckName() {
        return this.deckName;
    }

    public UniqueEntryList getCards() {
        return this.cards;
    }

    /**
     * Two decks are considered to be the same if they have the same name
     * This defines a notion of equality between the two decks
     *
     * @param otherDeck to be compared with the current deck
     * @return true if both decks have the same name
     */
    public boolean isSameDeck(Deck otherDeck) {
        if (otherDeck == this) {
            return true;
        }
        return otherDeck != null
                && otherDeck.getDeckName().equals(getDeckName());
    }

    /**
     * Returns true if both decks have the same name
     * This defines a notion of equality between two deck objects
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deck // instanceof handles nulls
                && getDeckName().equals(((Deck) other).getDeckName())); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckName, cards);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDeckName())
                .append(" Cards: ");
        for (Entry entry : cards) {
            builder.append (entry.toString());
        }
        return builder.toString();
    }
}
