package seedu.address.logic.commands.deck;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.deck.TypicalDecks.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code RemoveDeckCommand}.
 */
public class RemoveDeckCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_invalidRemoveIndex_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredDeckList().size() + 1);
        RemoveDeckCommand removeDeckCommand = new RemoveDeckCommand(outOfBoundIndex);

        assertCommandFailure(removeDeckCommand, model, Messages.MESSAGE_INVALID_DECK_DISPLAYED_INDEX);
    }
}
