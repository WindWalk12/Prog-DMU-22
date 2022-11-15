package Exercise1;

public class WorkingBoy extends Employee {

    public WorkingBoy(String name, String address, double salaryPerHour, int weeklyWorkHours) {
        super(name, address, salaryPerHour, weeklyWorkHours);
    }

    @Override
    public double weeklySalary() {
        return super.getSalaryPerHour() * super.getWeeklyWorkHours();
    }
}
