package service;
import model.Movie;
import model.Subscriptions;
import model.user.Regular;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.*;

public class RegularService {
    public static List<Regular> readUsersFromFile() {
        ArrayList<Regular> regularUsers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + REGULAR_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line
                int userId = Integer.parseInt(values[0]);
                String userName = values[1];
                String password = values[2];
                String firstName = values[3];
                String lastName = values[4];
                String email = values[5];
                String[] subscriptionValues = values[6].split(";");
                boolean isSubscribed = Boolean.parseBoolean(subscriptionValues[0]);
                String subscriptionPlan =subscriptionValues[0];
                LocalDate subscriptionDate = LocalDate.parse(subscriptionValues[1]);
                Subscriptions subscription = new Subscriptions(isSubscribed, subscriptionPlan, subscriptionDate);

                ArrayList<String> watchLater = new ArrayList<>(Arrays.asList(values[7].split(";")));
                ArrayList<String> watched = new ArrayList<>(Arrays.asList(values[8].split(";")));

                Regular user = new Regular(userId, userName, password, firstName, lastName, email, subscription, watchLater,
                        watched);
                regularUsers.add(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return regularUsers;

    }

    public static void writeUsersToFile(List<Regular> regularUsers) {
        for (Regular user : regularUsers) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + REGULAR_PATH))) {
                // Append the new movie details to the file
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getID(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getSubscription(),
                        String.join(";", user.getWatchLater()),
                        String.join(";", user.getWatched())
                ));
                // Add a new line at the end
                writer.newLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
