package model.user;

public class Regular extends User

{
    String[] subscription;
    String[]  watchlater;
    String[]  watched;

    public Regular(String[] subscription, String[] watchlater, String[] watched) {
        this.subscription = subscription;
        this.watchlater = watchlater;
        this.watched = watched;
    }
}
