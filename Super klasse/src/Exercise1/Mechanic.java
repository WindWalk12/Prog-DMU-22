package Exercise1;

public class Mechanic extends Person {
    private int yearOfFinishedEducation;
    private double salaryPerHour;

    public Mechanic(String name, String address, int yearOfFinishedEducation, double salaryPerHour) {
        super(name, address);
        this.yearOfFinishedEducation = yearOfFinishedEducation;
        this.salaryPerHour = salaryPerHour;
    }

    public int getYearOfFinishedEducation() {
        return yearOfFinishedEducation;
    }

    public void setYearOfFinishedEducation(int yearOfFinishedEducation) {
        this.yearOfFinishedEducation = yearOfFinishedEducation;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
