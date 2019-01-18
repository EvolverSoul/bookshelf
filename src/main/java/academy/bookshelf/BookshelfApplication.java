package academy.bookshelf;

import academy.bookshelf.domain.BookRepository;
import academy.bookshelf.rest.BooksController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = BookRepository.class)
public class BookshelfApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookshelfApplication.class, args);
    }
}
