package seedu.address.model.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEntries.ALICE;
import static seedu.address.testutil.TypicalEntries.BOB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.entry.exceptions.DuplicateEntryException;
import seedu.address.model.entry.exceptions.EntryNotFoundException;
import seedu.address.testutil.EntryBuilder;

public class UniqueEntryListTest {

    private final UniqueEntryList uniqueEntryList = new UniqueEntryList();

    @Test
    public void contains_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.contains(null));
    }

    @Test
    public void contains_entryNotInList_returnsFalse() {
        assertFalse(uniqueEntryList.contains(ALICE));
    }

    @Test
    public void contains_entryInList_returnsTrue() {
        uniqueEntryList.add(ALICE);
        assertTrue(uniqueEntryList.contains(ALICE));
    }

    @Test
    public void contains_entryWithSameIdentityFieldsInList_returnsTrue() {
        uniqueEntryList.add(ALICE);
        Entry editedAlice = new EntryBuilder(ALICE).build();
        assertTrue(uniqueEntryList.contains(editedAlice));
    }

    @Test
    public void add_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.add(null));
    }

    @Test
    public void add_duplicateEntry_throwsDuplicateEntryException() {
        uniqueEntryList.add(ALICE);
        assertThrows(DuplicateEntryException.class, () -> uniqueEntryList.add(ALICE));
    }

    @Test
    public void setEntry_nullTargetEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.setEntry(null, ALICE));
    }

    @Test
    public void setEntry_nullEditedEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.setEntry(ALICE, null));
    }

    @Test
    public void setEntry_targetEntryNotInList_throwsEntryNotFoundException() {
        assertThrows(EntryNotFoundException.class, () -> uniqueEntryList.setEntry(ALICE, ALICE));
    }

    @Test
    public void setEntry_editedEntryIsSameEntry_success() {
        uniqueEntryList.add(ALICE);
        uniqueEntryList.setEntry(ALICE, ALICE);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        expectedUniqueEntryList.add(ALICE);
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntry_editedEntryHasSameIdentity_success() {
        uniqueEntryList.add(ALICE);
        Entry editedAlice = new EntryBuilder(ALICE).build();
        uniqueEntryList.setEntry(ALICE, editedAlice);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        expectedUniqueEntryList.add(editedAlice);
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntry_editedEntryHasDifferentIdentity_success() {
        uniqueEntryList.add(ALICE);
        uniqueEntryList.setEntry(ALICE, BOB);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        expectedUniqueEntryList.add(BOB);
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntry_editedEntryHasNonUniqueIdentity_throwsDuplicateEntryException() {
        uniqueEntryList.add(ALICE);
        uniqueEntryList.add(BOB);
        assertThrows(DuplicateEntryException.class, () -> uniqueEntryList.setEntry(ALICE, BOB));
    }

    @Test
    public void remove_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.remove(null));
    }

    @Test
    public void remove_entryDoesNotExist_throwsEntryNotFoundException() {
        assertThrows(EntryNotFoundException.class, () -> uniqueEntryList.remove(ALICE));
    }

    @Test
    public void remove_existingEntry_removesEntry() {
        uniqueEntryList.add(ALICE);
        uniqueEntryList.remove(ALICE);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntries_nullUniqueEntryList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.setEntries((UniqueEntryList) null));
    }

    @Test
    public void setEntries_uniqueEntryList_replacesOwnListWithProvidedUniqueEntryList() {
        uniqueEntryList.add(ALICE);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        expectedUniqueEntryList.add(BOB);
        uniqueEntryList.setEntries(expectedUniqueEntryList);
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntries_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueEntryList.setEntries((List<Entry>) null));
    }

    @Test
    public void setEntries_list_replacesOwnListWithProvidedList() {
        uniqueEntryList.add(ALICE);
        List<Entry> entryList = Collections.singletonList(BOB);
        uniqueEntryList.setEntries(entryList);
        UniqueEntryList expectedUniqueEntryList = new UniqueEntryList();
        expectedUniqueEntryList.add(BOB);
        assertEquals(expectedUniqueEntryList, uniqueEntryList);
    }

    @Test
    public void setEntries_listWithDuplicateEntries_throwsDuplicateEntryException() {
        List<Entry> listWithDuplicateEntries = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicateEntryException.class, () -> uniqueEntryList.setEntries(listWithDuplicateEntries));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueEntryList.asUnmodifiableObservableList().remove(0));
    }
}
