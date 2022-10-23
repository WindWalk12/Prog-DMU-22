package Exercise2;

import java.time.LocalDate;

public class Rental {
    private final int number;
    private int days;
    private final LocalDate startDate;
    private final double price;

    public Rental(int number, int days, LocalDate startDate, double price) {
        this.number = number;
        this.days = days;
        this.startDate = startDate;
        this.price = price;
    }

    public double getPricePrDay() {
        return this.price / this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(this.days);
    }

    public double getTotalPrice() {
        return this.price * this.days;
    }
}
