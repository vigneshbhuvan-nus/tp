package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSLATION_SPANISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WORD_SPANISH;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.entry.EditCommand.EditEntryDescriptor;
import seedu.address.testutil.entry.EditEntryDescriptorBuilder;

public class EditEntryDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditEntryDescriptor descriptorWithSameValues = new EditEntryDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different word -> returns false
        EditEntryDescriptor editedAmy = new EditEntryDescriptorBuilder(DESC_AMY).withWord(VALID_WORD_SPANISH).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different translation -> returns false
        editedAmy = new EditEntryDescriptorBuilder(DESC_AMY).withTranslation(VALID_TRANSLATION_SPANISH).build();
        assertFalse(DESC_AMY.equals(editedAmy));

    }
}
