package seedu.address.logic.commands.statistics;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.view.View;

public class StatisticsCommand extends Command {

    public static final String COMMAND_WORD = "stats";
    private static String MESSAGE_SUCCESS = "Viewing statistics.";
    public final int deckIndex;

    public StatisticsCommand(int deckIndex) {
        this.deckIndex = deckIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        int currentDeckIndex = model
                .setStatisticsDeckId(deckIndex - 1); // since our decks count from deck

        if (currentDeckIndex == -1) { // invalid deck, or none
            MESSAGE_SUCCESS = "Viewing statistics across all decks.";
        } else {
            MESSAGE_SUCCESS = String.format("Viewing statistics for deck %s (id=%d)",
                    model.getFilteredDeckList().get(currentDeckIndex).getDeckName(), currentDeckIndex);
        }

        model.setCurrentView(View.STATISTICS_VIEW);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
