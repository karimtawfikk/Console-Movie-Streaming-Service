package service;

import model.MovieRecord;
import model.Playlist;
import model.Subscriptions;
import model.WatchRecord;
import model.user.Regular;
import utils.FileUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.REGULAR_PATH;

public class RegularService {
    private final static String FILE_PATH = DATA_DIRECTORY + REGULAR_PATH;

    public static List<Regular> readUsersFromFile() {
        ArrayList<Regular> regularUsers = new ArrayList<>();
        ArrayList<MovieRecord> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line
                int userId = Integer.parseInt(values[0],10);
                String userName = values[1];
                String password = values[2];
                String firstName = values[3];
                String lastName = values[4];
                String email = values[5];
                String[] subscriptionValues = values[6].split(";");
                boolean isSubscribed = Boolean.parseBoolean(subscriptionValues[0]);
                String subscriptionPlan = subscriptionValues[1];
                LocalDate subscriptionDate = !subscriptionValues[2].isBlank() ?
                        LocalDate.parse(subscriptionValues[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        :
                        null;
                Subscriptions subscription = new Subscriptions(isSubscribed, subscriptionPlan, subscriptionDate);
                String[] playlistValues = values[7].split(";");
                List<String> favourites = new ArrayList<>(Arrays.asList(playlistValues[0].split(":")));
                List<String> watchLater =new ArrayList<>( Arrays.asList(playlistValues[1].split(":")));
                String[] watchRecordValues= values[8].split(";");
                for(String recordLine:watchRecordValues)
                {
                    String [] lines=recordLine.split(":");
                    String movieName=lines[0];
                    LocalDate date=LocalDate.parse(lines[1],DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    float rating = !lines[2].isBlank() ?
                            Float.parseFloat(lines[2])
                            :
                            null;
                    MovieRecord newRecord=new MovieRecord(movieName,date,rating);
                    records.add(newRecord);
                }
                int movieCounter = Integer.parseInt(values[9],10);
                Playlist playlist = new Playlist(favourites, watchLater);
                WatchRecord watchRecord=new WatchRecord(records);
                Regular user = new Regular(userId, userName, password, firstName, lastName, email,playlist,watchRecord,subscription,movieCounter);
                regularUsers.add(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return regularUsers;

    }

    public static void writeUsersToFile(List<Regular> regularUsers) {
        FileUtil.deleteFileContentBeforeWritingNewOne(FILE_PATH);
        for (Regular user : regularUsers) {
            String strNumber = Integer.toString( user.getID());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true)))  //true 3shan mayms7sh el adim, yaani megher true kan beyktb satr f awl loop ba3diha fe tani loop yemsa7o w yektb el ba3dih
            {
                // Append the new movie details to the file
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getID(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPlayLists().toString(),
                        user.watchrecord.toString(),
                        user.getSubscription().toString()
                         //hayndah el toString betaatha, el hya aamlnlha override
                ));
                // Add a new line at the end
                writer.newLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
//    public static void main(String[] args)  //7atet el main di hena aashan bs negarb w ne run bs fl akher hanms7a
//    {
//
//
//
//    List<Regular> regularUsers = readUsersFromFile();
//     writeUsersToFile(regularUsers);
//    }

}