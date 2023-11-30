import java.time.LocalDate;
import java.time.LocalTime;
public class Movie {
    int movieId;
    String movieTitle;
    LocalDate releaseDate;
    LocalTime durationTime;
    String Director;

    // Actor[] actors;
    String [] genre = new String [3];
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
}
