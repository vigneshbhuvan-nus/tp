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

    private ArrayList<Entry> correctAnsweredEntries = new ArrayList<>();
    private ArrayList<Entry> wrongAnsweredEntries = new ArrayList<>();
    private ArrayList<Entry> quizForNextAttempt = new ArrayList<>();

    private int max;
    private int score = 0;

    /**
     * Returns a Leitner object that is essentially a flashcard memory object.
     */
    public Leitner(UniqueEntryList input) {
        //if memory has no record of quiz
        assert(!input.isEmpty());
        for (Entry entry : input) {
            this.entries.add(entry);
        }
        Collections.shuffle(entries);
        for (Entry entry : entries) {
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        max = questions.size();
    }

    public Leitner(ArrayList<Entry> organizedQuiz) {
        //if memory has record of quiz attempts, get organizedQuiz from memory
        assert(!organizedQuiz.isEmpty());
        entries = organizedQuiz;
        for (Entry entry : entries) {
            questions.add(entry.getTranslation());
            answers.add(entry.getWord());
        }
        max = questions.size();
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

    public int getScoreValue() {
        return this.score;
    }

    public UniqueEntryList getUniqueEntryList() {
        UniqueEntryList list = new UniqueEntryList();
        for (Entry entry : entries) {
            Entry quiz = new Entry(new Word("???"), entry.getTranslation());
            list.add(quiz);
        }
        assert (list.isEmpty() == false);
        return list;
    }

    public int getMax() {
        return max;
    }

    public void incrementScore() {
        this.score++;
    }

    public void correctAnswered(Entry entry) {
        correctAnsweredEntries.add(entry);
    }

    public void wrongAnswered(Entry entry) {
        wrongAnsweredEntries.add(entry);
    }

    public void organizeQuizNextAttempt() {
        System.out.println(wrongAnsweredEntries);
        System.out.println(correctAnsweredEntries);
        for (Entry entry : wrongAnsweredEntries) {
            quizForNextAttempt.add(entry);
        }
        for (Entry entry: correctAnsweredEntries) {
            quizForNextAttempt.add(entry);
        }
        //assert(quizForNextAttempt.size() == wrongAnsweredEntries.size() + correctAnsweredEntries.size());
    }

    public ArrayList<Entry> getQuizNextAttempt() {
        return quizForNextAttempt;
    }
}
