package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.UniqueDeckList;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.UniqueEntryList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameEntry comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    /*private final UniqueEntryList entries;*/
    private final UniqueDeckList decks;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        /*entries = new UniqueEntryList();*/
        decks = new UniqueDeckList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Entries in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the entry list with {@code entries}.
     * {@code entries} must not contain duplicate entries.
     */
    /*public void setEntries(List<Entry> entries) {
        this.entries.setEntries(entries);
    }*/

    /**
     * Replaces the contents of the entry list with {@code entries}.
     * {@code entries} must not contain duplicate entries.
     */
    public void setDecks(List<Deck> decks) {
        this.decks.setDecks(decks);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setDecks(newData.getDeckList());
    }

    //// entry-level operations

    /**
     * Returns true if an entry with the same identity as {@code entry} exists in the address book.
     */
/*    public boolean hasEntry(Entry entry) {
        requireNonNull(entry);
        return entries.contains(entry);
    }*/

    /**
     * Adds an entry to the word bank.
     * The entry must not already exist in the word bank.
     */
/*    public void addEntry(Entry entry) {
        entries.add(entry);
    }*/

    /**
     * Replaces the given entry {@code target} in the list with {@code editedEntry}.
     * {@code target} must exist in the address book.
     * The entry identity of {@code editedEntry} must not be the same as another existing entry in the address book.
     */
/*    public void setEntry(Entry target, Entry editedEntry) {
        requireNonNull(editedEntry);

        entries.setEntry(target, editedEntry);
    }*/

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
/*    public void removeEntry(Entry key) {
        entries.remove(key);
    }*/

    //// deck-level operations

    /**
     * Returns true if a deck with the same identity as {@code deck} exists in the word bank.
     */
    public boolean hasDeck(Deck deck) {
        requireNonNull(deck);
        return decks.contains(deck);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the word bank.
     */
    public void removeDeck(Deck key) {
        decks.remove(key);
    }

    /**
     * Adds a deck to the word bank.
     * The deck must not already exist in the word bank.
     */
    public void addDeck(Deck deck) {
        decks.add(deck);
    }

    //// util methods

    @Override
    public String toString() {
/*        return entries.asUnmodifiableObservableList().size() + " entries";
        // TODO: refine later*/
        return decks.asUnmodifiableObservableList().size() + " decks";
    }

    /*@Override*/
    /*public ObservableList<Entry> getEntryList() {
        return entries.asUnmodifiableObservableList();
    }*/

    @Override
    public ObservableList<Deck> getDeckList() {
        return decks.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && decks.equals(((AddressBook) other).decks));
    }

    @Override
    public int hashCode() {
        return decks.hashCode();
    }
}
