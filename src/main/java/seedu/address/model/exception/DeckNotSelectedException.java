package seedu.address.model.exception;

public class DeckNotSelectedException extends RuntimeException {
    public DeckNotSelectedException() {
        super("Please select a deck first. Select <index>");
    }
}
