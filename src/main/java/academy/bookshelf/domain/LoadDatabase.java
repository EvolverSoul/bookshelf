package academy.bookshelf.domain;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository){
        return args -> {
          log.info("Preloading " + repository.save(new Book("firstBook", "person1", "fiction", "science")));
          log.info("Preloading " + repository.save(new Book("secondBook", "person2", "fiction", "science")));
        };
    }
}
