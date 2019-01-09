package academy.bookshelf.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class BookTest
{

    private Book testBook = new Book("Kings of the Wyld", "Nicholas Eames", "Fiction", "Fantasy");

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void aBookWillHaveATitle(){
        String result = testBook.getTitle();
        matches(result, "Kings of the Wyld");
    }

    @Test
    public void aBookWillHaveAnAuthor(){
        String result = testBook.getAuthor();
        matches(result, "Nicholas Eames");
    }

    @Test
    public void aBookWillHaveAGenre(){
        String result = testBook.getGenre();
        matches(result, "Fiction");
    }

    @Test
    public void aBookWillHaveARating(){
        int result = testBook.getRating();
        isEqualTo(result, 0);
    }

    @Test
    public void theBooksRatingCanBeSetByTheUser(){
        testBook.setRating(5);
        int result = testBook.getRating();
        isEqualTo(result, 5);
    }

    @Test
    public void aBooksRatingCannotBeLowerThan1(){
        testBook.setRating(0);
        int result = testBook.getRating();
        isEqualTo(result,1);
    }

    @Test
    public void aBooksRatingCannotBeHigherThan5(){
        testBook.setRating(6);
        int result = testBook.getRating();
        isEqualTo(result,5);
    }

    @Test
    public void bookToStringShouldReturnTheTitleAuthorGenreAndRating(){

        testBook.setRating(5);
        String result = testBook.toString();
        matches(result, "Title: Kings of the Wyld\n" +
                "Author: Nicholas Eames\n" +
                "Genre: Fantasy Fiction\n" +
                "Rating: 5");
    }

    @Test
    public void aBookShouldHaveASubGenre(){
        String result = testBook.getSubGenre();
        matches(result, "Fantasy");
    }

    // Test Methods
    private void isEqualTo(int result, int expected) {
        assertThat(result).isEqualTo(expected);
    }

    private void matches(String result, String expected) {
        assertThat(result).matches(expected);
    }
}
