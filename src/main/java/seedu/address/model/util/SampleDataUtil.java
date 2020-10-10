package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Entry[] getSampleEntries() {
        return new Entry[] {
            new Entry(new Word("Alex Yeoh"), new Translation("alexyeoh@example.com")),
            new Entry(new Word("Bernice Yu"), new Translation("berniceyu@example.com")),
            new Entry(new Word("Charlotte Oliveiro"), new Translation("charlotte@example.com")),
            new Entry(new Word("David Li"), new Translation("lidavid@example.com")),
            new Entry(new Word("Irfan Ibrahim"), new Translation("irfan@example.com")),
            new Entry(new Word("Roy Balakrishnan"), new Translation("royb@example.com"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Entry sampleEntry : getSampleEntries()) {
            /*sampleAb.addEntry(sampleEntry);
        */}
        return sampleAb;
    }
}
