package Exercise4;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Double> swimTimes = new ArrayList<>();
        Swimmer s = new Swimmer("Sir Swimalot", "Sea swimmers", LocalDate.of(1901, 12, 31), swimTimes);
        swimTimes.add(28.56);
        swimTimes.add(54.12);
        swimTimes.add(68.67);
        swimTimes.add(35.34);

        System.out.println("Best time");
        System.out.println(s.bestTime());
        System.out.println();

        System.out.println("Average  time");
        System.out.println(s.averageOfTime());
        System.out.println();

        System.out.println("Average time without the worst time");
        System.out.println(s.averageWithoutWorstTime());
    }
}
