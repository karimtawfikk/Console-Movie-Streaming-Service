package service;

import model.Subscriptions;
import model.user.Regular;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.user.Admin;
import utils.FileUtil;

import java.util.Scanner;
import static utils.Constants.*;
import java.util.ArrayList;
import java.lang.Math;
public class AdminService
{

    private final static String FILE_PATH = DATA_DIRECTORY + ADMIN_PATH;
    public static int Basic_Counter=-0;
    public static int Standard_Counter=0;
    public static int Premium_Counter=0;
    public static int[] monthRevenues ={0,0,0,0,0,0,0,0,0,0,0,0};
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
    public static void addRegularUsers(List<Regular> users, Regular newUser) {

        if (newUser != null)
            users.add(newUser);

    }
    public static void addSubscription(List<Regular>users, String plan,int index)
    {
        //Overall, this code snippet demonstrates how to obtain the current date,
        // format it into a desired string representation using a DateTimeFormatter,
        // and then parsethat formatted string back into a LocalDate object using the same formatter.

        LocalDate currentDate=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedCurrentDate=currentDate.format(formatter);
        LocalDate parsedDate = LocalDate.parse(formattedCurrentDate, formatter);
        Subscriptions newSub=new Subscriptions(true,plan,parsedDate);
        users.get(index).setSubscription(newSub);
    }
    public static void AdminEditUsers(int id,List<Regular> users,int choice,String newValue) {
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
        }
        else {
            System.out.println("User not found.");
        }

    }
    public static void adminRemovesUserAccount(List<Regular> users, int index)
    {
        users.remove(index);
    }

    public static String seeMostSubscribed(List<Regular> users){
        for(Regular user:users){
            if(user.getSubscription().getPlan().equals("basic")) {
                Basic_Counter++;
            }
            else if (user.getSubscription().getPlan().equals("standard")) {
                Standard_Counter++;
            }
            else if(user.getSubscription().getPlan().equals("premium")){
                Premium_Counter++;
            }
        }
        int mostSubscribed = Math.max(Basic_Counter, Math.max(Standard_Counter, Premium_Counter));
        if(mostSubscribed==Basic_Counter){
            return "Basic";
        }
        else if(mostSubscribed==Standard_Counter){
            return "Standard";
        }
        else
        {
            return "Premium";
        }
    }//FARES W BOBO BYMSOOO

    public static void calculateRevenue(List<Regular>users,Integer monthValue,int index) {

        switch (monthValue) {
            case 1:
                String planJan = users.get(index).getSubscription().getPlan();
                if (planJan.equals("Basic"))
                    monthRevenues[0] += BASIC_PRICE;
                if (planJan.equals("Standard"))
                    monthRevenues[0] += STANDARD_PRICE;
                if (planJan.equals("Premium"))
                    monthRevenues[0] += PREMIUM_PRICE;
                break;
            case 2:
                String planFeb = users.get(index).getSubscription().getPlan();
                if (planFeb.equals("Basic"))
                    monthRevenues[1] += BASIC_PRICE;
                if (planFeb.equals("Standard"))
                    monthRevenues[1] += STANDARD_PRICE;
                if (planFeb.equals("Premium"))
                    monthRevenues[1] += PREMIUM_PRICE;
                break;
            case 3:
                String planMar = users.get(index).getSubscription().getPlan();
                if (planMar.equals("Basic"))
                    monthRevenues[2] += BASIC_PRICE;
                if (planMar.equals("Standard"))
                    monthRevenues[2] += STANDARD_PRICE;
                if (planMar.equals("Premium"))
                    monthRevenues[2] += PREMIUM_PRICE;
                break;
            case 4:
                String planApr = users.get(index).getSubscription().getPlan();
                if (planApr.equals("Basic"))
                    monthRevenues[3] += BASIC_PRICE;
                if (planApr.equals("Standard"))
                    monthRevenues[3] += STANDARD_PRICE;
                if (planApr.equals("Premium"))
                    monthRevenues[3] += PREMIUM_PRICE;
                break;
            case 5:
                String planMay = users.get(index).getSubscription().getPlan();
                if (planMay.equals("Basic"))
                    monthRevenues[4] += BASIC_PRICE;
                if (planMay.equals("Standard"))
                    monthRevenues[4] += STANDARD_PRICE;
                if (planMay.equals("Premium"))
                    monthRevenues[4] += PREMIUM_PRICE;
                break;
            case 6:
                String planJune = users.get(index).getSubscription().getPlan();
                if (planJune.equals("Basic"))
                    monthRevenues[5] += BASIC_PRICE;
                if (planJune.equals("Standard"))
                    monthRevenues[5] += STANDARD_PRICE;
                if (planJune.equals("Premium"))
                    monthRevenues[5] += PREMIUM_PRICE;
                break;
            case 7:
                String planJuly = users.get(index).getSubscription().getPlan();
                if (planJuly.equals("Basic"))
                    monthRevenues[6] += BASIC_PRICE;
                if (planJuly.equals("Standard"))
                    monthRevenues[6] += STANDARD_PRICE;
                if (planJuly.equals("Premium"))
                    monthRevenues[6] += PREMIUM_PRICE;
                break;
            case 8:
                String planAug = users.get(index).getSubscription().getPlan();
                if (planAug.equals("Basic"))
                    monthRevenues[7] += BASIC_PRICE;
                if (planAug.equals("Standard"))
                    monthRevenues[7] += STANDARD_PRICE;
                if (planAug.equals("Premium"))
                    monthRevenues[7] += PREMIUM_PRICE;
                break;
            case 9:
                String planSep = users.get(index).getSubscription().getPlan();
                if (planSep.equals("Basic"))
                    monthRevenues[8] += BASIC_PRICE;
                if (planSep.equals("Standard"))
                    monthRevenues[8] += STANDARD_PRICE;
                if (planSep.equals("Premium"))
                    monthRevenues[8] += PREMIUM_PRICE;

                break;
            case 10:
                String planOct = users.get(index).getSubscription().getPlan();
                if (planOct.equals("Basic"))
                    monthRevenues[9] += BASIC_PRICE;
                if (planOct.equals("Standard"))
                    monthRevenues[9] += STANDARD_PRICE;
                if (planOct.equals("Premium"))
                    monthRevenues[9] += PREMIUM_PRICE;
                break;
            case 11:
                String planNov = users.get(index).getSubscription().getPlan();
                if (planNov.equals("Basic"))
                    monthRevenues[10] += BASIC_PRICE;
                if (planNov.equals("Standard"))
                    monthRevenues[10] += STANDARD_PRICE;
                if (planNov.equals("Premium"))
                    monthRevenues[10] += PREMIUM_PRICE;

                break;
            case 12:
                String planDec = users.get(index).getSubscription().getPlan();
                if (planDec.equals("Basic"))
                    monthRevenues[11] += BASIC_PRICE;
                if (planDec.equals("Standard"))
                    monthRevenues[11] += STANDARD_PRICE;
                if (planDec.equals("Premium"))
                    monthRevenues[11] += PREMIUM_PRICE;

                break;




        }

    }

    public static void writeAdminsToFile (List <Admin> admins)
    {
        FileUtil.deleteFileContentBeforeWritingNewOne(FILE_PATH);
        for (Admin admin : admins) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIRECTORY + ADMIN_PATH, true))) {
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
