package Exercise3;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars;

    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
        this.cars = new ArrayList<>();
    }

    public double getPrice() {
        double allPrices = 0;
        for (Car c : cars) {
            allPrices += c.getPricePerDay();
        }
        return allPrices * this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void addCar(Car c) {
        if (!cars.contains(c)) {
            cars.add(c);
        }
    }
}
