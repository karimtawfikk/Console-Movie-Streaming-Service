package model;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
public class Payment
{

    final int confirmationCode=2408;
    int price;
    static Scanner input=new Scanner(System.in);

    public void paymentMethod(){
        Random random = new Random();
        long randomNumber = random.nextLong();
        while(randomNumber<-1)
        {
            randomNumber = random.nextLong();
        }
        System.out.println("Choose your payment method \n -F for fawry \n -C for credit card");
        char payWay = input.next().charAt(0);
        if(payWay =='f' || payWay =='F'){
            System.out.println("Send money to this number: "+" "+randomNumber);
        }
        else if(payWay =='c' || payWay =='C'){

            System.out.println("Enter your credit card number:");
            long cardId=input.nextLong(); //long zay int bs more capacity
            while (!checkCard(Long.toString(cardId)))
            {
                System.out.println("Invalid credit card number..Please re-enter exactly 16 digits");
                cardId = input.nextLong();
            }
            System.out.println("enter CVV:");
            int cvv=input.nextInt();
            while (!checkCvv(Integer.toString(cvv)))
            {
                System.out.println("Invalid cvv..Please re-enter exactly 3 digits");
                cvv = input.nextInt();
            }
            input.nextLine();
            System.out.print("Expiration date (YYYY-MM-DD): ");
            String userInput = input.nextLine();
            LocalDate date = LocalDate.parse(userInput);
            System.out.println("Enter your name as written on your card:");
            String userCardName=input.nextLine();

        }

    }
    private static boolean checkCvv(String cvv)
    {
        return cvv.matches("\\d{3}");
    }
    private static boolean checkCard(String id)
    {
        return id.matches("\\d{16}");
    }
    public boolean isPaid()
    {
        boolean payStatus;
        System.out.println("Enter confirmation code that was sent to you: ");
        int inConfirm=input.nextInt();
        if(inConfirm==confirmationCode){
            payStatus=true;
        }
        else{
            payStatus=false;
        }
        return payStatus;
    }


}