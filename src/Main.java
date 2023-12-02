import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import model.*;
import service.*;

public class Main {      //Movie reader
    public static List<Movie> readMoviesFromFile(String filePath)
    {

        List<Movie> movies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath)))
        {
            while (scanner.hasNextLine() ) {

                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line
                if (values.length >= 12) {
                    int movieId = Integer.parseInt(values[0]);
                    String movieTitle = values[1];
                    LocalDate releaseDate = LocalDate.parse(values[2]);
                    LocalTime durationTime = LocalTime.parse(values[3]);
                    String director = values[4];
                    String[] genre = values[5].split(";");
                    String country = values[6];
                    float budget = Float.parseFloat(values[7]);
                    float revenue = Float.parseFloat(values[8]);
                    float imdbScore = Float.parseFloat(values[9]);
                    String[] languages = values[10].split(";");
                    String poster = values[11];

                    // Create a new Movie instance and add it to the list
                    Movie movie = new Movie(movieId, movieTitle, releaseDate, durationTime, director, genre, country,
                            budget, revenue, imdbScore, languages, poster);
                    movies.add(movie);
                }
            }
        } catch (FileNotFoundException e) {

            System.err.println(e.getMessage());
        }

        return movies;
    }

    public static void main(String[] args) throws NumberFormatException {
        List<Movie> movies = readMoviesFromFile("Data" + File.separator + "Movie.txt" );

        // Print the details of each movie
        for (Movie movie : movies) {

         System.out.println("Movie ID: " + movie.getMovieId());
            System.out.println("Movie Title: " + movie.getMovieTitle());
            System.out.println("Release Date: " + movie.getReleaseDate());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Genre: " + String.join(", ", movie.getGenre()));
            System.out.println("Country: " + movie.getCountry());
            System.out.println("Budget: " + movie.getBudget());
            System.out.println("Revenue: " + movie.getRevenue());
            System.out.println("IMDB Score: " + movie.getImbd_score());
            System.out.println("Languages: " + String.join(", ", movie.getLanguages()));
            System.out.println("Poster: " + movie.getPoster());
            System.out.println();

        }
}}