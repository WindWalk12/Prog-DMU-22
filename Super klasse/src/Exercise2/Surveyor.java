package Exercise2;

public class Surveyor extends Mechanic {
    private int surveysPerWeek;

    public Surveyor(String name, String address, int yearOfFinishedEducation, double salaryPerHour, int surveysPerWeek) {
        super(name, address, yearOfFinishedEducation, salaryPerHour);
        this.surveysPerWeek = surveysPerWeek;
    }

    @Override
    public double calcSalary() {
        return super.calcSalary() + (surveysPerWeek * 29);
    }
}
