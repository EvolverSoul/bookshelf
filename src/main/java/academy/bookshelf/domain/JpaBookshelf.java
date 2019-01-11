package academy.bookshelf.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaBookshelf implements Bookshelf {

    private final BookRepository repository;

    @Autowired
    public JpaBookshelf(BookRepository repository){
        this.repository = repository;
    }
    @Override
    public int add(Book book) {
        return 0;
    }

    @Override
    public void remove(Book book) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public void showEntireCollection() {

    }

    @Override
    public void displayByGenre(String genre) {

    }

    @Override
    public List<Book> findBooksByGenre(String desiredGenre) {
        return null;
    }

    @Override
    public boolean hasNoBooks() {
        return false;
    }

    @Override
    public boolean contains(Book book) {
        return false;
    }

    @Override
    public Book findBook(int id) {
        return null;
    }
}
