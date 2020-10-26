package seedu.address.model.play;

import java.util.ArrayList;
import java.util.Collections;

import seedu.address.model.deck.entry.Entry;
import seedu.address.model.deck.entry.Translation;
import seedu.address.model.deck.entry.UniqueEntryList;
import seedu.address.model.deck.entry.Word;
import seedu.address.model.deck.scoring.QuestionAttempt;
import seedu.address.model.deck.scoring.Scoring;


public class Leitner {

    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<Translation> questions = new ArrayList<>();
    private ArrayList<Word> answers = new ArrayList<>();

    /**
     * Returns a Leitner object that is essentially a flashcard memory object.
     */
    public Leitner(UniqueEntryList input) {
        assert (!input.isEmpty());
        for (Entry entry : input) {
            this.entries.add(entry);
        }
        Collections.shuffle(entries);
        for (Entry entry : this.entries) {
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        // score = new Score(questions.size() + 1, 0);
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

//    public Score getScore() {
//        return score;
//    }

    public UniqueEntryList getUniqueEntryList() {
        UniqueEntryList list = new UniqueEntryList();
        for (Entry entry : entries) {
            Entry quiz = new Entry(new Word("???"), entry.getTranslation());
            list.add(quiz);
        }
        assert (!list.isEmpty());
        return list;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

//    public void incrementScore() {
//        score.incrementYourScore();
//    }

}
