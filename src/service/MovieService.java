package service;
import model.Movie;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.MOVIE_PATH;

public class MovieService {

    public static List<Movie> readMoviesFromFile() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + MOVIE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line
                int movieId = Integer.parseInt(values[0]);
                String movieTitle = values[1];
                LocalDate releaseDate = LocalDate.parse(values[2]);
                LocalTime durationTime = LocalTime.parse(values[3]);
                ArrayList<String> actors = new ArrayList<>(Arrays.asList(values[4].split(";"))); // aslist bethawl men array le arraylist
                String director = values[5];
                ArrayList<String> genres = new ArrayList<>(Arrays.asList(values[6].split(";")));
                String country = values[7];
                float budget = Float.parseFloat(values[8]);
                float revenue = Float.parseFloat(values[9]);
                float imdbScore = Float.parseFloat(values[10]);
                ArrayList<String> languages = new ArrayList<>(Arrays.asList(values[11].split(";")));
                String poster = values[12];

                // Create a new Movie instance and add it to the list
                Movie movie = new Movie(movieId, movieTitle, releaseDate, durationTime, actors, director, genres, country,
                        budget, revenue, imdbScore, languages, poster);
                movies.add(movie); // kol loop hathot fe element gedid beta3 movies movie gedid
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return movies;
    }


    public static ArrayList<Movie> searchForMovieByGenre(List<Movie> movies,String genreValue){
        ArrayList<Movie> MoviesFound =new ArrayList<>();
        for(Movie movie: movies) {
            if(movie.hasGenre(genreValue))
                MoviesFound.add(movie);
        }
        return MoviesFound;
    }
    public static Movie searchForMovieByTitle(List<Movie> movies,String MovieName){
        for(Movie movie: movies) {
        if(movie.getMovieTitle().contains(MovieName))
            return movie;
        }
        return null;
    }
    public static void writeMoviesToFile(List<Movie> movies)
    {
        for (Movie movie : movies) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + MOVIE_PATH))) {
                // Append the new movie details to the file
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s,%.1f,%.1f,%.1f,%s,%s",
                        movie.getMovieId(),
                        movie.getMovieTitle(),
                        movie.getReleaseDate(),
                        movie.getDurationTime(),
                        String.join(";", movie.getActors()),
                        movie.getDirector(),
                        String.join(";", movie.getGenres()),
                        movie.getCountry(),
                        movie.getBudget(),
                        movie.getRevenue(),
                        movie.getImdb_score(),
                        String.join(";", movie.getLanguages()),
                        movie.getPoster()
                ));
                // Add a new line at the end
                writer.newLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }




}