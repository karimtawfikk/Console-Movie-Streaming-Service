package model.user;

public class User
{

    int ID;

    String userName;
    String password;
    String firstName;
    String lastName;
    String email;

    public User(int ID,String userName, String password, String firstName, String lastName, String email) {
        this.ID = ID;
        this.userName=userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
