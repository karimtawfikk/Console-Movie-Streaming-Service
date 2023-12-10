package model;

import java.util.List;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {

    private List<String> favoritePlaylist;
    private List<String> watchLaterplaylist;
    private List<String> watchedPlaylist;
    public static String[] recentMovies=new String[3];

    public Playlist(List<String> favoritePlaylist, List<String> watchLaterplaylist, List<String> watchedPlaylist)
    {
        this.favoritePlaylist = favoritePlaylist;
        this.watchLaterplaylist = watchLaterplaylist;
        this.watchedPlaylist = watchedPlaylist;
    }

    public void addToFavorite(String movieTitle)
    {
        favoritePlaylist.add(movieTitle);
    }
    public void addToToBeWatched(String movieTitle)
    {
        watchLaterplaylist.add(movieTitle);
    }
    public void addToWatched(String movieTitle)
    {
        watchedPlaylist.add(movieTitle);
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


    public static void RecentWatchedMovies(String response){
        //law el array lesa msh malyan hahot gowah el response
        if(recentMovies.length!=3)
        {
            for (int i = 0; i < 3; i++) {
                if(recentMovies[i]!=null) {
                    recentMovies[i] = response;
                }
            }
        }
//law etmala w galy response zeyada habadel awel movie bel gedeed
        else {
            //by shift it to the left ashan tany mara mayshlsh el movie el recent awyyString firstElement = recentMovies[0];
            for (int i = 0; i < 3; i++) {
                recentMovies[i] = recentMovies[i+1];
            }
            recentMovies[2]=response;
        }

}




}