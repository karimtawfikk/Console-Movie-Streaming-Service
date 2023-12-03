package service;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class AdminService {
    Scanner input=new Scanner(System.in);
   public void AddMovies (ArrayList<Movie> m)
   {

       System.out.println("Enter the details of movie:\n");
       System.out.println("MovieId:");
               int Mid=input.nextInt();
       System.out.println("Movie name:");
             String Mname=input.nextLine();
       System.out.println("Date of release(yyyy-mm-dd):");
       LocalDate Mdate= LocalDate.parse(input.nextLine()); //next line badal next aashan next betwa2f aand space
       System.out.println("Movie Duration:");
       LocalTime Mduration= LocalTime.parse(input.nextLine());
       System.out.println("Movie Actors (Write done when finished):");
       ArrayList <String> Mactors=new ArrayList<>();
       while (true)
       {
           String Act = input.nextLine();
           if (Act.equalsIgnoreCase("done")) {
               break;
           }
           Mactors.add(Act);
       }
       System.out.println("Movie Director:");
       String Mdirector=input.next();
       System.out.println("Movie Genres (Write done when finished):");
       ArrayList <String> Mgenres=new ArrayList<>();
       while (true)
       {
           String Genre = input.nextLine();
           if (Genre.equalsIgnoreCase("done")) {
               break;
           }
            Mgenres.add(Genre);
       }
       System.out.println("Origin country:");
       String Mcountry=input.nextLine();
       System.out.println("Movie Budget:");
       Float Mbudget =input.nextFloat();
       System.out.println("Movie Revenue:");
       Float MRevenue =input.nextFloat();
       System.out.println("Movie IMDb_Score:");
       Float Mimdb =input.nextFloat();
       System.out.println("Movie Languages (Write done when finished):");
       ArrayList <String> Mlanguages=new ArrayList<>();
       while (true)
       {
           String Language = input.nextLine();
               if (Language.equalsIgnoreCase("done")) {
               break;
           }
           Mlanguages.add(Language);
       }
       System.out.println("Movie poster:");
       String Mposter=input.nextLine();

Movie NewMovie=new Movie(Mid,Mname,Mdate,Mduration,Mactors,Mdirector,Mgenres,Mcountry,Mbudget,MRevenue,Mimdb,Mlanguages,Mposter);
   m.add(NewMovie);

    }



}
