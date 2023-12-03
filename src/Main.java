import model.Movie;
import service.AdminService;
import service.MovieService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final AdminService adminService = new AdminService();

    public static void main(String[] args) {

        List<Movie> movies = MovieService.readMoviesFromFile();

        // if(admin wants to add)//TODO
        addMovie(movies);

        adminService.addMoviesToFile(movies);
    }

    private static void addMovie(List<Movie> movies) {
        Movie movie = null;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the details of the movie:");

            System.out.println("MovieId:");
            int movieId = input.nextInt();
            input.nextLine(); // 3ashan threw error bsabb nextint()

            System.out.println("Movie name:");
            String movieName = input.nextLine();

            System.out.println("Date of release(yyyy-mm-dd):");
            String movieDateString = input.nextLine();
            LocalDate releaseDate = LocalDate.parse(movieDateString);

            System.out.println("Movie Duration:");
            LocalTime durationTime = LocalTime.parse(input.nextLine());

            System.out.println("Movie Actors (Write 'done' when finished):");
            ArrayList<String> actors = new ArrayList<>();
            while (true) {
                String actorName = input.nextLine();
                if (actorName.equalsIgnoreCase("done")) {
                    break;
                }
                actors.add(actorName);
            }

            System.out.println("Movie Director:");
            String director = input.nextLine();

            System.out.println("Movie Genres (Write 'done' when finished):");
            ArrayList<String> genres = new ArrayList<>();
            while (true)
            {
                String genre = input.nextLine();
                if (genre.equalsIgnoreCase("done")) {
                    break;
                }
                genres.add(genre);
            }

            System.out.println("Origin country:");
            String country = input.nextLine();

            System.out.println("Movie Budget:");
            float budget = input.nextFloat();

            System.out.println("Movie Revenue:");
            float revenue = input.nextFloat();

            System.out.println("Movie IMDb_Score:");
            float imdbScore = input.nextFloat();

            input.nextLine(); // Consume the newline character

            System.out.println("Movie Languages (Write 'done' when finished):");
            ArrayList<String> languages = new ArrayList<>();
            while (true) {
                String language = input.nextLine();
                if (language.equalsIgnoreCase("done")) {
                    break;
                }
                languages.add(language);
            }

            System.out.println("Movie poster:");
            String poster = input.nextLine();

            movie = new Movie(movieId, movieName, releaseDate, durationTime, actors, director, genres, country, budget, revenue, imdbScore, languages, poster);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (movie != null)
            movies.add(movie);
    }

}