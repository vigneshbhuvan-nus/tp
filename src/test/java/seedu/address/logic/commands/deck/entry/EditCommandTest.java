package seedu.address.logic.commands.deck.entry;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_JAPANESE;
import static seedu.address.logic.commands.CommandTestUtil.DESC_SPANISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_SPANISH;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showEntryAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.entry.TypicalEntries.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.entry.ClearCommand;
import seedu.address.logic.commands.entry.EditCommand;
import seedu.address.logic.commands.entry.EditCommand.EditEntryDescriptor;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.deck.entry.Entry;
import seedu.address.testutil.entry.EditEntryDescriptorBuilder;
import seedu.address.testutil.entry.EntryBuilder;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class EditCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Entry editedEntry = new EntryBuilder().build();
        EditEntryDescriptor descriptor = new EditEntryDescriptorBuilder(editedEntry).build();
        EditCommand editCommand = new EditCommand(INDEX_FIRST, descriptor);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_ENTRY_SUCCESS, editedEntry);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setEntry(model.getFilteredEntryList().get(0), editedEntry);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        Index indexLastEntry = Index.fromOneBased(model.getFilteredEntryList().size());
        Entry lastEntry = model.getFilteredEntryList().get(indexLastEntry.getZeroBased());

        EntryBuilder entryInList = new EntryBuilder(lastEntry);
        Entry editedEntry = entryInList.withWord(VALID_WORD_SPANISH).build();

        EditEntryDescriptor descriptor = new EditEntryDescriptorBuilder().withWord(VALID_WORD_SPANISH).build();
        EditCommand editCommand = new EditCommand(indexLastEntry, descriptor);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_ENTRY_SUCCESS, editedEntry);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setEntry(lastEntry, editedEntry);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditCommand editCommand = new EditCommand(INDEX_FIRST, new EditEntryDescriptor());
        Entry editedEntry = model.getFilteredEntryList().get(INDEX_FIRST.getZeroBased());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_ENTRY_SUCCESS, editedEntry);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {
        showEntryAtIndex(model, INDEX_FIRST);

        Entry entryInFilteredList = model.getFilteredEntryList().get(INDEX_FIRST.getZeroBased());
        Entry editedEntry = new EntryBuilder(entryInFilteredList).withWord(VALID_WORD_SPANISH).build();
        EditCommand editCommand = new EditCommand(INDEX_FIRST,
                new EditEntryDescriptorBuilder().withWord(VALID_WORD_SPANISH).build());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_ENTRY_SUCCESS, editedEntry);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setEntry(model.getFilteredEntryList().get(0), editedEntry);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_duplicateEntryUnfilteredList_failure() {
        Entry firstEntry = model.getFilteredEntryList().get(INDEX_FIRST.getZeroBased());
        EditEntryDescriptor descriptor = new EditEntryDescriptorBuilder(firstEntry).build();
        EditCommand editCommand = new EditCommand(INDEX_SECOND, descriptor);

        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_ENTRY);
    }

    @Test
    public void execute_duplicateEntryFilteredList_failure() {
        showEntryAtIndex(model, INDEX_FIRST);

        // edit entry in filtered list into a duplicate in address book
        Entry entryInList = model.getAddressBook().getEntryList().get(INDEX_SECOND.getZeroBased());
        EditCommand editCommand = new EditCommand(INDEX_FIRST,
                new EditEntryDescriptorBuilder(entryInList).build());

        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_ENTRY);
    }

    @Test
    public void execute_invalidEntryIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredEntryList().size() + 1);
        EditEntryDescriptor descriptor = new EditEntryDescriptorBuilder().withWord(VALID_WORD_SPANISH).build();
        EditCommand editCommand = new EditCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_ENTRY_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of address book
     */
    @Test
    public void execute_invalidEntryIndexFilteredList_failure() {
        showEntryAtIndex(model, INDEX_FIRST);
        Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getEntryList().size());

        EditCommand editCommand = new EditCommand(outOfBoundIndex,
                new EditEntryDescriptorBuilder().withWord(VALID_WORD_SPANISH).build());

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_ENTRY_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        final EditCommand standardCommand = new EditCommand(INDEX_FIRST, DESC_JAPANESE);

        // same values -> returns true
        EditEntryDescriptor copyDescriptor = new EditEntryDescriptor(DESC_JAPANESE);
        EditCommand commandWithSameValues = new EditCommand(INDEX_FIRST, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_SECOND, DESC_JAPANESE)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_FIRST, DESC_SPANISH)));
    }

}