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
    int count;
    int current = 0;

    public Leitner(UniqueEntryList input){
        for(Entry entry: input) {
            this.entries.add(entry);
        }
        Collections.shuffle(entries);
        for (Entry entry: this.entries){
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        this.count = questions.size();
    }



}
