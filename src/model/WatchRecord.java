package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class WatchRecord {
    private String id;
    private List<MovieRecord> watchedPlaylist;

    public WatchRecord(String id) {
        this.id = id;
    }

    public WatchRecord(String id, List<MovieRecord> watchedPlaylist) {
        this.id = id;
        this.watchedPlaylist = watchedPlaylist;
    }

    public void addToWatched(String movieTite, LocalDate date, Float rating, String userId) {
        if (watchedPlaylist == null) {
            watchedPlaylist = new ArrayList<>();
        }
        MovieRecord record = new MovieRecord(movieTite, date, rating, userId);
        watchedPlaylist.add(record);
    }

    public List<MovieRecord> getWatchedRecord() {
        return watchedPlaylist;
    }

    public void setWatchedRecord(List<MovieRecord> watchedPlaylist) {
        this.watchedPlaylist = watchedPlaylist;
    }

    @Override
    public String toString()
    {
        List<String> recordStrings = new ArrayList<>();
        for (MovieRecord record : watchedPlaylist)
        {
            if (record.getUserId().equals(id))
            {
                String recordString = String.format("%s:%s:%s",
                        record.getMovieName()==null ? " :": record.getMovieName(),
                        record.getWatchDate()==null? " :":
                                record.getWatchDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        record.getRating() == null ? " " : record.getRating().intValue());
                recordStrings.add(recordString);
            }
        }
        if(recordStrings.isEmpty())
        {
            return " ";
        }else {
            return String.join(";", recordStrings);
 }
}
}
