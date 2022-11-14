package Exercise2;

import java.util.ArrayList;

public class App {
    public static double calcTotalSalary(ArrayList<Mechanic> Mechanics) {
        double sum = 0;
        for (Mechanic m :Mechanics) {
            sum += m.calcSalary();
        }
        return sum;
    }
    public static void main(String[] args) {
        ArrayList<Mechanic> Mechanics = new ArrayList<>();

        Mechanic m1 = new Mechanic("Bob", "Syrrænvænget 33", 1987, 150.0);
        Mechanics.add(m1);

        Foreman f1 = new Foreman("F1", "uiguge", 1950, 150.0, 1960, 190.0);
        Mechanics.add(f1);

        Surveyor s1 = new Surveyor("S1", "ussdog", 1990, 124.3, 60);
        Mechanics.add(s1);

        System.out.println(calcTotalSalary(Mechanics));
    }
}
