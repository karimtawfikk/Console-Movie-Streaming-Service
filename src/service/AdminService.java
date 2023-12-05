package service;

import model.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.MOVIE_PATH;

public class AdminService {
    static Scanner input = new Scanner(System.in);

    private static ArrayList<String> getActorsFromUser() {

        System.out.println("Enter the new list of actors (separate each actor with a semicolon):");
        String actorsInput = input.nextLine();

        //  Arrays.asList to convert the array returned by split to a List
        return new ArrayList<>(Arrays.asList(actorsInput.split(";")));
    }

    private static ArrayList<String> getGenresFromUser() {

        System.out.println("Enter the new list of genres (separate each actor with a semicolon):");
        String genresInput = input.nextLine();

        //  Arrays.asList to convert the array returned by split to a List
        return new ArrayList<>(Arrays.asList(genresInput.split(";")));
    }

    private static ArrayList<String> getLanguagesFromUser() {

        System.out.println("Enter the new list of languages (separate each actor with a semicolon):");
        String languagesInput = input.nextLine();

        //  Arrays.asList to convert the array returned by split to a List
        return new ArrayList<>(Arrays.asList(languagesInput.split(";")));
    }

    public void editMovies(List<Movie> movies, String movieTitle, int userInput) {
        //how to make sure in el movie da mawgood aandna

        for (Movie mov : movies) {
            if (mov.getMovieTitle().contains(movieTitle)) {
                switch (userInput) {
                    case 1:
                        System.out.println("Enter updated time duration:");
                        String newTime = input.nextLine();
                        mov.setDurationTime(LocalTime.parse(newTime));
                        break;
                    case 2:
                        System.out.println("Enter updated Date(yyyy-mm-dd):");
                        String newDate = input.nextLine();
                        mov.setReleaseDate(LocalDate.parse(newDate));
                        break;
                    case 3: //edit an actor
                        System.out.println("Press:\n 1: To add an actor \n 2:To remove an actor \n 3:Change the whole list ");
                        int respone = input.nextInt();

                        if (respone == 1) {
                            System.out.println("Enter new actor name:");
                            String newActor = input.nextLine();
                            mov.getActors().add(newActor);
                        }
                        if (respone == 2) {
                            System.out.println("Enter the actor desired to be deleted:");
                            String actorToBeDeleted = input.nextLine();
                            int index = -1;
                            for (int i = 0; i < mov.getActors().size(); i++) {
                                if (mov.getActors().get(i).equalsIgnoreCase(actorToBeDeleted)) {
                                    index = i;
                                    break;
                                }
                            }
                            if (index >= 0) {
                                mov.getActors().remove(index);
                                System.out.println("Actor removed successfully.");
                            } else {
                                System.out.println("Actor not found in the list.");
                            }

                        }
                        if (respone == 3) {
                            mov.setActors(getActorsFromUser());
                        }
                        break;
                    case 4:
                        System.out.println("Enter the new director:");
                        String newDirector = input.nextLine();
                        mov.setDirector(newDirector);
                        break;
                    case 5:
                        System.out.println("Press:\n 1: To add a genre \n 2:To remove a genre \n 3:Change the entire list of genres ");
                        int choice = input.nextInt();

                        if (choice == 1) {
                            System.out.println("Enter new genre:");
                            String newGenre = input.nextLine();
                            mov.getGenres().add(newGenre);
                        }
                        if (choice == 2) {
                            System.out.println("Enter the genre desired to be deleted:");
                            String genreToBeDeleted = input.nextLine().toLowerCase();
                            int index = -1;
                            for (int i = 0; i < mov.getGenres().size(); i++) {
                                if (mov.getGenres().get(i).equalsIgnoreCase(genreToBeDeleted)) {
                                    index = i;
                                    break;
                                }
                            }

                            if (index >= 0) {

                                mov.getGenres().remove(index);
                                System.out.println("Genre removed successfully.");
                            } else {
                                System.out.println("Genre not found in the list.");
                            }
                        }
                        if (choice == 3) {
                            mov.setGenres(getGenresFromUser());
                        }
                        break;
                    case 6:
                        System.out.println("Enter the new country:");
                        String newCountry = input.nextLine();
                        mov.setCountry(newCountry);
                        break;
                    case 7:
                        System.out.println("Enter the updated Budget:");
                        String newBudget = input.nextLine();
                        mov.setBudget(Float.parseFloat(newBudget));
                        break;
                    case 8:
                        System.out.println("Enter updated Revenue:");
                        String newRevenue = input.nextLine();
                        mov.setRevenue(Float.parseFloat(newRevenue));
                        break;
                    case 9:
                        System.out.println("Enter updated Imdb_score:");
                        String newScore = input.nextLine();
                        mov.setImdb_score(Float.parseFloat(newScore));
                        break;

                    case 10:
                        System.out.println("Press:\n 1: To add a language \n 2:To remove a language \n 3:Change the whole list of languages ");
                        int answer = input.nextInt();

                        if (answer == 1) {
                            System.out.println("Enter new language:");
                            String newLanguage = input.nextLine();
                            mov.getLanguages().add(newLanguage);
                        }
                        if (answer == 2) {
                            System.out.println("Enter the language desired to be deleted:");
                            String languageToBeDeleted = input.nextLine();
                            int index = -1;
                            for (int i = 0; i < mov.getLanguages().size(); i++) {
                                if (mov.getLanguages().get(i).equalsIgnoreCase(languageToBeDeleted)) {
                                    index = i;
                                    break;
                                }
                            }
                            if (index >= 0) {
                                mov.getLanguages().remove(index);
                                System.out.println("language removed successfully.");
                            } else {
                                System.out.println("language not found in the list.");
                            }

                        }
                        if (answer == 3) {
                            mov.setLanguages(getLanguagesFromUser());
                        }
                        break;
                }
            }
        }


    }

    public void DeleteMovies(List<Movie> movies, String movieToBeDeleted) {

        for (Movie movie : movies) {
            int index = -1;
            for (int i = 0; i < movies.size(); i++) {
                if (movie.getMovieTitle().contains(movieToBeDeleted)) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                movies.remove(index);
                System.out.println("Movie removed successfully.");
            } else {
                System.out.println("Movie not found .");
            }
        }
    }   


    public void addMoviesToFile(List<Movie> movies) {
        for (Movie movie : movies) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + MOVIE_PATH))) {
                // Append the new movie details to the file
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s,%.1f,%.1f,%.1f,%s,%s",
                        movie.getMovieId(),
                        movie.getMovieTitle(),
                        movie.getReleaseDate(),
                        movie.getDurationTime(),
                        String.join(";", movie.getActors()),
                        movie.getDirector(),
                        String.join(";", movie.getGenres()),
                        movie.getCountry(),
                        movie.getBudget(),
                        movie.getRevenue(),
                        movie.getImdb_score(),
                        String.join(";", movie.getLanguages()),
                        movie.getPoster()
                ));
                // Add a new line at the end
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}