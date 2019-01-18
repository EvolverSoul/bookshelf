package academy.bookshelf.rest;

import academy.bookshelf.domain.Book;
import academy.bookshelf.domain.Bookshelf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Bookshelf bookshelf;

    @Test
    public void testExample() throws Exception {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("book4", "someguy", "fiction", "fantasy"));

        given(bookshelf.findAllBooks())
                .willReturn(expectedBooks);
        this.mvc.perform(get("/books").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // write a second expect() later to find the content of the book
    }

}