package seedu.address.logic.commands.play;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class PlayCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Playmode Initiated!!";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        //switch to playmode
        model.newGame();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
