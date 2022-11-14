package Exercise1;

public class Foreman extends Mechanic {
    private int yearOfPromotion;
    private double extraSalary;

    public Foreman(String name, String address, int yearOfFinishedEducation, double salaryPerHour, int yearOfPromotion, double extraSalary) {
        super(name, address, yearOfFinishedEducation, salaryPerHour);
        this.yearOfPromotion = yearOfPromotion;
        this.extraSalary = extraSalary;
    }
}
