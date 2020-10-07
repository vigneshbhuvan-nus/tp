package seedu.address.logic.commands.deck.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_ENTRIES_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.entry.TypicalEntries.JAPANESE_3;
import static seedu.address.testutil.entry.TypicalEntries.SPANISH_1;
import static seedu.address.testutil.entry.TypicalEntries.SPANISH_2;
import static seedu.address.testutil.entry.TypicalEntries.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.entry.FindCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.deck.entry.WordContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        WordContainsKeywordsPredicate firstPredicate =
                new WordContainsKeywordsPredicate(Collections.singletonList("first"));
        WordContainsKeywordsPredicate secondPredicate =
                new WordContainsKeywordsPredicate(Collections.singletonList("second"));

        FindCommand findFirstCommand = new FindCommand(firstPredicate);
        FindCommand findSecondCommand = new FindCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand findFirstCommandCopy = new FindCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different entry -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noEntryFound() {
        String expectedMessage = String.format(MESSAGE_ENTRIES_LISTED_OVERVIEW, 0);
        WordContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredEntryList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredEntryList());
    }

    @Test
    public void execute_multipleKeywords_multipleEntriesFound() {
        String expectedMessage = String.format(MESSAGE_ENTRIES_LISTED_OVERVIEW, 3);
        WordContainsKeywordsPredicate predicate = preparePredicate("Cat Summer Winter");
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredEntryList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(JAPANESE_3, SPANISH_1, SPANISH_2), model.getFilteredEntryList());
    }

    /**
     * Parses {@code userInput} into a {@code WordContainsKeywordsPredicate}.
     */
    private WordContainsKeywordsPredicate preparePredicate(String userInput) {
        return new WordContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}