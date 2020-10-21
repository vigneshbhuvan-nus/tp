package seedu.address.model.play;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.Word;

import java.util.ArrayList;

public class Leitner {

    ArrayList<Entry> entries;
    ArrayList<Translation> questions = new ArrayList<>();
    ArrayList<Word> answers = new ArrayList<>();
    int count;
    int current = 0;

    public Leitner(ArrayList<Entry> input){
        this.entries = input;
        this.count = input.size();
        for (Entry entry: input){
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
    }



}
