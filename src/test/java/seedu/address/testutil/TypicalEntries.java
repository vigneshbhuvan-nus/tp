package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSLATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSLATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.entry.Entry;

/**
 * A utility class containing a list of {@code Entry} objects to be used in tests.
 */
public class TypicalEntries {

    public static final Entry ALICE = new EntryBuilder().withWord("Time")
            .withTranslation("時間").build();
    public static final Entry BENSON = new EntryBuilder().withWord("Benson Meier")
            .withTranslation("johnd@example.com").build();
    public static final Entry CARL = new EntryBuilder().withWord("Carl Kurz")
            .withTranslation("heinz@example.com").build();
    public static final Entry DANIEL = new EntryBuilder().withWord("Daniel Meier")
            .withTranslation("cornelia@example.com").build();
    public static final Entry ELLE = new EntryBuilder().withWord("Elle Meyer")
            .withTranslation("werner@example.com").build();
    public static final Entry FIONA = new EntryBuilder().withWord("Fiona Kunz")
            .withTranslation("lydia@example.com").build();
    public static final Entry GEORGE = new EntryBuilder().withWord("George Best")
            .withTranslation("anna@example.com").build();

    // Manually added
    public static final Entry HOON = new EntryBuilder().withWord("Hoon Meier")
            .withTranslation("stefan@example.com").build();
    public static final Entry IDA = new EntryBuilder().withWord("Ida Mueller")
            .withTranslation("hans@example.com").build();

    // Manually added - Entry's details found in {@code CommandTestUtil}
    public static final Entry AMY = new EntryBuilder().withWord(VALID_WORD_AMY)
            .withTranslation(VALID_TRANSLATION_AMY).build();
    public static final Entry BOB = new EntryBuilder().withWord(VALID_WORD_BOB)
            .withTranslation(VALID_TRANSLATION_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalEntries() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical entries.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Entry entry : getTypicalEntries()) {
            ab.addEntry(entry);
        }
        return ab;
    }

    public static List<Entry> getTypicalEntries() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
