package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class WatchRecord
{
    private int id;
    private List<MovieRecord> watchedPlaylist;
    public WatchRecord() {
    }
    public WatchRecord(int id, List<MovieRecord> watchedPlaylist)
    {
        this.id = id;
        this.watchedPlaylist = watchedPlaylist;
    }
    //todo hwa da l aly aamlo

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

        List<String> recordStrings = new ArrayList<>();
        for (MovieRecord record : watchedPlaylist)
        {
            if(record.getUserId() == id)
            {
                String recordString = String.format("%s:%s:%s",
                        record.getMovieName(),
                        record.getWatchDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        record.getRating() == null ? " " : record.getRating().intValue());
                recordStrings.add(recordString);
            }

        }
        return String.join(";", recordStrings);
    }
}