package seedu.address.model.play;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;

import java.util.ArrayList;
import java.util.Collections;

public class Leitner {

    public ArrayList<Entry> entries = new ArrayList<>();
    public ArrayList<Translation> questions = new ArrayList<>();
    public ArrayList<Word> answers = new ArrayList<>();
    public int count = 0;
    public int max;

    public Leitner(UniqueEntryList input){
        for(Entry entry: input) {
            this.entries.add(entry);
        }
        Collections.shuffle(entries);
        for (Entry entry: this.entries){
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        this.max = questions.size() - 1;
    }



}
