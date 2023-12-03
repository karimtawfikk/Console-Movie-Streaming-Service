import model.Movie;
import service.MovieService;

import java.util.ArrayList;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.MOVIE_PATH;

public class Main {

    public static void main(String[] args){

       ArrayList<Movie>movie= MovieService.readMoviesFromFile(DATA_DIRECTORY + MOVIE_PATH);
//
    }
}