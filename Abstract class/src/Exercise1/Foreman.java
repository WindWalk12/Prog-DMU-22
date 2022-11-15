package Exercise1;

public class Foreman extends Employee {
    private int yearOfPromotion;
    private double extraSalary;

    public Foreman(String name, String address, double salaryPerHour, int weeklyWorkHours, int yearOfPromotion, double extraSalary) {
        super(name, address, salaryPerHour, weeklyWorkHours);
        this.yearOfPromotion = yearOfPromotion;
        this.extraSalary = extraSalary;
    }


    @Override
    public double weeklySalary() {
        return (super.getSalaryPerHour() + this.extraSalary) * super.getWeeklyWorkHours();
    }
}
