package model;

import java.util.List;

public class CastPerson {
   String fullName;
    int age;
    String gender;
    String nationality;
    List <String> list_of_movies;




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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setList_of_movies(List<String> list_of_movies) {
        this.list_of_movies = list_of_movies;
    }
}
