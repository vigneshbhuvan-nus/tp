package seedu.address.logic.commands.play;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.play.Score;

/**
 * Clears GreenTea.
 */
public class AnswerCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Your Answer was: ";
    private String answer;

    /**
     * Creates a new answer command that takes in the raw user input
     */
    public AnswerCommand(String answer) {
        requireNonNull(answer);
        this.answer = answer;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.playGame(answer);
        if (model.checkScoreTwo()) { //answerCommand sees into the future by 1 move, so have to delay by 1
            Score score = model.endGame();
            return new CommandResult(MESSAGE_SUCCESS + score.toString());
        }
        return new CommandResult(MESSAGE_SUCCESS + answer);
    }
}
