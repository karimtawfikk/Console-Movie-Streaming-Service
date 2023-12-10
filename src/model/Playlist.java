package model;

import java.util.List;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<String> favoriteFilms;
    private ArrayList<String> watchlaterFilms;
    private ArrayList<String> watchedFilms;
    private List<String> favoritePlaylist;
    private List<String> watchLaterplaylist;
    private List<String> watchedPlaylist;
    public static String[] recentMovies=new String[3];


    public Playlist(List<String> favoritePlaylist, List<String> watchLaterplaylist, List<String> watchedPlaylist) {
        this.favoritePlaylist = favoritePlaylist;
        this.watchLaterplaylist = watchLaterplaylist;
        this.watchedPlaylist = watchedPlaylist;
    }

    public void addToFav(String movie) {
        favoritePlaylist.add(movie);
    }

    public void RemoveFromToFav(String movie) {
        favoritePlaylist.remove(movie);
    }

    public void addToToBeWatched(String movie) {
        watchLaterplaylist.add(movie);
    }

    public void RemoveFromTobeWatched(String movie) {
        watchLaterplaylist.remove(movie);
    }

    public void addToWatched(String movie) {
        watchedPlaylist.add(movie);
    }

    public List<String> getFavoritePlaylist() {
        return favoritePlaylist;
    }

    public List<String> getWatchLaterplaylist() {
        return watchLaterplaylist;
    }

    public List<String> getWatchedPlaylist() {
        return watchedPlaylist;
    }

    @Override
    public String toString()
    {
        String favPl = String.join(":", getFavoritePlaylist());
        String wLPl = String.join(":", getWatchLaterplaylist());
        String wPl = String.join(":", getWatchedPlaylist());
        return favPl + ";" + wLPl + ";" + wPl;
    }
    public Playlist(ArrayList<String> favoriteFilms, ArrayList<String> watchlaterFilms, ArrayList<String> watchedFilms) {
        this.favoriteFilms = favoriteFilms;
        this.watchlaterFilms = watchlaterFilms;
        this.watchedFilms = watchedFilms;
    }

    public static void RecentWatchedMovies(String response){
        //law el array lesa msh malyan hahot gowah el response
        if(recentMovies.length!=3) {
            for (int i = 0; i < 4; i++) {
                recentMovies[i] = response;
            }
        }
//law etmala w galy response zeyada habadel awel movie bel gedeed
        else {
            recentMovies[0]=response;
            //by shift it to the left ashan tany mara mayshlsh el movie el recent awyy
            String firstElement = recentMovies[0];
            for (int i = 1; i < 3; i++) {
                recentMovies[i - 1] = recentMovies[i];
            }
            recentMovies[3 - 1] = firstElement;


        }

    }
    public static void displayRecentWatched(){
        for (int i = 1; i < 3; i++) {
            System.out.println(recentMovies[i]+'\n');

        }

    }

}