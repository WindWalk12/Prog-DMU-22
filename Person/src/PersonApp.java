public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Jonas","Gertrudsvej 54", 2000, 2);
        p1.printPerson();
        System.out.println("Has a yearly salary of " + p1.getYearlySalary());
        System.out.println("");
        p1.newCompany();
        p1.printPerson();
    }
}
