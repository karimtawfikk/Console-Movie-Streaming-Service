package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Subscriptions {
    boolean status;
    String  plan;
    LocalDate subscribeDate;


    public Subscriptions(boolean status, String plan, LocalDate subscribeDate) {
        this.status = status;
        this.plan = plan;
        this.subscribeDate = subscribeDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public LocalDate getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(LocalDate subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public float calcprice(float price, char plan) {
        if (plan == 'B' || plan == 'b') {
            price += 100;
        } else if (plan == 'S' || plan == 's') {
            price += 250;
        } else if (plan == 'P' || plan == 'p') {
            price += 500;
        }
        return price;
    }

    void dueDate() {
        long diff = ChronoUnit.DAYS.between(subscribeDate, LocalDate.now());
        if (diff > 30) {
            plan = null;
            System.out.println("your subscription has ended");
        }

    }

}


