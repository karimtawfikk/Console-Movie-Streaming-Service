package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<String> favplaylist;
    private List<String> WatchLaterplaylist;
    private List<String> watchedplaylist;

    public Playlist(List<String> favplaylist, List<String> watchLaterplaylist, List<String> watchedplaylist) {
        this.favplaylist = favplaylist;
        WatchLaterplaylist = watchLaterplaylist;
        this.watchedplaylist = watchedplaylist;
    }


    public void addToFav(String movie) {
        favplaylist.add(movie);
    }

    public void RemoveFromToFav(String movie) {
        favplaylist.remove(movie);
    }

    public void addToToBeWatched(String movie) {
        WatchLaterplaylist.add(movie);
    }

    public void RemoveFromTobeWatched(String movie) {
        WatchLaterplaylist.remove(movie);
    }

    public void addToWatched(String movie) {
        watchedplaylist.add(movie);
    }

    public List<String> getFavplaylist() {
        return favplaylist;
    }

    public List<String> getWatchLaterplaylist() {
        return WatchLaterplaylist;
    }

    public List<String> getWatchedplaylist() {
        return watchedplaylist;
    }
}







