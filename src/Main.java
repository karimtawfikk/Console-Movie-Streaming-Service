import model.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        Movie[] movies = new Movie[3];
        try (BufferedReader reader = new BufferedReader(
                new FileReader("Data" + File.separator + "Movie.txt"))
        ) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < 3) {

                String[] parts = line.split(",");
                movies[i] = new Movie(
                        Integer.parseInt(parts[0]),//id
                        parts[1],//movieTitle
                        LocalDate.parse(parts[2]),//releaseDate
                        LocalTime.parse(parts[3]),//durationTime
                        parts[4],//director
                        parts[5].split(";"),//genre
                        parts[6],//country
                        Float.parseFloat(parts[7]),//budget
                        Float.parseFloat(parts[8]),//revenue
                        Float.parseFloat(parts[9]),//IMDBScore
                        parts[10].split(";"),//languages
                        parts[11]//poster
                );
                i++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (Movie movie : movies) {

            System.out.println(movie.getMovieTitle());
        }

    }

}