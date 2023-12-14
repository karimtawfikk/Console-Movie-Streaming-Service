import model.*;
import model.user.Admin;
import model.user.Regular;
import model.user.User;
import service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static service.AdminService.monthRevenues;
import static utils.Constants.*;


public class Main {
    static Scanner input = new Scanner(System.in);
    static String username; //ehtgtha f function el displayMovies, w static aashan used in login fn which is static

    public static void main(String[] args) {
        List<Movie> movies = MovieService.readMoviesFromFile();
        List<Regular> users = RegularService.readUsersFromFile();
        List<Admin> admins = AdminService.readAdminsFromFile();
        List<Actor> actors = CastService.readActorsFromFile();
        List<Director> directors = CastService.readDirectorFromFile();
        RatingService.setRatingOfWatchItMovies(movies);
        Playlist.setTopWatchedMovies(movies);
//TODO write el welcome w kol l kalam da f function w ncall it
        System.out.println("\t\t\t\t\t\tWelcome to WATCH IT\n\n");
        boolean continueLoop = true;
        boolean loggedInAsAnAdmin = false; // aw momken testkhdm Boolean loggedInAsAnAdmin=null;
        User loggedInUser = null;
        while (continueLoop) {
            System.out.println("Press: \n 1:To register\n 2:To Login");
            int userResponse = input.nextInt();
            switch (userResponse) {
                case 1: {
                    registerAnAccount(users);
                    break;
                }
                case 2: {
                    loggedInUser = logIN(users, admins);
                    loggedInAsAnAdmin = (loggedInUser instanceof Admin);
                    continueLoop = false;
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }

        if (loggedInAsAnAdmin) {
            System.out.println("Press: \n1:To add a movie\n2:To edit a movie\n3:To delete a movie\n4:To display the most subscribed plan\n5:To edit a specific user's details\n6:To display the month with most revenue");
            int adminResponse = input.nextInt();
            switch (adminResponse) {
                case 1:
                    addMovie(movies);
                    break;
                case 2:
                    editMovies(movies);
                    break;
                case 3:
                    deleteMovies(movies);
                    break;
                case 4:
                    displayMostSubscribed(users);
                    break;
                case 5:
                    UserEditInfo(users);
                    break;
                case 6:
                    displayMonthWithMostRevenue(users);
                    break;

            }

        } else {

            checkSubscription(users);
            String response;
            do {
                System.out.println("Press: \n1:To search for a movie\n2:To search for actors\n3:To search for directors\n4:To display any of your movie lists\n5:To display all movies\n6: To display your recent watched three movies\n7:To display top rated movies\n8:To delete your account");

                int userInput = input.nextInt();
                switch (userInput) {
                    case 1:
                        searchForMovie(movies, users);
                        break;
                    case 2:
                        searchForActors(actors);
                        break;
                    case 3:
                        searchForDirectors(directors);
                        break;
                    case 4:
                        displayLists((Regular) loggedInUser);
                        break;
                    case 5:
                        displayMoviesAndWatch(movies, users);
                        break;
                    case 6:
                        displayRecentWatched(users);
                        break;
                    case 7:
                        displayTopRated(movies);
                        break;
                    case 8:
                        deleteUserAccount(users);
                        break;
                }
                System.out.println("Need any more service?" + "... Press Y to continue and N to exit");
                response = input.next();
            } while (response.equals("y") || response.equals("Y"));
        }
        AdminService.writeAdminsToFile(admins);
        RegularService.writeUsersToFile(users);
        MovieService.writeMoviesToFile(movies);
    }

    public static void registerAnAccount(List<Regular> users) {
        System.out.println("Please enter the following details to complete your registration");


        System.out.println("Enter your id: (last 4 digits only): ");
        int ID = input.nextInt();

        while (!isIdValid(Integer.toString(ID))) {
            System.out.println("Invalid ID..Please enter exactly 4 digits");
            ID = input.nextInt();
        }

        System.out.print("Enter username: ");
        String username = input.nextLine();
        input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter email: ");
        String email = input.nextLine();
        Subscriptions newRegisteredSubscription = new Subscriptions(false, null, null);
        Regular newUser = new Regular(ID, username, password, firstName, lastName, email, newRegisteredSubscription, null);
        AdminService.addRegularUsers(users, newUser);

    }

    public static User logIN(List<Regular> users, List<Admin> admins) {
        System.out.println("Please enter your username and Password:");

        while (true) {
            username = input.next();
            input.nextLine();
            String password = input.next();
            for (Regular user : users) {
                if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
                    return user;
                }

            }
            for (Admin admin : admins) {
                if (username.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
                    return admin;
                }
            }
            System.out.println("Incorrect username or password... Please re-enter correct username and password:");
        }
    }

    public static void checkSubscription(List<Regular> users) {
        int index = -1;
        for (int i = 0; i < users.size(); i++)  // dayman nestkhdmha aashan neb2a 3arfeen index el user el benshtghl bee
        {
            if (username.contains(users.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        if (!users.get(index).getSubscription().isStatus()) {
            System.out.println("Subscribe to one of our plans");
            System.out.println("\nBasic Plan: \t Standard Plan: \t Premium Plan: \t ");
            System.out.println("\nPrice: " + BASIC_PRICE + "LE  \t Price: " + STANDARD_PRICE + "LE  \t Price: " + PREMIUM_PRICE);
            System.out.println("\nYou have up to: " + BASIC_MOVIES + "movies per month \t You have up to: " + STANDARD_MOVIES + "movies per month \t You have up to: " + PREMIUM_MOVIES + "movies per month");
            System.out.println("\nWhich plan do you want to subscribe to?\n");
            String enteredPlan = input.next().toLowerCase();
            AdminService.addSubscription(users, enteredPlan, index);
        } else {
            System.out.println("You're subscribed to the " + users.get(index).getSubscription().getPlan() + " plan!");
        }

    }

    public static void displayMoviesAndWatch(List<Movie> movies, List<Regular> users) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        System.out.println("Those are our available movies for you to watch:");
        for (Movie movie : movies) {
            System.out.println(movie.getMovieTitle());
            //TODO do you want to add any of them in the watch later playlist?
        }
//        System.out.println("Do you want to add any of them in your watch later playlist");
        System.out.println("Write the movie name you want to watch:");
        String response = input.next();
        int jindex = 0;//3shan aayzin ne3raf ehna f anhy index movie
        for (Movie movie : movies)
        {
            if (response.contains(movie.getMovieTitle()))
            {
                Playlist playlist = users.get(index).getPlayLists();
                playlist.addToWatched(movie.getMovieTitle());     //   da el sah 3shan ehna mafrood call by object msh by class
                playlist.getAndAddRecentWatchedMovies(movie.getMovieTitle());
                System.out.println("Movie watched successfully!" + "\nDid you enjoy the movie?" + "\nPlease enter a movie rating from 1-10");
                int rating = input.nextInt();
                RatingService.CalculateRating(movies, movie.getMovieTitle(), rating);
                Playlist.getAndAddTopWatchedMovies(jindex,movies);
                //todo change to no static
                System.out.println("Do you want to add it to your favorite playlist?... Press Y for yes and N for no");
                String answer = input.nextLine();
                if ((answer.equals("Y") || answer.equals("y"))) {
                    users.get(index).getPlayLists().addToFavorite(movie.getMovieTitle());
                }
            }
            jindex++;
        }
    }

    public static void addMovie(List<Movie> movies) {
        Movie newMovie = null;
        try {
            System.out.println("Enter the details of the movie:");

            System.out.println("MovieId:");
            int movieId = input.nextInt();
            input.nextLine(); // 3ashan threw error bsabb nextint()

            System.out.println("Movie name:");
            String movieName = input.nextLine();

            System.out.println("Date of release(yyyy-mm-dd):");
            String movieDateString = input.nextLine();
            LocalDate releaseDate = LocalDate.parse(movieDateString);

            System.out.println("Movie Duration(hr:min):");
            LocalTime durationTime = LocalTime.parse(input.nextLine());

            System.out.println("Movie Actors.txt (Write 'done' when finished):");
            ArrayList<String> actors = new ArrayList<>();
            while (true) {
                String actorName = input.nextLine();
                if (actorName.equalsIgnoreCase("done")) {
                    break;
                }
                actors.add(actorName);
            }

            System.out.println("Movie Director:");
            String director = input.nextLine();

            System.out.println("Movie Genres (Write 'done' when finished):");
            ArrayList<String> genres = new ArrayList<>();
            while (true) {
                String genre = input.nextLine();
                if (genre.equalsIgnoreCase("done")) {
                    break;
                }
                genres.add(genre);
            }

            System.out.println("Origin country:");
            String country = input.nextLine();

            System.out.println("Movie Budget:");
            float budget = input.nextFloat();

            System.out.println("Movie Revenue:");
            float revenue = input.nextFloat();

            System.out.println("Movie IMDb_Score:");
            float imdbScore = input.nextFloat();

            input.nextLine(); // Consume the newline character

            System.out.println("Movie Languages (Write 'done' when finished):");
            ArrayList<String> languages = new ArrayList<>();
            while (true) {
                String language = input.nextLine();
                if (language.equalsIgnoreCase("done")) {
                    break;
                }
                languages.add(language);
            }

            System.out.println("Movie Poster Path:");
            String poster = input.nextLine();
            newMovie = new Movie(movieId, movieName, releaseDate, durationTime, actors, director, genres, country, budget, revenue, imdbScore, languages, poster);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (newMovie != null)
            movies.add(newMovie);

    }

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

    public static void editMovies(List<Movie> movies) {
        //how to make sure in el movie da mawgood aandna
        System.out.println("Enter the movie name you want to edit:");
        String movieTitle = input.nextLine();
        System.out.println("Press: \n1 to edit movie duration \n2 to edit movie release date \n3 to edit movie actors \n4 to edit movie director \n5 to edit movie genres \n6 to edit movie origin country \n7 to edit movie budget \n8 to edit movie revenue \n9 to edit movie imdb_score \n10 to edit movie languages \n11 to edit movie poster path ");
        int userInput = input.nextInt();
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

                    case 11:
                        System.out.println("Enter new movie poster path:");
                        String newPoster = input.nextLine();
                        mov.setPoster(newPoster);
                        break;

                }
            }
        }


    }

    public static void deleteMovies(List<Movie> movies) {
        System.out.println("Enter the movie name or list of movies you want to remove (separate movies with a semicolon if more than one ):");
        String moviesToDelete = input.nextLine();
        List<String> moviesToBeDeleted = Arrays.asList(moviesToDelete.split(";"));
        boolean removed = movies.removeIf(movie -> moviesToBeDeleted.contains(movie.getMovieTitle()));

        if (removed) {
            System.out.println("Movies with the specified titles removed successfully.");
        } else {
            System.out.println("No movies found with the specified titles.");
        }
    }

    private static boolean isIdValid(String id) {
        return id.matches("\\d{4}");
    }

    public static void UserEditInfo(List<Regular> users) {

        System.out.println("Enter your saved id: (last 4 digits only): ");
        int savedId = input.nextInt();

        while (!isIdValid(Integer.toString(savedId))) {
            System.out.println("Invalid ID..Please enter exactly 4 digits");
            savedId = input.nextInt();
        }

        System.out.println("Press: \n1 to edit your id (write only last 4 numbers) \n2 to edit your username \n3 to edit your password \n4 to edit your first name \n5 to edit your last name \n6 to edit your email \n7 to change your subscription plan ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter updated id (last 4 digits only):");
                int newId = input.nextInt();
                while (!isIdValid(Integer.toString(newId))) {
                    System.out.println("Invalid ID..Please enter exactly 4 digits");
                    newId = input.nextInt();
                }
                AdminService.AdminEditUsers(savedId, users, 1, String.valueOf(newId));
                break;
            case 2:
                System.out.println("Enter updated username:");
                String newUsername = input.nextLine();
                AdminService.AdminEditUsers(savedId, users, 2, newUsername);
                break;
            case 3:
                System.out.println("Enter updated password:");
                String newPassword = input.nextLine();
                AdminService.AdminEditUsers(savedId, users, 3, newPassword);
                break;
            case 4:
                System.out.println("Enter first name after update:");
                String newFirstName = input.nextLine();
                AdminService.AdminEditUsers(savedId, users, 4, newFirstName);
                break;
            case 5:
                System.out.println("Enter last name after update:");
                String newLastName = input.nextLine();
                AdminService.AdminEditUsers(savedId, users, 5, newLastName);
                break;
            case 6:
                System.out.println("Enter updated email:");
                String newEmail = input.nextLine();
                AdminService.AdminEditUsers(savedId, users, 6, newEmail);
                break;
            case 7:
                System.out.println("Press: \n1 to unsubscribe \n2 to change plan ");
                int ans = input.nextInt();
                while ((ans != 1) && (ans != 2)) {
                    System.out.println("Invalid choice ..Please enter either 1 or 2 only ");
                    ans = input.nextInt();
                }
                if (ans == 1) {
                    AdminService.AdminEditUsers(savedId, users, 7, "false");
                } else {
                    System.out.println("What plan do you want to upgrade to (Basic/Standard/Premium)");
                    String newPlan = input.nextLine().toLowerCase();
                    AdminService.AdminEditUsers(savedId, users, 8, newPlan);
                }

                break;

        }
    }

    public static void deleteUserAccount(List<Regular> users) {
        System.out.println("To confirm deleting your account enter your password");
        String response = input.nextLine();

        for (int index = 0; index < users.size(); index++) {
            Regular user = users.get(index);
            if (response.equals(user.getPassword())) {
                AdminService.adminRemovesUserAccount(users, index);
            }
        }

    }

    public static void searchForActors(List<Actor> actors) {
        System.out.println("Enter the actor's name:");
        input.nextLine();
        String actorName = input.nextLine();
        for (int index = 0; index < actors.size(); index++) {
            Actor actor = actors.get(index);
            if (actorName.equals(actor.getFullName())) {
                CastService.displayActorDetails(actors, index);
            }
        }

    }

    public static void searchForDirectors(List<Director> directors) {
        System.out.println("Enter the director name:");
        String directorName = input.next();
        for (int index = 0; index < directors.size(); index++) {
            Director director = directors.get(index);
            if (directorName.equals(director.getFullName())) {
                CastService.displayDirectorDetails(directors, index);
            }
        }

    }

    public static void searchForMovie(List<Movie> movies, List<Regular> users) {
        System.out.println("Press: \n1 to search for a specific movie by its name \n2 to search for movies by a specific genre");
        int in = input.nextInt();
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (username.contains(users.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        switch (in) {
            case 1:
                System.out.println("Enter Movie Name to search for");
                String movieName = input.next();
                Movie MovieReturned = MovieService.searchForMovieByTitle(movies, movieName);
                System.out.println("Movie details: \nDuration: " + MovieReturned.getDurationTime() + "\nImdb_score: " + MovieReturned.getImdb_score() + "\nOrigin country: " + MovieReturned.getCountry() + "\nActors: " + MovieReturned.getActors() + "\nDirector: " + MovieReturned.getDirector() + "\nGenres: " + MovieReturned.getGenres() + "\nLanguaes: " + MovieReturned.getLanguages() + "\nRelease Year: " + MovieReturned.getReleaseDate().getYear());
                System.out.println("Do you want to watch this movie?");
                String response = input.next();
                if ((response.equals("Y") || response.equals("y"))) {
                    Playlist playlist = users.get(index).getPlayLists();
                    playlist.addToWatched(MovieReturned.getMovieTitle());      //  da el sah 3shan ehna mafrood call by object msh by class
                    playlist.getAndAddRecentWatchedMovies(MovieReturned.getMovieTitle());
                    //TODO han3ml nafs l hga el aamlnha f fun displaymoviesand watch(call by object msh by class)
                    System.out.println("Movie watched successfully!" + "\nDid you enjoy the movie?" + "\nPlease enter a movie rating from 1-10");
                    int rating = input.nextInt();
                    RatingService.CalculateRating(movies, MovieReturned.getMovieTitle(), rating);
                    System.out.println("Do you want to add it to your favorite playlist?... Press Y for yes and N for no");
                    String answer = input.nextLine();
                    if ((answer.equals("Y") || answer.equals("y"))) {
                        users.get(index).getPlayLists().addToFavorite(movieName);
                    }
                }
                break;
            case 2:
                System.out.println("Enter Genre to search by");
                String Genre = input.next();
                List<Movie> MoviesFound = MovieService.searchForMovieByGenre(movies, Genre);
                int i = 1;
                for (Movie movie : MoviesFound) {
                    System.out.println("Movie " + i + ": \nMovie Name:" + movie.getMovieTitle() + " \nMovie duration: " + movie.getDurationTime() + "\nImdb_score: " + movie.getImdb_score() + "\nOrigin country: " + movie.getCountry() + "\nActors: " + movie.getActors() + "\nDirector: " + movie.getDirector() + "\nLanguaes: " + movie.getLanguages() + "\nRelease Year: " + movie.getReleaseDate().getYear() + "\n");
                    i++;
                }
                break;
        }
    }

    public static void displayMostSubscribed(List<Regular> users) {
        System.out.println("The most subscribed plan up till now is the " + AdminService.seeMostSubscribed(users) + " plan");
    }

    public static void displayLists(Regular user) {
        System.out.println("Press: \n1:To display favourites list \n2:To display watchLater list \n3:To display watched list");
        int entered = input.nextInt();
        switch (entered) {
            case 1:
                System.out.println(user.getPlayLists().getFavoritePlaylist());
                //user:esm l object 3ady, we 3shan tendah getfav function lazm objname.fnname, fa getplaylist beyrg3lna l object
                break;
            case 2:
                System.out.println(user.getPlayLists().getWatchLaterplaylist());
                break;
            case 3:
                System.out.println(user.getPlayLists().getWatchedPlaylist());
                break;
        }
    }

    public static void displayMonthWithMostRevenue(List<Regular> users) {
        for (int i = 0; i < users.size(); i++) {
            Integer monthValue = null;
            LocalDate date = users.get(i).getSubscription().getSubscribeDate();
            if (date != null) {
                monthValue = date.getMonthValue();
                AdminService.calculateRevenue(users, monthValue, i);
            }
//            if (monthValue != null) {
//                AdminService.calculateRevenue(users, monthValue, i);
//            }

        }
        int maxIndex = 0;
        for (int i = 0; i < 12; i++) {
            if (monthRevenues[i] > monthRevenues[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("The month that had the most revenue is month" + monthRevenues[maxIndex]);
    }

    public static void displayRecentWatched(List<Regular> users) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (username.contains(users.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        Playlist playlist = users.get(index).getPlayLists();
        //
        //In Java, the default toString() method for arrays doesn't provide a useful representation of the array's contents. It prints the type of the array followed by its hash code. For example, if you have an array of strings:
        // fa laz, ne override 3shan netal3 l gowa bzbt
        if (Arrays.toString(playlist.getRecentMovies()).equals("[null, null, null]")) {
            System.out.println("You haven't completed watching 3 movies");
        } else
            System.out.println(Arrays.toString(playlist.getRecentMovies()));
    }

    public static void displayTopRated(List<Movie> movies)
    {
        Playlist.getAndAddTopRatedMovies(movies);
        System.out.println("The top rated movies are:\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + "." + Playlist.topRatedMovies[i] + "\n");
        }
    }

    public static void displayTopWatched(List<Movie> movies)
    {
        System.out.println("Your top watched movies are:\n");
    for(int i=0; i<3; i++)
    {
        System.out.println(i + 1 + "." +Playlist.topWatchedMovies[i] + "\n");
    }
    }


}
