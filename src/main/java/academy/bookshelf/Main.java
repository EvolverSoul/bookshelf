package academy.bookshelf;

import academy.bookshelf.domain.Book;
import academy.bookshelf.domain.InMemoryBookshelf;

public class Main {

    public static void main(String[] args){
        InMemoryBookshelf inMemoryBookshelf = new InMemoryBookshelf();
        // Add fiction books
        inMemoryBookshelf.findAllBooks();
        inMemoryBookshelf.add(new Book("Kings of the Wyld", "Nicholas Eames", "Fiction", "Fantasy"));
        inMemoryBookshelf.add(new Book("The Stand", "Stephen King", "Fiction", "Horror"));
        inMemoryBookshelf.add(new Book("Pattern Recognition", "William Gibson", "Fiction", "Science"));
        inMemoryBookshelf.add(new Book("Knots and Crosses", "Ian Rankin", "Fiction", "Crime"));

        // Add non-fiction books
        inMemoryBookshelf.add(new Book("The Dead Sea Scrolls and the Christian Myth", "John M Allegro", "Non-fiction", "Religion"));
        inMemoryBookshelf.add(new Book("Magicians of the Gods", "Graham Hancock", "Non-fiction", "History"));
        inMemoryBookshelf.add(new Book("Total Recall", "Arnold Schwarzenegger", "Non-fiction", "Autobiography"));
        inMemoryBookshelf.add(new Book("The Open Society and Its Enemies", "Karl Popper", "Non-fiction", "Philosophy"));

        inMemoryBookshelf.showEntireCollection();
    }
}
