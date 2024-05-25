package service;

import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class RatingService
{
    public static List<Float> ratingOfWatchItMovies =new ArrayList<>();
    public static void setRatingOfWatchItMovies(List<Movie>movies)
    {
        for(int i=0; i< movies.size(); i++)
        {
            ratingOfWatchItMovies.add(movies.get(i).getImdb_score()); //index 0 = 8.2
        }
    }

    public static void CalculateRating(List<Movie>movies, String response, Float ratingOfUser)
    {
        int index = -1; //maslan baaet 1
        for (int i = 0; i < movies.size(); i++)  //3ashan ne3raf ehna shaghain ala anhy movie we ne3raf ne add fe anhy index beta3 List:ratingOfWatchItMovies
        {
            if (response.contains(movies.get(i).getMovieTitle()))
            {
                index = i;
                break;
            }
        }
        Float newRating=(ratingOfWatchItMovies.get(index)/10.0f)* ratingOfUser;
        ratingOfWatchItMovies.set(index,newRating);
}

}
