package Exercise1;

public class Mechanic extends Employee {
    private int yearOfFinishedEducation;

    public Mechanic(String name, String address, double salaryPerHour, int weeklyWorkHours, int yearOfFinishedEducation) {
        super(name, address, salaryPerHour, weeklyWorkHours);
        this.yearOfFinishedEducation = yearOfFinishedEducation;
    }

    public int getYearOfFinishedEducation() {
        return yearOfFinishedEducation;
    }

    public void setYearOfFinishedEducation(int yearOfFinishedEducation) {
        this.yearOfFinishedEducation = yearOfFinishedEducation;
    }

    public double getSalaryPerHour() {
        return super.getSalaryPerHour();
    }

    public void setSalaryPerHour(double salaryPerHour) {
        super.setSalaryPerHour(salaryPerHour);
    }

    @Override
    public double weeklySalary() {
        return super.getSalaryPerHour() * super.getWeeklyWorkHours();
    }

    public double calcSalary() {
        return super.getSalaryPerHour() * super.getWeeklyWorkHours();
    }
}
