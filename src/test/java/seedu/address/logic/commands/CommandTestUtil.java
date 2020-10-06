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
import seedu.address.logic.commands.entry.EditCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.WordContainsKeywordsPredicate;
import seedu.address.testutil.entry.EditEntryDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_WORD_JAPANESE = "Earth";
    public static final String VALID_WORD_SPANISH = "Please";
    public static final String VALID_TRANSLATION_JAPANESE = "地球";
    public static final String VALID_TRANSLATION_SPANISH = "Por favor";

    public static final String WORD_DESC_AMY = " " + PREFIX_WORD + VALID_WORD_JAPANESE;
    public static final String WORD_DESC_BOB = " " + PREFIX_WORD + VALID_WORD_SPANISH;
    public static final String TRANSLATION_DESC_AMY = " " + PREFIX_TRANSLATION + VALID_TRANSLATION_JAPANESE;
    public static final String TRANSLATION_DESC_BOB = " " + PREFIX_TRANSLATION + VALID_TRANSLATION_SPANISH;

    public static final String INVALID_WORD_DESC = " " + PREFIX_WORD + "James&"; // '&' not allowed in words
    public static final String INVALID_TRANSLATION_DESC = " " + PREFIX_TRANSLATION + "  "; // blank translation

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditEntryDescriptor DESC_AMY;
    public static final EditCommand.EditEntryDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditEntryDescriptorBuilder().withWord(VALID_WORD_JAPANESE)
                .withTranslation(VALID_TRANSLATION_JAPANESE).build();
        DESC_BOB = new EditEntryDescriptorBuilder().withWord(VALID_WORD_SPANISH)
                .withTranslation(VALID_TRANSLATION_SPANISH).build();
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
