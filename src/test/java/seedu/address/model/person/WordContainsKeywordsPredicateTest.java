package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.EntryBuilder;

public class WordContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        WordContainsKeywordsPredicate firstPredicate = new WordContainsKeywordsPredicate(firstPredicateKeywordList);
        WordContainsKeywordsPredicate secondPredicate = new WordContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        WordContainsKeywordsPredicate firstPredicateCopy = new WordContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different entry -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_wordContainsKeywords_returnsTrue() {
        // One keyword
        WordContainsKeywordsPredicate predicate = new WordContainsKeywordsPredicate(Collections.singletonList("Alice"));
        assertTrue(predicate.test(new EntryBuilder().withWord("Alice Bob").build()));

        // Multiple keywords
        predicate = new WordContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new EntryBuilder().withWord("Alice Bob").build()));

        // Only one matching keyword
        predicate = new WordContainsKeywordsPredicate(Arrays.asList("Bob", "Carol"));
        assertTrue(predicate.test(new EntryBuilder().withWord("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new WordContainsKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new EntryBuilder().withWord("Alice Bob").build()));
    }

    @Test
    public void test_wordDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        WordContainsKeywordsPredicate predicate = new WordContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new EntryBuilder().withWord("Alice").build()));

        // Non-matching keyword
        predicate = new WordContainsKeywordsPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new EntryBuilder().withWord("Alice Bob").build()));

        // Keywords match phone, translation and address, but does not match word
        predicate = new WordContainsKeywordsPredicate(Arrays.asList("12345", "alice@email.com", "Main", "Street"));
        assertFalse(predicate.test(new EntryBuilder().withWord("Alice")
                .withTranslation("alice@email.com").build()));
    }
}
