package Exercise1;

public class Surveyor extends Mechanic {
    private int surveysPerWeek;

    public Surveyor(String name, String address, double salaryPerHour, int weeklyWorkHours, int yearOfFinishedEducation, int surveysPerWeek) {
        super(name, address,salaryPerHour, weeklyWorkHours, yearOfFinishedEducation);
        this.surveysPerWeek = surveysPerWeek;
    }

    @Override
    public double calcSalary() {
        return super.calcSalary() + (surveysPerWeek * 29);
    }
}
