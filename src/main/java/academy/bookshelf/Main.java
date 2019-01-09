package academy.bookshelf;

import academy.bookshelf.domain.Book;
import academy.bookshelf.domain.Bookshelf;

public class Main {

    public static void main(String[] args){
        Bookshelf bookshelf = new Bookshelf();
        // Add fiction books
        bookshelf.findAllBooks();
        bookshelf.add(new Book("Kings of the Wyld", "Nicholas Eames", "Fiction", "Fantasy"));
        bookshelf.add(new Book("The Stand", "Stephen King", "Fiction", "Horror"));
        bookshelf.add(new Book("Pattern Recognition", "William Gibson", "Fiction", "Science"));
        bookshelf.add(new Book("Knots and Crosses", "Ian Rankin", "Fiction", "Crime"));

        // Add non-fiction books
        bookshelf.add(new Book("The Dead Sea Scrolls and the Christian Myth", "John M Allegro", "Non-fiction", "Religion"));
        bookshelf.add(new Book("Magicians of the Gods", "Graham Hancock", "Non-fiction", "History"));
        bookshelf.add(new Book("Total Recall", "Arnold Schwarzenegger", "Non-fiction", "Autobiography"));
        bookshelf.add(new Book("The Open Society and Its Enemies", "Karl Popper", "Non-fiction", "Philosophy"));

        bookshelf.showEntireCollection();
    }
}
