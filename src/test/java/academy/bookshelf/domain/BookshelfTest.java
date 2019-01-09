package academy.bookshelf.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookshelfTest {

    Bookshelf bookshelf = new Bookshelf();
    Book book = new Book("Title", "Author", "Genre", "Subgenre");


    @Test
    public void aBookCanBeAddedToTheBookShelf(){
        bookshelf.add(book);
        assertThat(bookshelf.contains(book)).isTrue();
    }

    @Test
    public void aBookCanBeRemovedFromTheBookshelf(){
        bookshelf.add(book);
        bookshelf.remove(book);
        assertThat(bookshelf.hasNoBooks()).isTrue();
    }

    @Test
    public void hasNoBooksShouldReturnFalseIfThereAreBooks(){
        bookshelf.add(book);
        assertThat(bookshelf.hasNoBooks()).isFalse();
    }


    @Test
    public void listsBooksByGenre(){
        Book sciFiBook = new Book("Included as sci fi", "me", "fiction", "science" );
        bookshelf.add(sciFiBook);

        Book cookBook = new Book("Not included - wrong genre", "them", "non-fiction", "cookery");
        bookshelf.add(cookBook);

        List<Book> actualBooks = bookshelf.findBooksByGenre("fiction");

        assertThat(actualBooks).containsExactly(sciFiBook);
    }

    @Test
    public void findAllBooksShouldReturnAListOfBooks(){
        List<Book> books = bookshelf.findAllBooks();
        assertThat(books).containsExactly(); // Not correct implementation, discuss with Alan
    }
}
