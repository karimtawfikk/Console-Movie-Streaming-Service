
public class Payment {
    char planType;
    float price;
    long cardNum;

    String status;
    //plan & price passed mn subscriptions through constructor 1
    public Payment(char planType, float price) {
        this.planType = planType;
        this.price = price;
    }
    public Payment(String status){
        //nehot ehna el status approved or rejected maslan
        this.status=status;
    }

}

