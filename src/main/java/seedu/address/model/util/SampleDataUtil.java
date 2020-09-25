package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Translation;
import seedu.address.model.person.Word;
import seedu.address.model.person.Person;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Word("Alex Yeoh"), new Translation("alexyeoh@example.com")),
            new Person(new Word("Bernice Yu"), new Translation("berniceyu@example.com")),
            new Person(new Word("Charlotte Oliveiro"), new Translation("charlotte@example.com")),
            new Person(new Word("David Li"), new Translation("lidavid@example.com")),
            new Person(new Word("Irfan Ibrahim"), new Translation("irfan@example.com")),
            new Person(new Word("Roy Balakrishnan"), new Translation("royb@example.com"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }
}
