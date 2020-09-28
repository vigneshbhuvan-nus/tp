package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TRANSLATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WORD;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditEntryDescriptor;
import seedu.address.model.person.Entry;

/**
 * A utility class for Entry.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Entry person) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Entry person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_WORD + person.getWord().word + " ");
        sb.append(PREFIX_TRANSLATION + person.getTranslation().translation+ " ");
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditEntryDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getWord().ifPresent(name -> sb.append(PREFIX_WORD).append(name.word).append(" "));
        descriptor.getTranslation().ifPresent(email -> sb.append(PREFIX_TRANSLATION).append(email.translation).append(" "));
        return sb.toString();
    }
}
