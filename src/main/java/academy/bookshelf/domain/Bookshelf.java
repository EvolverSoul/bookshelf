package academy.bookshelf.domain;

import java.util.List;
import java.util.stream.Collectors;

public interface Bookshelf {
    int add(Book book);

    void remove(Book book);

    void remove(int id);

    List<Book> findAllBooks();

    void showEntireCollection();

    void displayByGenre(String genre);

    List<Book> findBooksByGenre(String desiredGenre);

    boolean hasNoBooks();

    boolean contains(Book book);

    Book findBook(int id);
}
