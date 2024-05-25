package model.user;

import model.Playlist;
import model.Subscriptions;
import model.WatchRecord;

public class Regular extends User
{
    private Playlist playLists;
    private WatchRecord watchrecord;
    private Subscriptions subscription;
    private int numberOfMoviesWatched;

    public Regular(String ID, String userName, String password, String firstName, String lastName, String email, Playlist playLists, WatchRecord watchrecord, Subscriptions subscription,int numberOfMoviesWatched)
    {
        super(ID, userName, password, firstName, lastName, email);
        this.numberOfMoviesWatched = numberOfMoviesWatched;
        this.playLists = playLists;
        this.watchrecord = watchrecord;
        this.subscription = subscription;
    }

    public void setNumberOfMoviesWatched(int numberOfMoviesWatched)
    {
        this.numberOfMoviesWatched = numberOfMoviesWatched;
    }

    public int getNumberOfMoviesWatched()
    {
        return numberOfMoviesWatched;
    }

    public Subscriptions getSubscription()
    {
        return subscription;
    }
    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }
    public WatchRecord getWatchrecord()
    {
        return watchrecord;
    }

    public void setWatchrecord(WatchRecord watchrecord) {
        this.watchrecord = watchrecord;
    }

    public Playlist getPlayLists()
    {
        return playLists;
    }
    public void setPlayLists(Playlist playLists)
    {
        this.playLists = playLists;
}

//    @Override
//    public void hello(int z) {
////        super.hello(5);
//        System.out.println("hey");
//    }


}
