package model;

import java.util.List;

public class CastPerson {
    private final String fullName;
    private final int age;
    private final String gender;
    private final String nationality;
    private final List <String> list_of_movies;

    public CastPerson(String fullName, int age, String gender, String nationality, List<String> list_of_movies) {
        this.fullName=fullName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.list_of_movies = list_of_movies;
    }


    public String getFullName()
    {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public List<String> getList_of_movies() {
        return list_of_movies;
}

}
