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

    public void editMovies(List<Movie> movies, String movieTitle, int userInput, String userInputString) {
        for (Movie mov : movies) {
            if (mov.getMovieTitle().contains(movieTitle)) {
               switch (userInput){
                   case 1 -> {}
                   case 2 -> {}
                   case 3 -> mov.setDurationTime(LocalTime.parse(userInputString));
                   case 4 -> {}
                   case 5 -> {}
                   case 6 -> {}
                   case 7 -> {}

               }
            }
        }
    }
    public void addMoviesToFile(List<Movie> movies) {
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
                e.printStackTrace();
            }
        }
    }


}