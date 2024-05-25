package model;


import java.util.List;

public class Director extends CastPerson {
    public Director(String fullName, int age, String gender, String nationality, List<String> list_of_movies) {
        super(fullName, age, gender, nationality, list_of_movies);
}
}