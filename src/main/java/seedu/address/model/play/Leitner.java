package seedu.address.model.play;

import java.util.ArrayList;
import java.util.Collections;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;


public class Leitner {

    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<Translation> questions = new ArrayList<>();
    private ArrayList<Word> answers = new ArrayList<>();
    private int max;
    private int score = 0;

    /**
     * Returns a Leitner object that is essentially a flashcard memory object
     */
    public Leitner(UniqueEntryList input) {
        for (Entry entry : input) {
            this.entries.add(entry);
        }
        Collections.shuffle(entries);
        for (Entry entry : this.entries) {
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        this.max = questions.size();
    }

    public ArrayList<Translation> getQuestions() {
        return this.questions;
    }

    public ArrayList<Word> getAnswers() {
        return this.answers;
    }

    public ArrayList<Entry> getEntries() {
        return this.entries;
    }

    public String getScore() {
        return "Your score is " + score + "/" + max;
    }

    public UniqueEntryList getUniqueEntryList() {
        UniqueEntryList list = new UniqueEntryList();
        for (Entry entry : entries) {
            Entry quiz = new Entry(new Word("???"), entry.getTranslation());
            list.add(quiz);
        }
        return list;
    }

    public int getMax() {
        return max;
    }

    public void incrementScore() {
        this.score++;
    }
}
