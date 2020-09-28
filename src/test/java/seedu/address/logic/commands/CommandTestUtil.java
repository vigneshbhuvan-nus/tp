package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TRANSLATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WORD;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.Entry;
import seedu.address.model.person.WordContainsKeywordsPredicate;
import seedu.address.testutil.EditEntryDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_WORD_AMY = "Amy Bee";
    public static final String VALID_WORD_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_TRANSLATION_AMY = "amy@example.com";
    public static final String VALID_TRANSLATION_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";

    public static final String WORD_DESC_AMY = " " + PREFIX_WORD + VALID_WORD_AMY;
    public static final String WORD_DESC_BOB = " " + PREFIX_WORD + VALID_WORD_BOB;
    public static final String TRANSLATION_DESC_AMY = " " + PREFIX_TRANSLATION + VALID_TRANSLATION_AMY;
    public static final String TRANSLATION_DESC_BOB = " " + PREFIX_TRANSLATION + VALID_TRANSLATION_BOB;

    public static final String INVALID_WORD_DESC = " " + PREFIX_WORD + "James&"; // '&' not allowed in words
    public static final String INVALID_TRANSLATION_DESC = " " + PREFIX_TRANSLATION + "bob!yahoo"; // missing '@' symbol

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditEntryDescriptor DESC_AMY;
    public static final EditCommand.EditEntryDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditEntryDescriptorBuilder().withWord(VALID_WORD_AMY)
                .withTranslation(VALID_TRANSLATION_AMY).build();
        DESC_BOB = new EditEntryDescriptorBuilder().withWord(VALID_WORD_BOB)
                .withTranslation(VALID_TRANSLATION_BOB).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered entry list and selected entry in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Entry> expectedFilteredList = new ArrayList<>(actualModel.getFilteredEntryList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredEntryList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the entry at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showEntryAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredEntryList().size());

        Entry entry = model.getFilteredEntryList().get(targetIndex.getZeroBased());
        final String[] splitWord = entry.getWord().word.split("\\s+");
        model.updateFilteredEntryList(new WordContainsKeywordsPredicate(Arrays.asList(splitWord[0])));

        assertEquals(1, model.getFilteredEntryList().size());
    }

}
