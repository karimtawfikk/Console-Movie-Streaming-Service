package model.user;

import java.util.List;

public class Regular extends User {
    String subscription;
    List<String> watchLater;
    List<String> watched;

    public Regular(String subscription, List<String> watchLater, List<String> watched) {
        this.subscription = subscription;
        this.watchLater = watchLater;
        this.watched = watched;
    }
}
