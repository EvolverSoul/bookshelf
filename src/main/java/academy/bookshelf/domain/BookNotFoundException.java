package academy.bookshelf.domain;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Could not find book " + id);
    }
}
