package model.user;

import java.util.List;

public class Regular extends User {
    String subscription;
    List<String> watchLater;
    List<String> watched;



    public Regular(int ID, String userName,String password, String firstName, String lastName, String email, String subscription, List<String> watchLater, List<String> watched) {
        super(ID,userName, password, firstName, lastName, email);
        this.subscription = subscription;
        this.watchLater = watchLater;
        this.watched = watched;
    }
}
