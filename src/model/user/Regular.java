package model.user;
import model.Playlist;
import  model.Subscriptions;

public class Regular extends User {
    Subscriptions subscription;

  public  Playlist playLists;

    public Regular(int ID, String userName, String password, String firstName, String lastName, String email, Subscriptions subscription, Playlist lists) {
        super(ID, userName, password, firstName, lastName, email);
        this.subscription = subscription;
        this.playLists = lists;
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

    public void setPlayLists(Playlist playLists) {
        this.playLists = playLists;
    }
}
