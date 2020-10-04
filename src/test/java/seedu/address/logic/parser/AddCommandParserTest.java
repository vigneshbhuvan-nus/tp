package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TRANSLATION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_WORD_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.TRANSLATION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.TRANSLATION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSLATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_BOB;
import static seedu.address.logic.commands.CommandTestUtil.WORD_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.WORD_DESC_BOB;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalEntries.AMY;
import static seedu.address.testutil.TypicalEntries.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.entry.AddCommand;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;
import seedu.address.testutil.EntryBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Entry expectedEntry = new EntryBuilder(BOB).build();
        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + WORD_DESC_BOB + TRANSLATION_DESC_BOB,
                new AddCommand(expectedEntry));
        // multiple words - last word accepted
        assertParseSuccess(parser, WORD_DESC_AMY + WORD_DESC_BOB + TRANSLATION_DESC_BOB,
                new AddCommand(expectedEntry));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, WORD_DESC_BOB + TRANSLATION_DESC_BOB, new AddCommand(expectedEntry));

        // multiple translations - last translation accepted
        assertParseSuccess(parser, WORD_DESC_BOB + TRANSLATION_DESC_AMY + TRANSLATION_DESC_BOB,
                new AddCommand(expectedEntry));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, WORD_DESC_BOB + TRANSLATION_DESC_BOB, new AddCommand(expectedEntry));

        // multiple tags - all accepted
        Entry expectedEntryMultipleTags = new EntryBuilder(BOB).build();
        assertParseSuccess(parser, WORD_DESC_BOB + TRANSLATION_DESC_BOB, new AddCommand(expectedEntryMultipleTags));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Entry expectedEntry = new EntryBuilder(AMY).build();
        assertParseSuccess(parser, WORD_DESC_AMY + TRANSLATION_DESC_AMY,
                new AddCommand(expectedEntry));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing word prefix
        assertParseFailure(parser, VALID_WORD_BOB + TRANSLATION_DESC_BOB, expectedMessage);

        // missing translation prefix
        assertParseFailure(parser, WORD_DESC_BOB + VALID_TRANSLATION_BOB, expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_WORD_BOB + VALID_PHONE_BOB + VALID_TRANSLATION_BOB + VALID_ADDRESS_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid word
        assertParseFailure(parser, INVALID_WORD_DESC + TRANSLATION_DESC_BOB, Word.MESSAGE_CONSTRAINTS);
        // invalid translation
        assertParseFailure(parser, WORD_DESC_BOB + INVALID_TRANSLATION_DESC, Translation.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_WORD_DESC + TRANSLATION_DESC_BOB, Word.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + WORD_DESC_BOB + TRANSLATION_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
