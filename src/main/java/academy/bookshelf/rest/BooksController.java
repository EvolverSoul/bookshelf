package academy.bookshelf.rest;

import academy.bookshelf.domain.Book;
import academy.bookshelf.domain.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    private Bookshelf bookshelf;


    @Autowired
    public BooksController(Bookshelf bookshelf){
        this.bookshelf = bookshelf;
    }

    // Aggregate Root

    @GetMapping("/books")
    public List<Book> all (){
        return bookshelf.findAllBooks();
    }

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/books")
    public String newBook(@RequestBody Book newBook){
        int bookId = bookshelf.add(newBook);
        return "/books/" + bookId;
    }

    // Single Item

    @GetMapping("/books/{id}")
    public Book one(@PathVariable int id){
        return bookshelf.findBook(id);
    }

//    @PutMapping("/books/{id}")
//    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id){
//        return repository.findById(id)
//                .map(book -> {
//                    book.setTitle(newBook.getTitle());
//                    book.setAuthor(newBook.getAuthor());
//                    return repository.save(book);
//                })
//                .orElseGet(()->{
//                    newBook.setId(id);
//                    return repository.save(newBook);
//                });
//    }
//
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookshelf.remove(id);
    }



}
