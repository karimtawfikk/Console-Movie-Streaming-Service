package model;

import java.util.ArrayList;
import java.util.List;

import static service.RatingService.ratingOfWatchItMovies;

public class Playlist {
    public static String[] topRatedMovies = new String[3];
    public String[] recentMovies = new String[3];
    //todo recentmovies we watched nehotaha f watchrecord
    public static String[] topWatchedMovies = new String[3];
    public static List<Integer>counterOfWatchedMovie=new ArrayList<>();
    private List<String> favoritePlaylist;
    private List<String> watchLaterplaylist;
    //    private List<String> watchedPlaylist;
    public Playlist(List<String> favoritePlaylist, List<String> watchLaterplaylist) {
        this.favoritePlaylist = favoritePlaylist;
        this.watchLaterplaylist = watchLaterplaylist;

    }

    public static void getAndAddTopRatedMovies(List<Movie> movies) //todo nesheel l rating negbeeeb index bs njgntribnt4ih
    {
        float firstMax = Float.MIN_VALUE;
        float secondMax = Float.MIN_VALUE;
        float thirdMax = Float.MIN_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;
        int thirdIndex = -1;

        for (int i = 0; i < ratingOfWatchItMovies.size(); i++) {
            float currentFloat = ratingOfWatchItMovies.get(i);
            if (currentFloat > firstMax) {
                thirdMax = secondMax;
                thirdIndex = secondIndex;

                secondMax = firstMax;
                secondIndex = firstIndex;

                firstMax = currentFloat;
                firstIndex = i;
            } else if (currentFloat > secondMax)
            {
                thirdMax = secondMax;
                thirdIndex = secondIndex;
                secondMax = currentFloat;
                secondIndex = i;
            } else if (currentFloat > thirdMax) {
                thirdMax = currentFloat;
                thirdIndex = i;
            }
        }
        topRatedMovies[0]=movies.get(firstIndex).getMovieTitle();
        topRatedMovies[1]=movies.get(secondIndex).getMovieTitle();
        topRatedMovies[2]=movies.get(thirdIndex).getMovieTitle();
    }
    public void addToFavorite(String movieTitle) {
        favoritePlaylist.add(movieTitle);
    }

    public void addToToBeWatched(String movieTitle)
    {
        watchLaterplaylist.add(movieTitle);
    }



    public List<String> getFavoritePlaylist() {
        return favoritePlaylist;
    }

    public List<String> getWatchLaterplaylist() {
        return watchLaterplaylist;
    }

    public String[] getRecentMovies() {
        return recentMovies;
    }

    public void getAndAddRecentWatchedMovies(String movieName) {
        // Check if the movie is already in the recentMovies array
        //
        boolean movieAlreadyAdded = false;
      for(int i=0; i<3; i++){
       if(recentMovies[i]==null)
       {
           recentMovies[i]=movieName;
           movieAlreadyAdded=true;
           break;
       }
      }
        // If the movie is not already in the list, add it
        if (!movieAlreadyAdded)
        {
            for (int i = 0; i < 2; i++)
            {
                if (recentMovies[i + 1] != null) {
                    recentMovies[i] = recentMovies[i + 1];
                }
            }
            recentMovies[2] = movieName;
        }
    }


    public static void setTopWatchedMovies(List<Movie> movies)
    {
        for(int i=0; i< movies.size(); i++)
        {
            counterOfWatchedMovie.add(0);
        }

    }
    //todo control y betal3k odam
    public static void getAndAddTopWatchedMovies(int index, List<Movie> movies) {
        int currentCounter = counterOfWatchedMovie.get(index);
        currentCounter++;
        counterOfWatchedMovie.set(index, currentCounter);

        int max1 = 0;
        int max2 = 0;
        int max3 = 0;

        for (int i = 0; i < counterOfWatchedMovie.size(); i++) {
            if (counterOfWatchedMovie.get(i) > counterOfWatchedMovie.get(max1)) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (counterOfWatchedMovie.get(i) > counterOfWatchedMovie.get(max2)) {
                max3 = max2;
                max2 = i;
            } else if (counterOfWatchedMovie.get(i) > counterOfWatchedMovie.get(max3)) {
                max3 = i;
            }
        }

        if (counterOfWatchedMovie.get(max1) != 0) {
            topWatchedMovies[0] = movies.get(max1).getMovieTitle();
        }
        if (counterOfWatchedMovie.get(max2) != 0) {
            topWatchedMovies[1] = movies.get(max2).getMovieTitle();
        }
        if (counterOfWatchedMovie.get(max3) != 0) {
            topWatchedMovies[2] = movies.get(max3).getMovieTitle();
        }
    }




    @Override
    public String toString()
    {
        String favPl = String.join(":", getFavoritePlaylist());
        String wLPl = String.join(":", getWatchLaterplaylist());
        return favPl + ";" + wLPl ;
    }


}
//        ratingOfWatchItMovies.sort(Comparator.reverseOrder());
//        List<Float> biggestThreeRatings = new ArrayList<>();
//
//        biggestThreeRatings.add(ratingOfWatchItMovies.get(0));
//        biggestThreeRatings.add(ratingOfWatchItMovies.get(1));
//        biggestThreeRatings.add(ratingOfWatchItMovies.get(2));
////        ratingOfWatchItMovies.subList(0,3);
//        int j = 0;
//        for (int i = 0; i < 3; i++)
//        {
//           for(int k=0; k<3; k++)
//           {
//               if (biggestThreeRatings.get(i) == ratingOfWatchItMovies.get(k))
//               {
//                   topRatedMovies[j] = movies.get(k).getMovieTitle();
//               }
//
//           }
//            j++;
//        }
