package service;

import model.Payment;
import model.Subscriptions;
import model.user.Admin;
import model.user.Regular;
import utils.FileUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Constants.*;

public class AdminService {

    private final static String FILE_PATH = DATA_DIRECTORY + ADMIN_PATH;
    private static int Basic_Counter = 0;
    private static int Standard_Counter = 0;
    private static int Premium_Counter = 0;
    private static final int[] monthRevenues = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static List<Admin> readAdminsFromFile() {

        ArrayList<Admin> Admins = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(DATA_DIRECTORY + ADMIN_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                // Extract the values for each field from the line
                String AdminId = values[0];
                String adminUserName = values[1];
                String adminPassword = values[2];
                String adminFname = values[3];
                String adminLname = values[4];
                String adminEmail = values[5];
                // Create a new Admin instance and add it to the list
                Admin createdAdmin = new Admin(AdminId, adminUserName, adminPassword, adminFname, adminLname, adminEmail);
                Admins.add(createdAdmin); // kol loop hathot fe element gedid beta3 movies movie gedid
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return Admins;
    }

    public static int[] getMonthRevenues() {
        return monthRevenues;
    }

    public static void addRegularUsers(List<Regular> users, Regular newUser) {
        users.add(newUser);
    }

    public static void addSubscription(List<Regular> users, String plan, int index) {

        Payment payment = new Payment();
        payment.paymentMethod();
        //Overall, this code snippet demonstrates how to obtain the current date,
        // format it into a desired string representation using a DateTimeFormatter,
        // and then parsethat formatted string back into a LocalDate object using the same formatter.
        if (payment.isPaid()) {
            System.out.println("Payment successful. Enjoy your plan!");
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedCurrentDate = currentDate.format(formatter);
            LocalDate parsedDate = LocalDate.parse(formattedCurrentDate, formatter);
            Subscriptions newSub = new Subscriptions(true, plan, parsedDate);
            users.get(index).setSubscription(newSub);
        } else {
            System.out.println("Invalid confirmation code. Payment not confirmed.");
            addSubscription(users, plan, index);
        }
    }

    public static void AdminEditUsers(String id, List<Regular> users, int choice, String newValue) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(id)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            switch (choice) {
                case 1:
                    users.get(index).setID(newValue);
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
                    Subscriptions subscription = users.get(index).getSubscription();
                    subscription.setStatus(Boolean.parseBoolean(newValue));
                    subscription.setPlan(null);
                    subscription.setSubscribeDate(null);
                    break;
                case 8:
                    Subscriptions subscriptionn = users.get(index).getSubscription();
                    subscriptionn.setPlan(newValue);
                    subscriptionn.setSubscribeDate(LocalDate.now());
                    break;
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public static void adminRemovesUserAccount(List<Regular> users, int index) {
        users.remove(index);
        System.out.println("Account deleted successfully\nTo continue enjoying our service you'd have to log in!");
        RegularService.writeUsersToFile(users);
        System.exit(0);
    }

    public static String seeMostSubscribed(List<Regular> users)
    {
        for (Regular user : users)
        {
            switch (user.getSubscription().getPlan())
            {
                case "basic" -> Basic_Counter++;
                case "standard" -> Standard_Counter++;
                case "premium" -> Premium_Counter++;
            }
        }

        int mostSubscribed = Math.max(Basic_Counter, Math.max(Standard_Counter, Premium_Counter));
        if (mostSubscribed == Basic_Counter)
        {
            return "Basic";
        } else if (mostSubscribed == Standard_Counter) {
            return "Standard";
        } else {
            return "Premium";
        }
    }

    public static void calculateRevenue(List<Regular> users, Integer monthValue, int index) {

        switch (monthValue)
        {
            case 1:
                String planJan = users.get(index).getSubscription().getPlan();
                if (planJan.equals("basic"))
                    monthRevenues[0] += BASIC_PRICE;
                if (planJan.equals("standard"))
                    monthRevenues[0] += STANDARD_PRICE;
                if (planJan.equals("premium"))
                    monthRevenues[0] += PREMIUM_PRICE;
                break;
            case 2:
                String planFeb = users.get(index).getSubscription().getPlan();
                if (planFeb.equals("basic"))
                    monthRevenues[1] += BASIC_PRICE;
                if (planFeb.equals("standard"))
                    monthRevenues[1] += STANDARD_PRICE;
                if (planFeb.equals("premium"))
                    monthRevenues[1] += PREMIUM_PRICE;
                break;
            case 3:
                String planMar = users.get(index).getSubscription().getPlan();
                if (planMar.equals("basic"))
                    monthRevenues[2] += BASIC_PRICE;
                if (planMar.equals("standard"))
                    monthRevenues[2] += STANDARD_PRICE;
                if (planMar.equals("premium"))
                    monthRevenues[2] += PREMIUM_PRICE;
                break;
            case 4:
                String planApr = users.get(index).getSubscription().getPlan();
                if (planApr.equals("basic"))
                    monthRevenues[3] += BASIC_PRICE;
                if (planApr.equals("standard"))
                    monthRevenues[3] += STANDARD_PRICE;
                if (planApr.equals("premium"))
                    monthRevenues[3] += PREMIUM_PRICE;
                break;
            case 5:
                String planMay = users.get(index).getSubscription().getPlan();
                if (planMay.equals("basic"))
                    monthRevenues[4] += BASIC_PRICE;
                if (planMay.equals("standard"))
                    monthRevenues[4] += STANDARD_PRICE;
                if (planMay.equals("premium"))
                    monthRevenues[4] += PREMIUM_PRICE;
                break;
            case 6:
                String planJune = users.get(index).getSubscription().getPlan();
                if (planJune.equals("basic"))
                    monthRevenues[5] += BASIC_PRICE;
                if (planJune.equals("standard"))
                    monthRevenues[5] += STANDARD_PRICE;
                if (planJune.equals("premium"))
                    monthRevenues[5] += PREMIUM_PRICE;
                break;
            case 7:
                String planJuly = users.get(index).getSubscription().getPlan();
                if (planJuly.equals("basic"))
                    monthRevenues[6] += BASIC_PRICE;
                if (planJuly.equals("standard"))
                    monthRevenues[6] += STANDARD_PRICE;
                if (planJuly.equals("premium"))
                    monthRevenues[6] += PREMIUM_PRICE;
                break;
            case 8:
                String planAug = users.get(index).getSubscription().getPlan();
                if (planAug.equals("basic"))
                    monthRevenues[7] += BASIC_PRICE;
                if (planAug.equals("standard"))
                    monthRevenues[7] += STANDARD_PRICE;
                if (planAug.equals("premium"))
                    monthRevenues[7] += PREMIUM_PRICE;
                break;
            case 9:
                String planSep = users.get(index).getSubscription().getPlan();
                if (planSep.equals("basic"))
                    monthRevenues[8] += BASIC_PRICE;
                if (planSep.equals("standard"))
                    monthRevenues[8] += STANDARD_PRICE;
                if (planSep.equals("premium"))
                    monthRevenues[8] += PREMIUM_PRICE;

                break;
            case 10:
                String planOct = users.get(index).getSubscription().getPlan();
                if (planOct.equals("basic"))
                    monthRevenues[9] += BASIC_PRICE;
                if (planOct.equals("standard"))
                    monthRevenues[9] += STANDARD_PRICE;
                if (planOct.equals("premium"))
                    monthRevenues[9] += PREMIUM_PRICE;
                break;
            case 11:
                String planNov = users.get(index).getSubscription().getPlan();
                if (planNov.equals("basic"))
                    monthRevenues[10] += BASIC_PRICE;
                if (planNov.equals("standard"))
                    monthRevenues[10] += STANDARD_PRICE;
                if (planNov.equals("premium"))
                    monthRevenues[10] += PREMIUM_PRICE;

                break;
            case 12:
                String planDec = users.get(index).getSubscription().getPlan();
                if (planDec.equals("basic"))
                    monthRevenues[11] += BASIC_PRICE;
                if (planDec.equals("standard"))
                    monthRevenues[11] += STANDARD_PRICE;
                if (planDec.equals("premium"))
                    monthRevenues[11] += PREMIUM_PRICE;

                break;
        }
    }


    public static void writeAdminsToFile(List<Admin> admins) {
        FileUtil.deleteFileContentBeforeWritingNewOne(FILE_PATH);
        for (Admin admin : admins) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + ADMIN_PATH, true))) {
                // Append the new movie details to the file
                writer.write(String.format("%s,%s,%s,%s,%s,%s",
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
