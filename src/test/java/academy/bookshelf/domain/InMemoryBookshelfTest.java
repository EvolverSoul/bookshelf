package academy.bookshelf.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryBookshelfTest {

    InMemoryBookshelf inMemoryBookshelf = new InMemoryBookshelf();
    Book book = new Book("Title", "Author", "Genre", "Subgenre");


    @Test
    public void aBookCanBeAddedToTheBookShelf(){
        inMemoryBookshelf.add(book);
        assertThat(inMemoryBookshelf.contains(book)).isTrue();
    }

    @Test
    public void aBookCanBeRemovedFromTheBookshelf(){
        inMemoryBookshelf.add(book);
        inMemoryBookshelf.remove(book);
        assertThat(inMemoryBookshelf.hasNoBooks()).isTrue();
    }

    @Test
    public void hasNoBooksShouldReturnFalseIfThereAreBooks(){
        inMemoryBookshelf.add(book);
        assertThat(inMemoryBookshelf.hasNoBooks()).isFalse();
    }


    @Test
    public void listsBooksByGenre(){
        Book sciFiBook = new Book("Included as sci fi", "me", "fiction", "science" );
        inMemoryBookshelf.add(sciFiBook);

        Book cookBook = new Book("Not included - wrong genre", "them", "non-fiction", "cookery");
        inMemoryBookshelf.add(cookBook);

        List<Book> actualBooks = inMemoryBookshelf.findBooksByGenre("fiction");

        assertThat(actualBooks).containsExactly(sciFiBook);
    }

    @Test
    public void findAllBooksShouldReturnAListOfBooks(){
        List<Book> books = inMemoryBookshelf.findAllBooks();
        assertThat(books).containsExactly(); // Not correct implementation, discuss with Alan
    }

    @Test
    public void findsBookByID(){
        Book book1 = new Book("book1", "", "", "");
        inMemoryBookshelf.add(book1);

        Book book = inMemoryBookshelf.findBook(1);

        assertThat(book.getTitle()).isEqualTo("book1");
    }

    @Test(expected = BookNotFoundException.class)
    public void findBookReportsBookNotFound(){
        inMemoryBookshelf.findBook(1);
    }

    @Test(expected = BookNotFoundException.class)
    public void removesBookByIdWhenPresent(){
        Book book1 = new Book("book1", "", "", "");
        int id = inMemoryBookshelf.add(book1);

        inMemoryBookshelf.remove(id);
        // Expect to throw exception
        inMemoryBookshelf.findBook(id);
    }

    @Test(expected = BookNotFoundException.class)
    public void removesBookByIdWhenNotPresent(){
        // InMemoryBookshelf is empty.
        inMemoryBookshelf.remove(1);
        // Expect to throw exception
        inMemoryBookshelf.findBook(1);
    }


}
