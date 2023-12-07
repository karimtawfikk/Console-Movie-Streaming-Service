package model;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
public class Payment {

    //public String plan;
    public boolean payStatus;
    final int confirmationCode=2408;
    final int basic = 50;

    final int standard = 150;
    final int premium = 200;
    int price;
    static Scanner input=new Scanner(System.in);
    public void PlanType(String plan) {
        if (plan.equals("basic")) {
            price = basic;
        } else if (plan.equals("standard")) {
            price = standard;
        } else if (plan.equals("premium")) {
            price = premium;
        }
    }

    public void paymentMethod(){
        Random random = new Random();
        long randomNumber = random.nextLong();
        System.out.println("Choose your payment method \n -F for fawry \n -C for credit card");
        char payWay = input.next().charAt(0);

        if(payWay =='f' || payWay =='F'){
            System.out.println("Send money to this number: "+" "+randomNumber);

            //hays2alo dafa3 wala la w ba3den y call function ashan yetaakd eno daf3 y-set el bool le true
            System.out.println("Did you pay? if so enter Y");
            char resp=input.next().charAt(0);
            if(resp=='y' || resp=='Y'){
                isPaid();
            }
        }
        else if(payWay =='c' || payWay =='C'){

            System.out.println("Enter your credit card ID: ");
            int cardId=input.nextInt();
            while (!CheckCard(Integer.toString(cardId))) {
                System.out.println("Invalid ID..Please enter exactly 16 digits");
                cardId = input.nextInt();
            }


            System.out.println("enter CVV: ");
            int cvv=input.nextInt();

            //bool x ashan ashuf law el cvv =3 fe3lan wala laa w law la alef aleha lehad ma ydkhal 3 digits bas
            boolean x=false;
            while (x == false) {
                if (Integer.toString(cvv).length() == 3) {
                    System.out.println("Enter EXACTLY 3 numbers: ");
                    cvv = input.nextInt();
                    x=true;
                }

                System.out.println("Invalid ID..Please enter exactly 16 digits");
                cardId = input.nextInt();
            }

            System.out.print("Expiration date (YYYY-MM-DD): ");
            String userInput = input.nextLine();
            LocalDate date = LocalDate.parse(userInput);

            System.out.println("Enter your name as written on your card:  ");
            String userCardName=input.nextLine();

            //hays2alo dafa3 wala la w ba3den y call function ashan yetaakd eno daf3 y-set el bool le true
            System.out.println("Did you pay? if so enter Y");
            char resp=input.next().charAt(0);
            if(resp=='y' || resp=='Y'){
                isPaid();
            }

        }

    }



    private static boolean CheckCard(String id) {
        return id.matches("\\d{16}");
    }


    public void isPaid(){
        System.out.println("Enter confirmation code that was sent to you: ");
        int inConfirm=input.nextInt();
        if(inConfirm==confirmationCode){
            payStatus=true;
        }
        else{
            payStatus=false;
        }
    }


}