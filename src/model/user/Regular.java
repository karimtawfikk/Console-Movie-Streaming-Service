package model.user;
import  model.Subscriptions;
import java.util.List;

public class Regular extends User {
    Subscriptions subscription;
    List<String> watchLater;
    List<String> watched;


    public Regular(int ID, String userName, String password, String firstName, String lastName, String email, Subscriptions subscription, List<String> watchLater, List<String> watched) {
        super(ID, userName, password, firstName, lastName, email);
        this.subscription = subscription;
        this.watchLater = watchLater;
        this.watched = watched;

    }

    public Regular(int ID, String userName, String password, String firstName, String lastName, String email) {
        super(ID, userName, password, firstName, lastName, email);
    }

    public Subscriptions getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }

    public List<String> getWatchLater() {
        return watchLater;
    }

    public void setWatchLater(List<String> watchLater) {
        this.watchLater = watchLater;
    }

    public List<String> getWatched() {
        return watched;
    }

    public void setWatched(List<String> watched) {
        this.watched = watched;
    }
}
