package Exercise4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {
        TrainingPlan t = new TrainingPlan('A', 22, 5);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        t.createSwimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        t.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        t.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        for (Swimmer s: t.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen");
        }

        t.removeSwimmer("Mikkel", "AIA-Tranbjerg");

        System.out.println();
        for (Swimmer s: t.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen");
        }
    }
    
}
