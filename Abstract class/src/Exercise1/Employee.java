package Exercise1;

public abstract class Employee extends Person {
    private double salaryPerHour;
    private int weeklyWorkHours;

    public Employee(String name, String address, double salaryPerHour, int weeklyWorkHours) {
        super(name, address);
        this.salaryPerHour = salaryPerHour;
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public void setWeeklyWorkHours(int weeklyWorkHours) {
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public int getWeeklyWorkHours() {
        return weeklyWorkHours;
    }

    public abstract double weeklySalary();
}
