package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class WatchRecord {

    private int id;
    private List<MovieRecord> watchedPlaylist;

    public WatchRecord() {
    }

    public WatchRecord(int id, List<MovieRecord> watchedPlaylist) {
        this.id = id;
        this.watchedPlaylist = watchedPlaylist;
    }

    public int getUserId() {
        return id;
    }

    public void addToWatched(String movieTite, LocalDate date, Float rating, int userId) {
        if (watchedPlaylist == null) {
            watchedPlaylist = new ArrayList<>();
        }

        MovieRecord record = new MovieRecord(movieTite, date, rating, userId);
        watchedPlaylist.add(record);
    }

    public List<MovieRecord> getWatchedRecord() {
        return watchedPlaylist;
    }

    @Override
    public String toString() {


//       int userId = users.get(index).getID();
        List<String> recordStrings = new ArrayList<>();
        for (MovieRecord record : watchedPlaylist) {
            if(record.getUserId() == getUserId()) {
                String recordString = String.format("%s:%s:%s",
                        record.getMovieName(),
                        record.getWatchDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        record.getRating() == null ? " " : record.getRating().intValue());
                recordStrings.add(recordString);
            }

        }
        //todo mafrod


        return String.join(";", recordStrings);
    }
}




