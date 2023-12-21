package model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import model.user.Regular;


public class WatchRecord
{
//this entity has (User ID<, Movie>, Date of watching>
// the movie, Rating (from 1 to 5 , The user may not enter the rating to the movie)>).
//String wPl = String.join(":", getWatchedPlaylist()); ayzen nehot dii

    private List<MovieRecord> watchedPlaylist;
    public WatchRecord( List<MovieRecord> watchedPlaylist) {
        this.watchedPlaylist = watchedPlaylist;
    }

    public void addToWatched(String movieTite, LocalDate date, Float rating,int userId)
    {
        MovieRecord record=new MovieRecord(movieTite,date,rating,userId);
        watchedPlaylist.add(record);
    }
    public List<MovieRecord> getWatchedRecord()
    {
        return watchedPlaylist;
    }

    @Override
    public String toString()
    {
        String line;
        List <String>records=new ArrayList<>();
        for(MovieRecord record: getWatchedRecord())
        {
            line= record.getMovieName()+":"+ record.getWatchDate()+":"+record.getRating();
            records.add(line);
        }
        return String.join(";",records);
    }
}




