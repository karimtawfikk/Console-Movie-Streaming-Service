package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
public class Movie {

    int movieId;
    String movieTitle;
    LocalDate releaseDate;
    LocalTime durationTime;
    ArrayList<String> actors=new ArrayList<>();
    String director;
    ArrayList<String> genres=new ArrayList<>();



    String country;
    float budget;
    float revenue;
    float imdb_score;

    ArrayList<String> languages=new ArrayList<>();
    String poster;

    public Movie(){

    }

    public Movie(int movieId, String movieTitle, LocalDate releaseDate, LocalTime durationTime,ArrayList<String> actors, String director, ArrayList<String> genres, String country, float budget, float revenue, float imdb_score, ArrayList<String> languages, String poster) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.durationTime = durationTime;
        this.actors=actors;
        this.director = director;
        this.genres = genres;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        this.imdb_score = imdb_score;
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
        return director;
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

    public float getImdb_score() {
        return imdb_score;
    }


    public String getPoster() {
        return poster;
    }


    public ArrayList<String> getGenres() {
        return genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

}
