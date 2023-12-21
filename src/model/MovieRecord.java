package model;

import java.time.LocalDate;

public class MovieRecord {
    private int userId;
    private String movieName;
    private LocalDate watchDate;
    private Float Rating;

    public MovieRecord(String movieName, LocalDate watchDate, Float rating, int userId) {
        this.userId = userId;
        this.movieName = movieName;
        this.watchDate = watchDate;
        Rating = rating;
    }

    public Float getRating() {
        return Rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getWatchDate() {
        return watchDate;
    }

    public int getUserId() {
        return userId;
    }
}

