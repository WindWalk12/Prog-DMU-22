package Exercise1;

import java.util.ArrayList;

public class App {
    public static double calcTotalSalary(ArrayList<Employee> employees) {
        double sum = 0;
        for (Employee e :employees) {
            sum += e.weeklySalary();
        }
        return sum;
    }
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Mechanic m1 = new Mechanic("Bob", "Syrrænvænget 33", 150.0, 37, 1987);
        employees.add(m1);

        Foreman f1 = new Foreman("F1", "uiguge", 150.0, 40,1960, 60.0);
        employees.add(f1);

        Surveyor s1 = new Surveyor("S1", "ussdog", 124.3, 30,1990, 60);
        employees.add(s1);

        WorkingBoy wb1 = new WorkingBoy("WB1", "gerigj", 90, 20);
        employees.add(wb1);

        System.out.println(calcTotalSalary(employees));
    }
}
