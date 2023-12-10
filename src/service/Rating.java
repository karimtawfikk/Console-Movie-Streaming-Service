package service;

import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Rating
{
    static List<Float> ratingOfWatchitMovies=new ArrayList<>(); //awl elemnt yebaa shayel score beta3 awl film aandena


    public static void setRatingOfWatchitMovies(List<Movie>movies)
    {
        for(int i=0; i< movies.size(); i++)
        {
            ratingOfWatchitMovies.add(movies.get(i).getImdb_score());
        }
    }

    public static void setAndCalculateRating(List<Movie>movies, String response,int ratingOfUser)
    {
        int index = -1;
        for (int i = 0; i < movies.size(); i++)  //3ashan ne3raf ehna shaghain ala anhy movie we ne3raf ne add fe anhy index beta3 List:ratingOfWatchitMovies
        {
            if (response.contains(movies.get(i).getMovieTitle()))
            {
                index = i;
                break;
            }
        }
        Float newRating=(ratingOfWatchitMovies.get(index)/10.0f)* ratingOfUser;
        ratingOfWatchitMovies.set(index,newRating);
}




}
