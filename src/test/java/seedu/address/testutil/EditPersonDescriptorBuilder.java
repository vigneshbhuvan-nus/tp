package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditEntryDescriptor;
import seedu.address.model.person.Entry;
import seedu.address.model.person.Translation;
import seedu.address.model.person.Word;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditEntryDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditEntryDescriptor();
    }

    public EditPersonDescriptorBuilder(EditEntryDescriptor descriptor) {
        this.descriptor = new EditEntryDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Entry person) {
        descriptor = new EditEntryDescriptor();
        descriptor.setWord(person.getWord());
        descriptor.setTranslation(person.getTranslation());
    }

    /**
     * Sets the {@code Word} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setWord(new Word(name));
        return this;
    }

    /**
     * Sets the {@code Translation} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setTranslation(new Translation(email));
        return this;
    }

    public EditEntryDescriptor build() {
        return descriptor;
    }
}
