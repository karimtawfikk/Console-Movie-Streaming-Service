package model;

import java.util.List;

public class Playlist {


    private List<String> favoritePlaylist;
    private List<String> watchLaterplaylist;
    private List<String> watchedPlaylist;

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
    public String toString() {

        String favPl = String.join(":", getFavoritePlaylist());
        String wLPl = String.join(":", getWatchLaterplaylist());
        String wPl = String.join(":", getWatchedPlaylist());
        return favPl + ";" + wLPl + ";" + wPl;
    }
}



