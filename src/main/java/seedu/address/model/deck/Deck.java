package seedu.address.model.deck;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.UniqueEntryList;

/**
 * Represents a deck of flashcards
 */
public class Deck {

    private final DeckName deckName;
    private UniqueEntryList entries;
    private final FilteredList<Entry> filteredEntries;

    /**
     * Name must be present and not null
     * @param deckName name of the deck of cards
     */
    public Deck(DeckName deckName) {
        requireNonNull(deckName);
        this.deckName = deckName;
        this.entries = new UniqueEntryList();
        this.filteredEntries = new FilteredList<>(getEntryList());
    }

    public DeckName getDeckName() {
        return this.deckName;
    }

    public UniqueEntryList getEntries() {
        return this.entries;
    }

    public ObservableList<Entry> getEntryList() {
        return entries.asUnmodifiableObservableList();
    }

    public ObservableList<Entry> getFilteredEntryList() {
        return filteredEntries;
    }

    public void updateFilteredEntryList(Predicate<Entry> predicate) {
        requireNonNull(predicate);
        filteredEntries.setPredicate(predicate);
    }

    public boolean hasEntry(Entry entry) {
        return entries.contains(entry);
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
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
        return Objects.hash(deckName, entries);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDeckName())
                .append(" Cards: ");
        for (Entry entry : entries) {
            builder.append (entry.toString());
        }
        return builder.toString();
    }
}
