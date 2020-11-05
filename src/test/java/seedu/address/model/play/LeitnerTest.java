package seedu.address.model.play;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;


public class LeitnerTest {

    private UniqueEntryList uniqueEntryList = new UniqueEntryList();
    private Leitner leitner;

    @BeforeEach
    public void setUp() {
        Word word = new Word("test");
        Translation translation = new Translation("translation");
        Entry normalEntry = new Entry(word, translation);
        uniqueEntryList.add(normalEntry);
        leitner = new Leitner(uniqueEntryList);
    }

    @Test
    public void createLeitner_normalConditions_success () {
        for (Entry entry : uniqueEntryList) {
            assertTrue(leitner.getEntries().contains(entry));
            assertTrue(leitner.getAnswers().contains(entry.getWord()));
            assertTrue(leitner.getQuestions().contains(entry.getTranslation()));
        }
    }

}
