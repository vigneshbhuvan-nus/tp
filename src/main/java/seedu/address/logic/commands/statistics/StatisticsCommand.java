package seedu.address.logic.commands.statistics;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.view.View;

public class StatisticsCommand extends Command {

    public static final String COMMAND_WORD = "stats";
    public static final String MESSAGE_SUCCESS = "Viewing statistics.";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.setCurrentView(View.STATISTICS_VIEW);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
