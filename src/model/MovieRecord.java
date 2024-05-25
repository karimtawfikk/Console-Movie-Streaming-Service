package model;

import java.time.LocalDate;

public class MovieRecord {
    private final String userId;
    private final String movieName;
    private final LocalDate watchDate;
    private final Float Rating;
    public MovieRecord(String movieName, LocalDate watchDate, Float rating, String userId)
    {
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

    public String getUserId()
    {
        return userId;
}



}
