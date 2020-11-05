package seedu.address.model.play;

import java.util.ArrayList;
import java.util.Collections;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;

public class Leitner {

    private ArrayList<Entry> entryList = new ArrayList<>();
    private ArrayList<Translation> questionList = new ArrayList<>();
    private ArrayList<Word> answerList = new ArrayList<>();
    private ArrayList<String> guesses = new ArrayList<>();

    /**
     * Returns a Leitner object that behaves as a flashcard object. Shuffles and stores the ordered entry into
     * entryList. Extracts the words and translations of each entry in entries and stores them into questionsList
     * and answerList.
     *
     * @param input A UniqueEntryList containing all the entries to quiz the user
     */
    public Leitner(UniqueEntryList input) {
        for (Entry entry : input) {
            entryList.add(entry);
        }
        Collections.shuffle(entryList); //random shuffle
        for (Entry entry : entryList) {
            questionList.add(entry.getTranslation());
            answerList.add(entry.getWord());
        }
        assert (!input.isEmpty());
        assert (!questionList.isEmpty());
        assert (!answerList.isEmpty());
    }

    public ArrayList<Word> getAnswers() {
        return answerList;
    }

    public ArrayList<Translation> getQuestions() {
        return questionList;
    }

    public ArrayList<Entry> getEntries() {
        return entryList;
    }

    public ArrayList<String> getGuesses() {
        return this.guesses;
    }

    public UniqueEntryList getUniqueEntryList() {
        UniqueEntryList list = new UniqueEntryList();
        for (Entry entry : entryList) {
            Entry quiz = new Entry(new Word("???"), entry.getTranslation());
            list.addLeitner(quiz);
        }
        assert (!list.isEmpty());
        return list;
    }

    public void addGuess(String guess) {
        this.guesses.add(guess);
    }
}
