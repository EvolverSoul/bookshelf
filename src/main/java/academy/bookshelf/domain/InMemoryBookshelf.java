package academy.bookshelf.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBookshelf implements Bookshelf {

    private List<Book> books = new ArrayList<>();

    public int add(Book book) {
        books.add(book);
        return books.size();
    }

    public void remove(Book book){
        books.remove(book);
    }

    public void remove(int id) {
        validateBookExists(id);
        books.remove(toZeroBasedIndex(id));
    }

    public List<Book> findAllBooks() {
        return books;
    }

    public void showEntireCollection(){
        for(Book book : books){
            displayAllInformationAbout(book);
        }
    }

    private void displayAllInformationAbout(Book book) {
        int indexOfBook = books.indexOf(book) + 1;
        System.out.println("Book " + indexOfBook + " is:");
        System.out.println(book.toString());
        System.out.println("<------------------>");
    }

    public void displayByGenre(String genre){
        System.out.println("The Books of " + genre + " are:");
        List<Book> relevantBooks = findBooksByGenre(genre);

        for (Book book : relevantBooks){
            System.out.println(book);
        }

        // Trendy way of doing the above code
        //books.forEach(book->displayBookOfGenre(genre, book));
    }

    public List<Book> findBooksByGenre(final String desiredGenre) {
        return books.stream()
                .filter(book->book.getGenre().equals(desiredGenre))
                .collect(Collectors.toList())
                ;
    }

    private void displayBookOfGenre(String genre, Book book) {
        if (book.getGenre().contains(genre)){
            System.out.println(book.toString());
            System.out.println("<------------------>");
        }
    }

    public boolean hasNoBooks(){
        return books.isEmpty();
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }

    public Book findBook(int id) {
        validateBookExists(id);
        return books.get(toZeroBasedIndex(id));
    }

    private void validateBookExists(int id) {
        if (books.size() < id){
            throw new BookNotFoundException(id);
        }
    }

    private int toZeroBasedIndex(int id) {
        return id - 1;
    }
}
