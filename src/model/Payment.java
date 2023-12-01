package model;

public class Payment {//extends Subscriptions
    private String planName;
    //price andd plan inherited from subscriptions
    private double price;
    private int duration; // in months

    public Payment(String planName, double price, int duration) {
        this.planName = planName;
        this.price = price;
        this.duration = duration;
    }

    public String getPlanName() { //mn subscriptions
        return planName;
    }

    public double getPrice() { //mn subscriptions
        return price;
    }

    public int getDuration() { //elmafrud 1 month bas
        return duration;
    }

    public void setPlanName(String planName) { ///mn subscriptions
        this.planName = planName;
    }

    public void setPrice(double price) { //mn subscriptions
        this.price = price;
    }

    public void setDuration(int duration) { //elmafrud 1 month bas
        this.duration = duration;
    }

    public String toString() {
        return "Plan: " + planName + "\nPrice: $" + price + " per month\nDuration: " + duration + " months";
    }

}

