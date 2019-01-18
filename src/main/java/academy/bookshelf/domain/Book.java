package academy.bookshelf.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Book {

    private String title;
    private String author;
    private String genre;
    private String subGenre;
    private int rating;

    private @Id @GeneratedValue Long id;

    public Book(){
        // No action
    }
    public Book(String title, String author, String genre, String subGenre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
    }

    // Getters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public String getSubGenre(){ return  subGenre; }

    public int getRating(){
        return rating;
    }

    // Setters
    public void setRating(int rating) {
        if (rating < 1) { this.rating = 1; }
        else if (rating > 5) { this.rating = 5; }
        else { this.rating = rating; }
    }

    @Override
    public String toString(){
        return "Title: " + this.title + "\n" +
                "Author: " + this.author + "\n" +
                "Genre: " + this.subGenre + " " + this.genre + "\n" +
                "Rating: " + this.rating;
    }
}
