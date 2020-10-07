package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.entry.TypicalEntries.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.entry.AddCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.deck.entry.Entry;
import seedu.address.testutil.entry.EntryBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newEntry_success() {
        Entry validEntry = new EntryBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addEntry(validEntry);

        assertCommandSuccess(new AddCommand(validEntry), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validEntry), expectedModel);
    }

    @Test
    public void execute_duplicateEntry_throwsCommandException() {
        Entry entryInList = model.getAddressBook().getEntryList().get(0);
        assertCommandFailure(new AddCommand(entryInList), model, AddCommand.MESSAGE_DUPLICATE_ENTRY);
    }

}
