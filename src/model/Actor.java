package model;


import java.util.List;

public class Actor extends CastPerson
{
    public Actor(String fullName, int age, String gender, String nationality, List<String> list_of_movies)
    {
        super(fullName, age, gender, nationality, list_of_movies);
    }


}