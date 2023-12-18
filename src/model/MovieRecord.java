package model;

import java.time.LocalDate;
public class MovieRecord {
    private String movieName;
    private LocalDate watchDate;
    private Float Rating;

    public MovieRecord(String movieName, LocalDate watchDate, Float rating) {
        this.movieName = movieName;
        this.watchDate = watchDate;
        Rating = rating;
    }

    public float getRating() {
        return Rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getWatchDate() {
        return watchDate;
    }


}

