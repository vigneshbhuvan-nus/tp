package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSLATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_BOB;
import static seedu.address.testutil.TypicalEntries.ALICE;
import static seedu.address.testutil.TypicalEntries.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.EntryBuilder;

public class EntryTest {
    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(ALICE.isSameEntry(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameEntry(null));

        // different phone and translation -> returns false
        Entry editedAlice = new EntryBuilder(ALICE).withTranslation(VALID_TRANSLATION_BOB).build();
        assertFalse(ALICE.isSameEntry(editedAlice));

        // different word -> returns false
        editedAlice = new EntryBuilder(ALICE).withWord(VALID_WORD_BOB).build();
        assertFalse(ALICE.isSameEntry(editedAlice));

        // same word, same translation, different attributes -> returns true
        editedAlice = new EntryBuilder(ALICE).build();
        assertTrue(ALICE.isSameEntry(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Entry aliceCopy = new EntryBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different word -> returns false
        Entry editedAlice = new EntryBuilder(ALICE).withWord(VALID_WORD_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different translation -> returns false
        editedAlice = new EntryBuilder(ALICE).withTranslation(VALID_TRANSLATION_BOB).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
