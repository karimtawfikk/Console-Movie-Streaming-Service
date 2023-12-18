package model;

import java.util.ArrayList;
import java.util.List;

import static service.RatingService.ratingOfWatchItMovies;

public class Playlist {
    public static String[] topRatedMovies = new String[3];
    //todo recentmovies we watched nehotaha f watchrecord
    public static String[] topWatchedMovies = new String[3];
    public static List<Integer> counterOfWatchedMovie = new ArrayList<>();
    public String[] recentMovies = new String[3];
    private List<String> favoritePlaylist;
    private List<String> watchLaterPlaylist;
    private List<String> watchedPlaylist;

    public Playlist(List<String> favoritePlaylist, List<String> watchLaterPlaylist, List<String> watchedPlaylist)
    {
        this.favoritePlaylist = favoritePlaylist;
        this.watchLaterPlaylist = watchLaterPlaylist;
        this.watchedPlaylist = watchedPlaylist;
    }

    public static void getAndAddTopRatedMovies(List<Movie> movies)
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
            } else if (currentFloat > secondMax) {
                thirdMax = secondMax;
                thirdIndex = secondIndex;
                secondMax = currentFloat;
                secondIndex = i;
            } else if (currentFloat > thirdMax) {
                thirdMax = currentFloat;
                thirdIndex = i;
            }
        }
        topRatedMovies[0] = movies.get(firstIndex).getMovieTitle();
        topRatedMovies[1] = movies.get(secondIndex).getMovieTitle();
        topRatedMovies[2] = movies.get(thirdIndex).getMovieTitle();
    }

    public static void setTopWatchedMovies(List<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            counterOfWatchedMovie.add(0);
        }
    }
    public static void getAndAddTopWatchedMovies(int index, List<Movie> movies) {
        int currentCounter = counterOfWatchedMovie.get(index);
        currentCounter++;
        counterOfWatchedMovie.set(index, currentCounter);
        int max1 = counterOfWatchedMovie.get(0);
        int max2 = -1;
        int max3 = -1;
        for (int i = 1; i < counterOfWatchedMovie.size(); i++) {
            if (counterOfWatchedMovie.get(i) > max1) {
                max3 = max2;
                max2 = max1;
                max1 = counterOfWatchedMovie.get(i);
            } else if (counterOfWatchedMovie.get(i) > max2) {
                max3 = max2;
                max2 = counterOfWatchedMovie.get(i);
            } else if (counterOfWatchedMovie.get(i) > max3) {
                max3 = counterOfWatchedMovie.get(i);
            }
        }
        topWatchedMovies[0] = movies.get(max1).getMovieTitle();
        topWatchedMovies[1] = movies.get(max2).getMovieTitle();
        topWatchedMovies[2] = movies.get(max3).getMovieTitle();

    }

    public void addToFavorite(String movieTitle) {
        favoritePlaylist.add(movieTitle);
    }

    public void addToToBeWatched(String movieTitle) {
        watchLaterPlaylist.add(movieTitle);
    }

    public void addToWatched(String movieTitle) {
        watchedPlaylist.add(movieTitle);
    }

    public List<String> getFavoritePlaylist() {
        return favoritePlaylist;
    }

    public List<String> getWatchLaterplaylist()
    {
        return watchLaterPlaylist;
    }

    public List<String> getWatchedPlaylist() {
        return watchedPlaylist;
    }

    public String[] getRecentMovies() {
        return recentMovies;
    }

    public void getAndAddRecentWatchedMovies(String movieName)
    {
        boolean movieAlreadyAdded=false;
            for (int i = 0; i < 3; i++)
            {
                if (recentMovies[i] == null)
                {
                    recentMovies[i] = movieName;
                    break;
                }
            }
        for (String recentMovie : recentMovies) {
            if (movieName.equals(recentMovie)) {
                movieAlreadyAdded = true;
                break;
            }
        }
        if (!movieAlreadyAdded) {
            for (int i = 0; i < 2; i++) {
                if (recentMovies[i + 1] != null) {
                    recentMovies[i] = recentMovies[i + 1];
                }
            }
            recentMovies[2] = movieName;
        }
    }
    @Override
    public String toString() {
        String favPl = String.join(":", getFavoritePlaylist());
        String wLPl = String.join(":", getWatchLaterplaylist());
        String wPl = String.join(":", getWatchedPlaylist());
        return favPl + ";" + wLPl + ";" + wPl;
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
//        }