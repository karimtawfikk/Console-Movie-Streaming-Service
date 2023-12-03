import model.Movie;
import service.MovieService;

import java.util.ArrayList;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.MOVIE_PATH;

public class Main {

    public static void main(String[] args){

       ArrayList<Movie>movie= MovieService.readMoviesFromFile(DATA_DIRECTORY + MOVIE_PATH);
//movie hya el arraylist elhanb2a shaghleen aaleha dayman we han assign it bl arraylist el temporary eli kona benkhazn fi el info bs(movies)
    }
}