public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int companies;

    public Person (String name, String address, double monthlySalary, int companies) {
        this.name = name;
        this.address = address;
        this.monthlySalary = monthlySalary;
        this.companies = companies;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getYearlySalary() {
        return monthlySalary*12*1.025;
    }

    public void setCompanies(int companies) {
        this.companies = companies;
    }

    public int getCompanies() {
        return companies;
    }

    public void newCompany() {
        this.companies += 1;
    }

    public void printPerson() {
        System.out.println("*******************");
        System.out.println("Name " + name);
        System.out.println("Address " + address);
        System.out.println("MonthlySalary " + monthlySalary);
        System.out.println("Has worked for " + companies + " Companies");
        System.out.println();
    }
}
