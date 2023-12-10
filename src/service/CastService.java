package service;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.*;

public class CastService {

    public static List<Actor> readActorsFromFile() {

        ArrayList<Actor> Actors = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + ACTORS_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                String actorFullName = values[0];
                int actorAge = Integer.parseInt(values[1]);
                String actorGender = values[2];
                String actorNationality = values[3];
                ArrayList<String> actorListOfMovies = new ArrayList<>(Arrays.asList(values[4].split(";")));
                Actor createdActor = new Actor(actorFullName, actorAge, actorGender, actorNationality, actorListOfMovies);
                Actors.add(createdActor);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return Actors;
    }


    public static List<Director> readDirectorFromFile() {

        ArrayList<Director> Directors = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + DIRECTORS_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                String directorFullName = values[0];
                int directorAge = Integer.parseInt(values[1]);
                String directorGender = values[2];
                String directorNationality = values[3];
                ArrayList<String> directorListOfMovies = new ArrayList<>(Arrays.asList(values[4].split(";")));


                Director createdDirector = new Director(directorFullName, directorAge, directorGender, directorNationality, directorListOfMovies);
                Directors.add(createdDirector);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return Directors;
    }

    public static void displayActorDetails(List<Actor> actor, int index)
    {
        Actor temporaryActor = actor.get(index);
        System.out.println("Actor Details:");
        System.out.println("Name: " + temporaryActor.getFullName());
        System.out.println("Age: " + temporaryActor.getAge());
        System.out.println("Gender: " + temporaryActor.getGender());
        System.out.println("Nationality: " + temporaryActor.getNationality());
        System.out.println("List of movies: " + temporaryActor.getList_of_movies());
    }
    public static void displayDirectorDetails(List<Director> director, int index)
    {

        Director temporaryDirector = director.get(index);
        System.out.println("Actor Details:");
        System.out.println("Name: " + temporaryDirector.getFullName());
        System.out.println("Age: " + temporaryDirector.getAge());
        System.out.println("Gender: " + temporaryDirector.getGender());
        System.out.println("Nationality: " + temporaryDirector.getNationality());
        System.out.println("List of movies: " + temporaryDirector.getList_of_movies());
}






}
