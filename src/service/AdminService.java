package service;

import model.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.MOVIE_PATH;

public class AdminService {
    private static final List<Movie> newMoviesToBeAdded = new ArrayList<>();

    public void addMovie(List<Movie> movies, Movie movie) {
        movies.add(movie);
    }

    public void addMovies(ArrayList<Movie> movies, Movie movie) {
        newMoviesToBeAdded.add(movie);
    }

    public void editMovies(ArrayList<Movie> m, int movieId, LocalTime newDuration) {
        for (Movie mov : m) {
            if (mov.getMovieId() == movieId)
                mov.setDurationTime(newDuration);
        }
        editMovieInFile(movieId, newDuration);
    }

    private void editMovieInFile(int movieId, LocalTime newDuration) {
        //TODO
    }

    private void addMovieToFile(List<Movie> movies) {
        for (Movie movie : movies) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + MOVIE_PATH, true))) {
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
                e.printStackTrace();
            }
        }
    }


}