package service;

import model.user.Regular;
import java.io.*;
import java.util.List;
import model.user.Admin;
import java.util.Scanner;
import static utils.Constants.*;
import java.util.ArrayList;
public class AdminService {

        public static List<Admin> readAdminsFromFile() {

            ArrayList<Admin> Admins = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + ADMIN_PATH))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] values = line.split(",");
                    // Extract the values for each field from the line
                    int AdminId = Integer.parseInt(values[0]);
                    String adminUserName = values[1];
                    String adminPassword = values[2];
                    String adminFname = values[2];
                    String adminLname = values[2];
                    String adminEmail = values[2];

                    // Create a new Admin instance and add it to the list
                    Admin createdAdmin = new Admin(AdminId, adminUserName, adminPassword, adminFname, adminLname, adminEmail);
                    Admins.add(createdAdmin); // kol loop hathot fe element gedid beta3 movies movie gedid
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
            return Admins;
        }

        public void AdminEditUsers(int id,List<Regular> users,int choice,String newValue) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID()==id) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            switch(choice){
                case 1:
                    users.get(index).setID(Integer.parseInt(newValue));
                    System.out.println("Id updated successfully");
                    break;
                case 2:
                    users.get(index).setUserName(newValue);
                    System.out.println("Username updated successfully");
                    break;
                case 3:
                    users.get(index).setPassword(newValue);
                    System.out.println("Password updated successfully");
                    break;
                case 4:
                    users.get(index).setFirstName(newValue);
                    System.out.println("First Name updated successfully");
                    break;
                case 5:
                    users.get(index).setLastName(newValue);
                    System.out.println("Last Name updated successfully");
                    break;
                case 6:
                    users.get(index).setEmail(newValue);
                    System.out.println("Email updated successfully");
                    break;
                case 7:
                    users.get(index).setSubscription(newValue);
                    System.out.println("Plan updated successfully");
                    break;
            }
        }
        else {
            System.out.println("User not found.");
        }

    }

        public static void writeAdminsToFile(List<Admin> admins)
        {
            for (Admin admin : admins) {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + ADMIN_PATH))) {
                    // Append the new movie details to the file
                    writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s,%.1f,%.1f,%.1f,%s,%s",
                            admin.getID(),
                            admin.getUserName(),
                            admin.getPassword(),
                            admin.getFirstName(),
                            admin.getLastName(),
                            admin.getEmail()

                    ));

                    writer.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }



}
