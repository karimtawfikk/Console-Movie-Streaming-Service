package model;

import java.time.LocalDate;
import java.time.LocalTime;
public class Movie {
    int movieId;
    String movieTitle;
    LocalDate releaseDate;
    LocalTime durationTime;
    String Director;

    // Actor[] actors;
    String [] genre = new String [5];
    String country;
    float budget;
    float revenue;
    float imbd_score;

    String [] languages;
    String poster;

    public Movie(){

    }

    public Movie(int movieId, String movieTitle, LocalDate releaseDate, LocalTime durationTime, String director, String[] genre, String country, float budget, float revenue, float imbd_score, String[] languages, String poster) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.durationTime = durationTime;
        Director = director;
        this.genre = genre;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        this.imbd_score = imbd_score;
        this.languages = languages;
        this.poster = poster;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public LocalTime getDurationTime() {
        return durationTime;
    }

    public String getDirector() {
        return Director;
    }

    public String[] getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public float getBudget() {
        return budget;
    }

    public float getRevenue() {
        return revenue;
    }

    public float getImbd_score() {
        return imbd_score;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String getPoster() {
        return poster;
    }

}
