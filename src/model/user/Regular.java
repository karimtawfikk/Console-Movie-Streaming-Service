package model.user;

import model.Playlist;
import model.Subscriptions;
import model.WatchRecord;

public class Regular extends User
{
    public Playlist playLists;
    public WatchRecord watchrecord;
    Subscriptions subscription;
    int movieCounter;

    public Regular(int ID, String userName, String password, String firstName, String lastName, String email, Playlist playLists, WatchRecord watchrecord, Subscriptions subscription,int movieCounter)
    {
        super(ID, userName, password, firstName, lastName, email);
        this.movieCounter=movieCounter;
        this.playLists = playLists;
        this.watchrecord = watchrecord;
        this.subscription = subscription;
    }

    public void setMovieCounter(int movieCounter) {
        this.movieCounter = movieCounter;
    }

    public int getMovieCounter()
    {
        return movieCounter;
    }

    public Subscriptions getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }

    public Playlist getPlayLists()
    {
        return playLists;
    }
    public void setPlayLists(Playlist playLists)
    {
        this.playLists = playLists;
    }


}
