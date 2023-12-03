package service;

import model.Movie;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MovieService {


    public static ArrayList<Movie> readMoviesFromFile(String filePath)
    {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath)))
        {
            while (scanner.hasNextLine() ) {

                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line

                int movieId = Integer.parseInt(values[0]);
                String movieTitle = values[1];
                LocalDate releaseDate = LocalDate.parse(values[2]);
                LocalTime durationTime = LocalTime.parse(values[3]);
                ArrayList<String> actors = new ArrayList<>(Arrays.asList(values[4].split(";")));
                String director = values[5];
                ArrayList<String> genres = new ArrayList<>(Arrays.asList(values[6].split(";")));
                String country = values[7];
                float budget = Float.parseFloat(values[8]);
                float revenue = Float.parseFloat(values[9]);
                float imdbScore = Float.parseFloat(values[10]);
                ArrayList<String> languages = new ArrayList<>(Arrays.asList(values[11].split(";")));
                String poster = values[12];

                // Create a new Movie instance and add it to the list
                Movie movie = new Movie(movieId, movieTitle, releaseDate, durationTime,  actors, director, genres, country,
                        budget, revenue, imdbScore, languages, poster);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {

            System.err.println(e.getMessage());
        }

        return movies;
    }



}