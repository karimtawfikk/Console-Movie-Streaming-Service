package model;

import java.util.ArrayList;
import java.util.List;

import static service.RatingService.ratingOfWatchItMovies;

public class Playlist {

    private static final String[] topRatedMovies = new String[3];
    private static final String[] topWatchedMovies = new String[3];
    private static final List<Integer> counterOfWatchedMovie = new ArrayList<>();
    private final String[] recentMovies = new String[3];
    private List<String> favoritePlaylist;
    private List<String> watchLaterplaylist;

    public Playlist()
    {
    }

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
        for (int i = 0; i < movies.size(); i++)
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

    public void addToFavorite(String movieTitle) {
        if (favoritePlaylist == null) //ma3naha law el logged in user la 3amel register
        {
            favoritePlaylist = new ArrayList<>(); // Initialize the list if it's null
        }
        boolean isFound = false;
        for (String checkMovie : favoritePlaylist) {
            if (movieTitle.equalsIgnoreCase(checkMovie)) {
                isFound = true;
                break;
            }
        }
        if (!isFound) favoritePlaylist.add(movieTitle);
    }

    public void addToToBeWatched(String movieTitle) {
        if (watchLaterplaylist == null) {
            watchLaterplaylist = new ArrayList<>(); // Initialize the list if it's null
        }
        boolean isFound = false;
        for (String checkMovie : watchLaterplaylist) {
            if (movieTitle.equalsIgnoreCase(checkMovie)) {
                isFound = true;
                break;
            }
        }
        if (!isFound) watchLaterplaylist.add(movieTitle);
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
        boolean movieAlreadyAdded = false;
        boolean isFound = false;
        for (int i = 0; i < 3; i++) {
            if (recentMovies[i]==movieName) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            for (int i = 0; i < 3; i++) {
                if (recentMovies[i] == null)
                {
                    recentMovies[i] = movieName;
                    movieAlreadyAdded = true;
                    break;
                }
            }

            if (!movieAlreadyAdded) {
                for (int i = 0; i < 2; i++) {
                    if (recentMovies[i + 1] != null)
                    {
                        recentMovies[i] = recentMovies[i + 1];
                    }
                }
                recentMovies[2] = movieName;
            }
        }
    }

    public static String[] getTopRatedMovies() {
        return topRatedMovies;
    }

    public static String[] getTopWatchedMovies() {
        return topWatchedMovies;
    }

    @Override
    public String toString()
    {
        String favPl = getFavoritePlaylist() == null ?
                " "
                :
                String.join(":", getFavoritePlaylist());

        String wLPl = getWatchLaterplaylist() == null ?
                " "
                :
                String.join(":", getWatchLaterplaylist());

        return favPl + ";"+wLPl;
}


}
