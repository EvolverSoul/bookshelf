package academy.bookshelf.rest;

import academy.bookshelf.domain.Book;
import academy.bookshelf.domain.BookNotFoundException;
import academy.bookshelf.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    //private Bookshelf bookshelf = new Bookshelf();

    private final BookRepository repository;
    @Autowired
    BooksController(BookRepository repository){
        this.repository = repository;
    }

    // Aggregate Root

    @GetMapping("/books")
    List<Book> all (){
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook){
        return repository.save(newBook);
    }

    // Single Item

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id){
        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return repository.save(book);
                })
                .orElseGet(()->{
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id){
        repository.deleteById(id);
    }



}
