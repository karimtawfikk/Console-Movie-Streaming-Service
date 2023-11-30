import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Subscriptions {
        float price = 0;
        char plan;
        LocalDate date;
        //int sday=date.getDayOfMonth();
        //int smonth=date.getMonthValue();
        //int syear=date.getYear();

        LocalDate cdate=LocalDate.now();

        long diff;

        public Subscriptions(LocalDate date, char plan) {
            this.date=date;
            this.plan = plan;
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

        void dueDate(int day,int month,int year){
            diff= ChronoUnit.DAYS.between(date, cdate);
            if(diff>30) {
                plan = '\0';
                System.out.println("your subscription has ended");
            }

        }

    }


