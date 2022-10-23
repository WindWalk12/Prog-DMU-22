package Exercise2;

import java.time.LocalDate;
import java.time.Period;

public class App {
    public static void main(String[] args) {
        Rental r = new Rental(76849589, 5, LocalDate.now().plusMonths(1).withDayOfMonth(1), 500);
        Rental r2 = new Rental(82740174, 10, LocalDate.now().plusMonths(10), 750);

        System.out.println("First rental");
        System.out.println(r.getTotalPrice());
        System.out.println(r.getEndDate());
        System.out.println(r.getStartDate().minusDays(1));

        System.out.println();
        System.out.println("Second rental");
        System.out.println(r2.getTotalPrice());
        System.out.println(r2.getEndDate());
        System.out.println(r2.getStartDate().minusDays(1));

        System.out.println();
        System.out.println("Various info");
        Period per = r.getStartDate().until(r2.getStartDate());
        System.out.println("Days: " + per.getDays());
        System.out.println("Months: " + per.getMonths());
        System.out.println("Years: " + per.getYears());
    }
}
